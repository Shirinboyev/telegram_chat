package backend.model.contact;

import backend.model.BaseModel;

public class Contact  extends BaseModel {
    private final  String userId;
    private String contactId;
    private  String name;

    public Contact(String userId,String contactId,String name) {
        this.userId = userId;
        this.contactId = contactId;
        this.name = name;
    }


    public String getUserId() {
        return userId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
