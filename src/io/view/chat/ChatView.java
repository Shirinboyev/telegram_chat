package io.view.chat;

import backend.service.chatService.ChatService;
import backend.service.chatService.ChatServiceImp;
import backend.service.contact.ContactService;
import backend.service.contact.ContactServiceImp;
import backend.service.messageService.MessageService;
import backend.service.messageService.MessageServiceImp;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;
import io.utils.Utils;

public class ChatView {
    static ChatService chatService = ChatServiceImp.getInstance();
    static UserService userService = UserServiceImp.getInstance();
    static MessageService messageService = MessageServiceImp.getInstance();
    static ContactService contactService = ContactServiceImp.getInstance();

    public static void methods() {
        Integer choice;

        do {
            menu();
            choice = Utils.enterInt("choose : ");

            switch (choice) {
                case 1 -> sendMessage();
            }
        } while (choice != 0);
    }


    private static void sendMessage() {

    }


    private static void menu() {
        System.out.println("""
                Menu :
                1. Send message to any chat
                                
                0. Go back
                """);
    }
}
