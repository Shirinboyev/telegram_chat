package ui.view.contact;

import backend.enums.MessageType;
import backend.model.chat.Chat;
import backend.model.massages.Message;
import backend.model.user.User;
import backend.service.chatService.ChatService;
import backend.service.chatService.ChatServiceImp;
import backend.service.contact.ContactService;
import backend.service.contact.ContactServiceImp;
import backend.service.messageService.MessageService;
import backend.service.messageService.MessageServiceImp;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;

import java.util.List;

import ui.FrontEnd;

import static ui.utils.Utils.*;

public class ContactView {
    static UserService userService = UserServiceImp.getInstance();
    static ContactService contactService = ContactServiceImp.getInstance();
    static ChatService chatService = ChatServiceImp.getInstance();
    static MessageService messageService = MessageServiceImp.getInstance();
    public static void search() {
        String name = enterStr("Name: ");
        List<User> users= userService.findByName(name);
        int i=1;
        for (User user : users) {
            System.out.println(i++ +". "+user.getName());
        }
        int index = enterInt("Choose: ")-1;
        if(index<0 || index>users.size()) {
            System.out.println("Please enter a valid index");
            return;
        }

        sendMessage(users, index);
    }

    private static void sendMessage(List<User> users, int index) {
        String id = users.get(index).getId();
        Chat chat = chatService.getOrCreate(FrontEnd.currentUser.getId(), id);
        String text = enterStr("Text: ");
        Message message = new Message(text, MessageType.USER, chat.getId(), id);
        boolean isWorked = messageService.add(message);
        notificationMessage("Message","sent",isWorked);
    }
}