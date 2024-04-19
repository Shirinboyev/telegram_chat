package backend.model.contact;

import backend.model.baseModel.BaseModel;

public class Contact  extends BaseModel implements  Cloneable {
    private final  String userId;
    private String contactId;
    private  String name;

    public Contact(String id, String userId, String contactId, String name) {
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
