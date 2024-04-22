package ui.view.group;

import backend.enums.MessageType;
import backend.enums.Role;
import backend.enums.Type;
import backend.model.chat.Chat;
import backend.model.group.Group;
import backend.model.group.GroupUser;
import backend.model.massages.Message;
import backend.model.user.User;
import backend.service.chatService.ChatService;
import backend.service.chatService.ChatServiceImp;
import backend.service.contact.ContactService;
import backend.service.contact.ContactServiceImp;
import backend.service.groupService.GroupService;
import backend.service.groupService.GroupServiceImp;
import backend.service.groupService.groupOfUserService.GroupOfUserService;
import backend.service.groupService.groupOfUserService.GroupOfUserServiceImp;
import backend.service.messageService.MessageService;
import backend.service.messageService.MessageServiceImp;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;
import ui.FrontEnd;
import ui.utils.Utils;


import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static ui.FrontEnd.currentUser;
import static ui.utils.Utils.*;

public class GroupView {
    static ChatService chatService = ChatServiceImp.getInstance();
    static GroupService groupService = GroupServiceImp.getInstance();
    static MessageService messageService = MessageServiceImp.getInstance();
    static UserService userService = UserServiceImp.getInstance();
    static GroupOfUserService groupOfUserService = GroupOfUserServiceImp.getInstance();
    static ContactService contactService = ContactServiceImp.getInstance();


    public static void methods() throws Exception {
        do {
            System.out.print("1. Create\n2. Groups  \n3. Join\n0. Exit \n");
            Integer choose;
            choose = Utils.enterInt("choose: ");
            switch (choose){
                case 1 -> createGrop();
                case 2 -> sentMessage();
                case 3 -> joinGr();
                case 0 -> {
                    return;
                }

            }

        }while (true);

    }

    private static void joinGr() throws Exception{
        String search = enterStr("Search: ");
        System.out.println("Searching...");
        TimeUnit.SECONDS.sleep(3);
        List<Group> groups = groupService.findByName(search);
        if (groups == null) return;
        int i = 1;
        for (Group group : groups)
            System.out.printf("%d. %s%n",i++,group);
            int index = enterInt("Choose: ")-1;
            if (index > groups.size() || index < 0)
                return;
            Group group = groups.get(index);
        if (Objects.equals(group.getUserId(), currentUser.getId())) {
            System.out.println( "You are already subscribed" );
            return;
        }
        boolean isWorked = groupOfUserService.add(new GroupUser(currentUser.getId(), group.getId()));
        if (isWorked)
            messageService.add(new Message("Joined group", group.getId(), chatService.getOrCreate(currentUser.getId(), group.getId(), MessageType.GROUP).getId(), MessageType.GROUP));
        notificationMessage("Group", "joined", isWorked);


    }

    private static void sentMessage() {
        while (true) {
            List<Group> groupsOfUser = groupService.getGroupsOfUser(currentUser.getId());
            if (groupsOfUser.isEmpty()) {
                return;
            }
            String groupId = chooseGroup(groupsOfUser);

            if (groupId == null) {
                return;
            }

            groupsMenu(groupId);
        }
    }
    private static void menu() {
        System.out.println("""
                1. Send message
                2. Exit from group
                3. Rename group
                4. Delete group
                    """);
        System.out.println("\n0. Go back");
    }

    private static void groupsMenu(String groupId) {
        while (true) {
            menu();

            switch (Utils.enterInt("choose : ")) {
                case 1 -> sendMessageToGroup(groupId);
                case 2 -> {
                    exitFromGroup(groupId);
                    return;
                }
                case 3 -> {
                        renameGroup(groupId);
                }
                case 4 -> {
                        deleteGroup(groupId);
                        return;
                }
                case 5 ->{
                        addAdmin(groupId);
                        return;
                }
                case 0 -> {
                    return;
                }
            }

        }
    }

    private static void addAdmin(String groupId) {
        List<User> members = groupOfUserService.getMembers(groupId,currentUser.getId());
        showUsers(members);

        int index = Utils.enterInt("Choose (0 - exit) : ") - 1;

        if (index == -1 || index >= members.size()) {
            return;
        }

        User users = members.get(index);

        GroupUser groupUsers = groupOfUserService.getByUserId(users.getId());
        groupUsers.setRole(Role.USER);
        System.out.println("Successfully");
    }

    private static void showUsers(List<User> members) {
        int i = 1;
        System.out.println("Members : ");
        for (User member : members) {
            System.out.println(i++ + ". " + member);
        }
        System.out.println("==================");

    }

    private static void renameGroup(String groupId) {
        Group group = groupService.get(groupId);

        group.setName(Utils.enterStr("Enter new name : " + group.getName() + " --> "));

        System.out.println("Successfully changed");
    }

    private static void deleteGroup(String groupId) {
        groupService.deleteById(groupId);

        groupOfUserService.deleteAllMembers(groupId);
    }

    private static void exitFromGroup(String groupId) {


    }

    private static void sendMessageToGroup(String groupId) {
        Chat chat = chatService.getOrCreate(currentUser.getId(),groupId, MessageType.GROUP);
        while (true) {
            showHistory(groupId);
            String text = enterStr("[0.BACK] Text: ");
            if (text.equals("0"))
                return;
            boolean add = messageService.add(new Message(text, groupId, chat.getId(), MessageType.GROUP));
            notificationMessage("Message " ,"send",add);
        }
    }

    private static void showHistory(String groupId) {
        String chatId = chatService.getOrCreate(currentUser.getId(),groupId,MessageType.GROUP).getId();
        List<Message> messages = messageService.getGroupMessage(chatId,groupId);
        for (Message message : messages) {
            Chat chat = chatService.get(message.getChatId());
            if(chat.getId1().equals(currentUser.getId())){
                System.out.printf("""
                                        %s
                                        %s
                        """.formatted(message.getText(),message.getTime().format(DateTimeFormatter.ofPattern("HH:mm"))));
            }else {
                System.out.printf("""
                        %s
                        %s
                        %s
                        """.formatted(userService.get(chat.getId1()).getName()
                        ,message.getText(),message.getTime().format(DateTimeFormatter.ofPattern("HH:mm"))));
            }
        }
    }

    private static String chooseGroup(List<Group> groups) {
        showGroups(groups);

        int index = Utils.enterInt("Choose (0 - exit) : ") - 1;

        if (index != -1) {
            return groups.get(index).getId();
        }

        return null;
    }

    private static void showGroups(List<Group> groups) {
        int i = 1;
        System.out.println("Groups : ");
        for (Group group : groups) {
            System.out.println(i++ + ". " + group + " | members : " + groupOfUserService.getCountOfMembers(group.getId()));
        }
        System.out.println("====================");
    }



    private static void createGrop() {
        String name = enterStr("Name");
        Group group = new Group(currentUser.getId(), name);
        boolean isWorked = groupService.add(group);
        GroupUser member = new GroupUser(currentUser.getId(), group.getId());
        member.setRole(Role.ADMIN);
        groupOfUserService.add(member);
        notificationMessage("Group", "created", isWorked);


    }







}
