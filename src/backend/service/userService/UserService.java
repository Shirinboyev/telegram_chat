package backend.service.userService;

import backend.dto.LoginDto;
import backend.model.user.User;
import backend.service.baseService.BaseService;

import java.util.List;

public interface UserService extends BaseService<User> {
        User login(LoginDto login);

    void signUp(User user);
    void deleteGroup(String groupId);
    User getGroup(String id);
    List<User> getGroupList();
    boolean createGroup(String name);

    boolean createContact(String name, String phoneNumber);

    User getContact();

    String getUserByNumber(String number);
}
