package io.view.group;

import backend.enums.Type;
import backend.model.group.Group;
import backend.model.group.GroupUser;
import backend.model.user.User;
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
import io.FrontEnd;
import io.utils.Utils;
import jdk.jshell.execution.Util;

import java.util.List;

import static io.FrontEnd.currentUser;

public class GroupView {
    static GroupService groupService = GroupServiceImp.getInstance();
    static MessageService messageService = MessageServiceImp.getInstance();
    static UserService userService = UserServiceImp.getInstance();
    static GroupOfUserService groupOfUserService = GroupOfUserServiceImp.getInstance();
    static ContactService contactService = ContactServiceImp.getInstance();


    public static void methods() {
        System.out.print("1. Sent Message: \n");
        System.out.print("2. Create Group: \n");
        System.out.print("0. Exit: \n");
        Integer choose;
        do {
            choose = Utils.enterInt("choose: ");
            switch (choose){
                case 1 -> sentMessage();
                case 2 -> createGrop();
                case 0 -> {
                    return;
                }

            }

        }while (true);

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
    private static void menu(boolean admin) {
        System.out.println("""
                1. Send message
                2. Exit from group
                """);

        if (admin) {
            System.out.print("""
                    3. Rename group
                    4. Delete group
                    """);
        }

        System.out.println("\n0. Go back");
    }

    private static void groupsMenu(String groupId) {
        while (true) {
            boolean admin = groupOfUserService.isAdmin(currentUser.getId(), groupId);

            menu(admin);

            switch (Utils.enterInt("choose : ")) {
                case 1 -> sendMessageToGroup(groupId);

                case 2 -> {
                    exitFromGroup(groupId);
                    return;
                }

                case 3 -> {
                    if (admin) {
                        renameGroup(groupId);
                    }
                }

                case 4 -> {
                    if (admin) {
                        deleteGroup(groupId);
                        return;
                    }
                }
                case 5 ->{
                    if (admin){
                        addAdmin(groupId);
                        return;
                    }
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
        groupUsers.setAdmin(true);
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
        if (groupOfUserService.isAdmin(currentUser.getId(), groupId)) {
            if (groupOfUserService.countAdmins(groupId) == 1) {
                System.out.println(" faqat siz adminsiz ! kimnidur admin qilib chiqishingiz kerak ");
                return;
            }
        }
        groupOfUserService.deleteByMemberId(currentUser.getId(), groupId);


    }

    private static void sendMessageToGroup(String groupId) {
        while (true) {
            List<Group> groupsOfUser = groupService.getGroupsOfUser(currentUser.getId());
            if (groupsOfUser.isEmpty()) {
                return;
            }
            String groupid = chooseGroup(groupsOfUser);

            if (groupid == null) {
                return;
            }

            groupsMenu(groupid);
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
        String name = Utils.enterStr("Enter name : ");

        if (!groupService.isUnique(name)) {
            System.out.println("There is not unique name ! Do you want try again ? 1 yes / 0 no");

            if (Utils.enterInt("Choice : ") == 1) {
                createGrop();
            }
        } else {
            Type type = chooseType();
            while (type == null) {
                System.out.println("There is wrong type ! Do you want try again ? 1 yes / 0 no");
                if (Utils.enterInt("Choice : ") != 1) {
                    return;
                }
                type = chooseType();

            }
            Group groups = new Group(name, type);
            groupService.add(groups);

            groupOfUserService.add(new GroupUser(currentUser.getId(), groups.getId(), true));
            System.out.println("Successfully");

        }

    }

    private static Type chooseType() {
        System.out.println("""
                1. Private
                2. Public
                """);

        int type = Utils.enterInt("Choose : ");

        Type[] types = Type.values();

        if (type > types.length) {
            return null;
        }
        return types[type - 1];
    }




}
