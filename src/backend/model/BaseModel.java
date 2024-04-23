package backend.model;

import backend.enums.Role;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseModel {
    private final String id;
    private final LocalDateTime time;

    public BaseModel() {
        this.id = UUID.randomUUID().toString();
        this.time = LocalDateTime.now();
    }

    public String getId() {

        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

}
