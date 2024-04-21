package backend.model.channel;

import backend.enums.Type;
import backend.model.baseModel.BaseModel;

public class Channel extends BaseModel {
    private String name;
    private String description;
    private final Type type;
    private String id;
    private String channelId;


    public Channel(String name, String description, Type type, String id,String channelId) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.id = id;
        this.channelId=channelId;
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
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
