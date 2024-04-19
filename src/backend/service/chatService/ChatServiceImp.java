package backend.service.chatService;

import backend.dto.LoginDto;
import backend.model.user.User;
import backend.service.userService.UserService;

import java.util.List;

public class ChatServiceImp implements UserService {
    @Override
    public User login(LoginDto login, List<User> users) {
        return null;
    }

    @Override
    public User login(LoginDto login) {
        return null;
    }

    @Override
    public void signUp(User user) {

    }

    @Override
    public void deleteGroup(String groupId) {

    }

    @Override
    public User getGroup(String id) {
        return null;
    }

    @Override
    public List<User> getGroupList() {
        return List.of ( );
    }

    @Override
    public boolean createGroup() {
        return false;
    }

    @Override
    public boolean createContact() {
        return false;
    }

    @Override
    public User getContact() {
        return null;
    }
}
