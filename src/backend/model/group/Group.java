package backend.model.group;

import backend.enums.Type;
import backend.model.baseModel.BaseModel;

public class Group extends BaseModel {
    private final String userId;
    private final String groupId;
    private boolean orAdmin;

    public Group(String id, String userId, String groupId, boolean orAdmin) {
        this.userId = userId;
        this.groupId = groupId;
        this.orAdmin = orAdmin;
    }

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public boolean isOrAdmin() {
        return orAdmin;
    }

    public void setOrAdmin(boolean orAdmin) {
        this.orAdmin = orAdmin;
    }
}
