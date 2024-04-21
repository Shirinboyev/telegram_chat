package backend.model.group;

import backend.enums.Role;
import backend.model.BaseModel;

public class GroupUser extends BaseModel {
    private final String userId;
    private final String groupId;
    private Role role;

    public GroupUser(String userId, String groupId) {
        this.userId = userId;
        this.groupId = groupId;
        this.role = Role.USER;
    }


    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public Role getRole() {
        return role;
    }



}