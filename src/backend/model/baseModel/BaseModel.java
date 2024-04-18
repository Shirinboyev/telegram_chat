package backend.model.baseModel;

import java.io.Serializable;
import java.util.UUID;

public abstract class BaseModel {
    private String id;

    public BaseModel() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
