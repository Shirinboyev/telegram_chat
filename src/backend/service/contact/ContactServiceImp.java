package backend.service.contact;

import backend.service.chatService.ChatService;

public class ContactServiceImp implements ContactService{
    private static ContactService contactService;

    public static ContactService getInstance(){
        if (contactService == null){
            contactService = new ContactServiceImp();
        }
        return contactService;
    }
}
