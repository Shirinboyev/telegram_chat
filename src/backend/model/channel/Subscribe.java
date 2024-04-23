package backend.model.channel;

import backend.enums.Role;
import backend.enums.Type;
import backend.model.BaseModel;

public class Subscribe extends BaseModel {
    private String name;
    private String ownerId;
    private Type type;

    public Subscribe(String name, String ownerId, Type type) {
        this.name = name;
        this.ownerId = ownerId;
        this.type = type;
    }

    public Subscribe(String id, String id1) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Role type) {
        this.type = type;
    }
}
