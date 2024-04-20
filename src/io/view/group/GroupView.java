package io.view.group;

import backend.model.group.Group;
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
import io.utils.Utils;
import jdk.jshell.execution.Util;

public class GroupView {
    static GroupService groupService = GroupServiceImp.getInstance();
    static MessageService messageService = MessageServiceImp.getInstance();
    static UserService userService = UserServiceImp.getInstance();
    static GroupOfUserService groupOfUserService = GroupOfUserServiceImp.getInstance();
    static ContactService contactService = ContactServiceImp.getInstance();


    public static void methods() {
        Integer choose;
        do {
            choose = Utils.enterInt("choose: ");
            switch (choose){
                case 1 -> sentMessage();
                case 2 -> createGrop();
            }

        }while (true);

    }

    private static void sentMessage() {

    }

    private static void createGrop() {
        String name = Utils.enterStr("Enter name : ");


    }
}
