package backend.model;

import backend.enums.Type;

public class Channel extends BaseModel {
    private String name;
    private String description;
    private final Type type;

    public Channel(String id, Type type, String description, String name) {
        super (id);
        this.type = type;
        this.description = description;
        this.name = name;
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
}
