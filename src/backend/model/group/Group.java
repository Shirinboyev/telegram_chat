package backend.model.group;

import backend.enums.Type;
import backend.model.BaseModel;

public class Group extends BaseModel {
    private String name;
    private final Type type;

    public Group(String name, String type) {
        this.name = name;
        this.type = Type.valueOf(type);

    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
