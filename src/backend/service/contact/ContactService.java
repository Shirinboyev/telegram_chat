package backend.service.contact;

import backend.model.contact.Contact;
import backend.service.BaseService;

import java.util.List;

public interface ContactService extends BaseService<Contact> {
    boolean isExist(String id, String contactId);
    List<Contact> getContacts(String userId);
    Contact getContact(String userId, String contactId);
}
