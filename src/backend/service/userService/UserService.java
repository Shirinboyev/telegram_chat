package backend.service.userService;

import backend.dto.LoginDto;
import backend.model.user.User;

import java.util.List;

public interface UserService {

    User login(LoginDto login, List<User> users);

   /* User login(String username, String password);

    User login(LoginDto login);*/

    User login(LoginDto login);

    User login(String username, String password);

    void signUp(User user);
    void deleteGroup(String groupId);
    User getGroup(String id);
    List<User> getGroupList();
    boolean createGroup();
    boolean createContact();
    User getContact();


}
