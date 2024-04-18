package backend.service.userService;

import backend.dto.LoginDto;
import backend.model.user.User;

import java.util.List;

public interface UserService {
    static User signIn(LoginDto userLogin, List<User> users) {
        return null;
    }
    void deleteGroup(String groupId);
    User getGroup(String id);
    List<User> getGroupList();
    boolean createGroup();
    boolean createContact();


}
