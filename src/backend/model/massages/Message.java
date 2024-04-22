package backend.model.massages;

import backend.enums.MessageType;
import backend.model.BaseModel;

public class Message extends BaseModel {

    private String text;
    private String senderId;
    private String chatId;
    private boolean state;
    private MessageType type;

    public Message(String text, String senderId, String chatId, MessageType type) {
        this.text = text;
        this.senderId = senderId;
        this.chatId = chatId;
        this.state = false;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
