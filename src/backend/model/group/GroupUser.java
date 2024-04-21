package backend.model.group;

import backend.enums.Role;
import backend.model.baseModel.BaseModel;

public class GroupUser extends BaseModel {
    private final String userId;
    private final String groupId;
    private Role isAdmin;

    public GroupUser(String userId, String groupId) {
        this.userId = userId;
        this.groupId = groupId;
        this.isAdmin = Role.USER;
    }


    public void setIsAdmin(Role isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public Role getIsAdmin() {
        return isAdmin;
    }



}