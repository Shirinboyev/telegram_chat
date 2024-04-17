package backend.model.group;

import backend.enums.Type;
import backend.model.baseModel.BaseModel;

public class GroupUser extends BaseModel {
    private final String userId;
    private final String groupId;
    private boolean orAdmin;

    public GroupUser(String id, String userId, String groupId, boolean orAdmin) {
        super (id);
        this.userId = userId;
        this.groupId = groupId;
        this.orAdmin = orAdmin;
    }

    public void setAdmin(boolean admin) {
        orAdmin = admin;
    }

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public boolean orAdmin() {
        return orAdmin;
    }
}
