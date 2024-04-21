package backend.model.channel;

import backend.enums.Type;
import backend.model.BaseModel;

public class Subscribe extends BaseModel {
    private String name;
    private String description;
    private final Type type;
    private String ownerId;


    public Subscribe(String name, String description, Type type, String ownerId) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String getId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
