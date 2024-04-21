package backend.service.groupService.groupOfUserService;

import backend.model.group.GroupUser;
import backend.model.user.User;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GroupOfUserServiceImp implements GroupOfUserService{

    UserService userServiceImpl = UserServiceImp.getInstance();

    private static GroupOfUserService groupUserService;
    static UserService userService = UserServiceImp.getInstance();

    private List<GroupUser> groupUsers;

    private static GroupOfUserService groupOfUserService;
    public static GroupOfUserService getInstance() {
        if( groupOfUserService == null ){
            groupOfUserService = new GroupOfUserServiceImp();
        }
        return groupOfUserService;
    }

    public GroupOfUserServiceImp() {
        this.groupUsers = new ArrayList<>();
    }

    @Override
    public boolean add(GroupUser o) {
        return groupUsers.add(o);
    }

    @Override
    public boolean delete(GroupUser groupUser) {
        return groupUsers.remove(groupUser);
    }

    @Override
    public GroupUser get(String id) {
        for (GroupUser groupUser : groupUsers) {
            return groupUser;
        }
        return null;
    }

    @Override
    public List<GroupUser> getList() {
        return groupUsers;
    }

    @Override
    public int getCountOfMembers(String groupId) {
        int count = 0;
        for (GroupUser groupUser : groupUsers) {
            if (groupUser.getGroupId().equals(groupId)) {
                count++;
            }
        }
        return count;
    }


    @Override
    public List<User> getMembers(String groupId, String userId) {
        List<User> users = new ArrayList<>();
        for (GroupUser groupUser : groupUsers) {
            if (groupUser.getGroupId().equals(groupId) && !groupUser.getUserId().equals(userId)) {
                users.add(userService.get(groupUser.getUserId()));
            }
        }
        return users;
    }

    @Override
    public void deleteByMemberId(String userId, String groupId) {
        groupUsers.removeIf(groupUsers1 ->
                groupUsers1.getUserId().equals(userId) &&
                        groupUsers1.getGroupId().equals(groupId));
    }

 /*   @Override
    public boolean isAdmin(String userId, String groupId) {
        for (GroupUser groupUser : groupUsers) {
            if (groupUser.getUserId().equals(userId) && groupUser.getGroupId().equals(groupId) && groupUser.ge()) {
                return true;
            }
        }
        return false;
    }*/

    @Override
    public void deleteAllMembers(String groupId) {
        groupUsers.removeIf(groupUsers1 -> groupUsers1.getGroupId().equals(groupId));
    }

    @Override
    public List<GroupUser> getListOfGroupsByUserId(String userId) {
        List<GroupUser> groupUsersList = new ArrayList<>();
        for (GroupUser groupUser : groupUsers) {
            if (userId.equals(groupUser.getUserId())) {
                groupUsersList.add(groupUser);
            }
        }
        return groupUsersList;
    }
    @Override
    public void deleteByUserId(String userId) {
        groupUsers.removeIf(groupUsers1 -> groupUsers1.getUserId().equals(userId));
    }

    @Override
    public GroupUser getByUserId(String userId) {
        for (GroupUser groupUser : groupUsers) {
            if (groupUser.getUserId().equals(userId)) {
                return groupUser;
            }
        }
        return null;
    }


}
