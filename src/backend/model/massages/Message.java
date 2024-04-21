package backend.model.massages;

import backend.enums.MessageType;
import backend.model.BaseModel;

public class Message extends BaseModel {

    private String text;
    private final MessageType type;
    private  final String chatId;
    private  final String toId;
    private boolean isRead;


    public Message(String text, MessageType type, String chatId, String toId) {
        this.text = text;
        this.type = type;
        this.chatId = chatId;
        this.toId = toId;
        this.isRead = false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChatId() {
        return chatId;
    }

    public MessageType getType() {
        return type;
    }

    public String getToId() {
        return toId;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
