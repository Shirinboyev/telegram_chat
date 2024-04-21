package backend.service.contact;

import backend.model.contact.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImp implements ContactService{
    private static ContactService contactService;

    private List<Contact> contact;

    public static ContactService getInstance(){
        if (contactService == null){
            contactService = new ContactServiceImp();
        }
        return contactService;
    }


    @Override
    public boolean add(Contact contactAdd) {
        return contact.add(contactAdd);
    }

    @Override
    public boolean delete(Contact contactDelete) {
        return contact.remove(contactDelete);
    }

    @Override
    public Contact get(String id) {
        for (Contact contact : contact) {
            if (contact.getId().equals (id)) {
                return contact;
            }
        }
        return null;

    }

    @Override
    public List<Contact> getList() {
        return contact;
    }

    @Override
    public boolean isExist(String id, String contactId) {
        for (Contact contact : contact) {
            if (contact.getUserId().equals(id) && contact.getId().equals(contactId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Contact> getContacts(String userId) {
        ArrayList<Contact> contactsArrayList = new ArrayList<>();
        for (Contact contact : contact) {
            if (contact.getUserId().equals(userId)) {
                contactsArrayList.add(contact);
            }
        }
        return contactsArrayList;
    }

    @Override
    public Contact getContact(String userId, String contactId) {
        for (Contact getContact : contact) {
            if (getContact.getUserId().equals(userId) && getContact.getContactId().equals(contactId)) {
                return getContact;
            }
        }
        return null;
    }
}
