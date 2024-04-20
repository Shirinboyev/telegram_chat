package io.view.group;

import backend.service.contact.ContactService;
import backend.service.contact.ContactServiceImp;
import backend.service.groupService.GroupService;
import backend.service.groupService.GroupServiceImp;
import backend.service.messageService.MessageService;
import backend.service.messageService.MessageServiceImp;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;

public class Group {
    static GroupService groupService = GroupServiceImp.getInstance();
    static MessageService messageService = MessageServiceImp.getInstance();
    static UserService userService = UserServiceImp.getInstance();
    static GroupUserService groupUserService = GroupUserServiceImpl.getInstance();
    static ContactService contactService = ContactServiceImp.getInstance();

}
