
package backend.service.userService;

import backend.dto.LoginDto;
import backend.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImp implements UserService {

    private List<User> userList;

    public UserServiceImp(LoginDto list) {
        this.userList = new ArrayList<>();
        this.userList.add(new User("zubayr", "zubayr_ibn_avvam", 935513634, "gayrat3634"));
    }

    @Override
    public User login(LoginDto login, List<User> users) {
        return null;
    }

    @Override
    public User login(LoginDto login) {
        for (User user1 : userList) {
            if (login.number().equals(user1.getPhoneNumber()) && login.password().equals(user1.getPassword())) {
                return user1;
            }
        }
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
        return null;
    }

    @Override
    public boolean createGroup() {
        return false;
    }

    @Override
    public boolean createContact() {
        return true;
    }

    @Override
    public User getContact() {
        return (User) userList;
    }
}