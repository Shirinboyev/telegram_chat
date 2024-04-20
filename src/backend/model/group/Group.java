package backend.model.group;

import backend.enums.Type;
import backend.model.baseModel.BaseModel;

public class Group extends BaseModel {
    private final String userId;
    private final String groupId;
    private boolean admin;

    public Group(String id, String userId, String groupId, boolean admin) {
        this.userId = userId;
        this.groupId = groupId;
        this.admin = admin;
    }

    public static void methods() {

    }

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public boolean isOrAdmin() {
        return admin;
    }

    public void setOrAdmin(boolean orAdmin) {
        this.admin = orAdmin;
    }
}
