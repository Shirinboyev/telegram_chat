package backend.service.groupService;

import backend.model.group.Group;
import backend.model.group.GroupUser;
import backend.service.groupService.groupOfUserService.GroupOfUserService;
import backend.service.groupService.groupOfUserService.GroupOfUserServiceImp;

import java.util.ArrayList;
import java.util.List;

public class GroupServiceImp implements GroupService{

    static GroupOfUserService groupUserService = GroupOfUserServiceImp.getInstance();
    private static GroupService groupService;

    private List<Group> groups;

    public GroupServiceImp() {
        this.groups = new ArrayList<>();
    }

    public static GroupService getInstance() {

        if (groupService == null) {
            groupService = new GroupServiceImp();
        }

        return groupService;
    }

    @Override
    public boolean add(Group o) {
        return groups.add(o);
    }

    @Override
    public boolean delete(Group group) {
        return groups.remove(group);
    }

    @Override
    public Group get(String groupId) {
        for (Group group : groups) {
            if (group.getId().equals(groupId)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public List<Group> getList() {
        return groups;
    }

    @Override
    public List<Group> getGroupsOfUser(String userId) {
        List<Group> groupsList = new ArrayList<>();
        List<GroupUser> listOfGroupsByUserId = groupUserService.getListOfGroupsByUserId(userId);
        if (!listOfGroupsByUserId.isEmpty()) {
            for (GroupUser groupUsersList : listOfGroupsByUserId) {
                groupsList.add(groupService.get(groupUsersList.getGroupId()));
            }
        }
        return groupsList;
    }

    @Override
    public void deleteById(String groupId) {
        groups.removeIf(group -> group.getId().equals(groupId));
    }

    @Override
    public boolean isUnique(String name) {
        for (Group group : groups) {
            if (group.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
}
