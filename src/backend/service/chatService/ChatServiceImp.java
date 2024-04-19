package backend.service.chatService;

import backend.dto.LoginDto;
import backend.model.user.User;
import backend.service.userService.UserService;

import java.util.List;

public abstract class ChatServiceImp implements UserService {

    private List<User> users;

    public ChatServiceImp(List<User> users) {
        this.users = users;
    }


    @Override
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void signUp(User user) {
        users.add(user);
    }


    @Override
    public List<User> getGroupList() {
        return users;
    }


}
