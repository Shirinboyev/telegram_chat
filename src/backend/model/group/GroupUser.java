package backend.model.group;

import backend.enums.Type;
import backend.model.baseModel.BaseModel;

public class GroupUser extends BaseModel {
    private final String userId;
    private final String groupId;
    private boolean admin;

    public GroupUser(String id, String userId, String groupId, boolean admin) {
        this.userId = userId;
        this.groupId = groupId;
        this.admin = admin;
    }

    public void setAdmin(boolean admin) {
        admin = admin;
    }

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public boolean orAdmin() {
        return admin;
    }
}
