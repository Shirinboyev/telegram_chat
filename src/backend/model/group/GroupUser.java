package backend.model.group;

import backend.model.baseModel.BaseModel;

public class GroupUser extends BaseModel {
    private final String userId;
    private final String groupId;
    private boolean isAdmin;

    public GroupUser(String userId, String groupId, boolean isAdmin) {
        this.userId = userId;
        this.groupId = groupId;
        this.isAdmin = isAdmin;
    }


    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}