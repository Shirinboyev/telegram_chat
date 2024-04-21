
package backend.service.userService;

import backend.dto.LoginDto;
import backend.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImp implements UserService {
    private static UserService userService;

    private final List<User> userList;

    public UserServiceImp() {
        this.userList = new ArrayList<>();
        this.userList.add(new User("zubayr", "zubayr_ibn_avvam", 935513634, "gayrat3634"));
        this.userList.add(new User("gayrat", "shirinboyev", 7777, "gayrat3634"));
    }
    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserServiceImp();
        }

        return userService;
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
    public boolean signUp(User user) {
        return userList.add(user);
    }

    @Override
    public boolean add(User o) {
        return userList.add(o);
    }

    @Override
    public boolean delete(User user) {
        return userList.remove(user);
    }

    @Override
    public User get(String id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getList() {
        return userList;
    }
    @Override
    public void deleteGroup(String groupId) {
        User group = null;
        for (User user : userList) {
            if (user.getId().equals(groupId)) {
                group = user;
                break;
            }
        }

        if (group != null) {
            userList.remove(group);
        }
    }

    @Override
    public User getGroup(String id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getGroupList() {
        List<User> groupList = new ArrayList<>();
        for (User user : userList) {
            if (user.isGroup()) {
                groupList.add(user);
            }
        }
        return groupList;
    }

    @Override
    public boolean createGroup(String name) {
        User newGroup = new User(name, true);

        userList.add(newGroup);

        return true;
    }

    @Override
    public boolean createContact(String name, String phoneNumber) {
        User newContact = new User(name, phoneNumber);
        userList.add(newContact);
        return true;
    }

    @Override
    public User getContact() {
        return (User) userList;
    }

    @Override
    public String getUserByNumber(String number) {
        for (User user : userList) {
            if (user.getPhoneNumber().equals(number)) {
                return user.getId();
            }
        }
        return null;
    }



}