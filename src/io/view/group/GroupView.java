package io.view.group;

import backend.enums.Role;
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

import java.lang.reflect.Member;
import java.util.List;

import static io.FrontEnd.currentUser;
import static io.utils.Utils.*;

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
        groupUsers.setIsAdmin(Role.USER);
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
        String name = enterStr("name: ");
        Group group = new Group(currentUser.getId(),name);
        boolean isWorked = groupService.add(group);
        GroupUser member = new GroupUser(currentUser.getId(),group.getId());
        member.setIsAdmin(Role.ADMIN);
        groupOfUserService.add(member);
        notificationMessage("Group","created",isWorked);

    }







}
