package ui.view.contact;


import backend.model.chat.Chat;
import backend.model.contact.Contact;
import backend.service.chatService.ChatService;
import backend.service.chatService.ChatServiceImp;
import backend.service.contact.ContactService;
import backend.service.contact.ContactServiceImp;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;
import ui.utils.Utils;

import static ui.FrontEnd.currentUser;

public class ContactView {
    static UserService userService = UserServiceImp.getInstance();
    static ContactService contactService = ContactServiceImp.getInstance();
    static ChatService chatService = ChatServiceImp.getInstance();

    public static void addContact() {
        String number = Utils.enterStr("Enter number : ");
        String contactId = userService.getUserByNumber(number);



                String name = Utils.enterStr("Enter name : ");
                Contact contacts = new Contact(currentUser.getId(), contactId, name);

                if (contactService.add(contacts)) {
                    System.out.println("New contact created successfully!");
                    if (chatService.getChatOfUser(currentUser.getId())==null) {
                        chatService.add(new Chat(currentUser.getId(), contactId));
                    }
        }
    }
}