package backend.model.channel;

import backend.enums.Type;
import backend.model.baseModel.BaseModel;

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
