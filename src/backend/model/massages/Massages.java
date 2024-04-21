package backend.model.massages;

import backend.enums.Type;
import backend.model.baseModel.BaseModel;

import java.time.LocalTime;

public class Massages extends BaseModel implements Cloneable {

    private String text;
    private Type type;
    private  String userId;
    private  String toId;
    private  LocalTime time;
    private boolean isRead;


    public Massages(String text, Type type, String userId, String toId, LocalTime time, boolean isRead) {
        this.text = text;
        this.type = type;
        this.userId = userId;
        this.toId = toId;
        this.time = time;
        this.isRead = isRead;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
