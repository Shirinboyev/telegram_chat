package backend.model.subscribe;

import backend.enums.Role;
import backend.model.BaseModel;

public class Subscribe extends BaseModel {
    private String userId;
    private String channelId;
    private Role role;

    public Subscribe(String userId, String channelId) {
        this.userId = userId;
        this.channelId = channelId;
        this.role = Role.USER;
    }

    public String getUserId() {
        return userId;
    }

    public String getChannelId() {
        return channelId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

