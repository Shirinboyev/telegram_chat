package backend.model.chat;

import backend.enums.MessageType;
import backend.model.BaseModel;

public class Chat extends BaseModel {
    private final  String id1;
    private final  String id2;
    private final MessageType type;

    public Chat(String id1, String id2, MessageType type) {
        this.id1 = id1;
        this.id2 = id2;
        this.type = type;
    }

    public String getId1() {
        return id1;
    }

    public String getId2() {
        return id2;
    }
}
