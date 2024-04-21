package backend.service.groupService.groupOfUserService;

import backend.model.group.GroupUser;
import backend.model.user.User;
import backend.service.BaseService;

import java.util.List;

public interface GroupOfUserService extends BaseService<GroupUser> {
    int getCountOfMembers(String groupId);

    List<User> getMembers(String groupId, String userId);

    void deleteByMemberId(String userId, String groupId);

    void deleteAllMembers(String groupId);
    List<GroupUser> getListOfGroupsByUserId(String userId);

    void deleteByUserId(String userId);

    GroupUser getByUserId(String userId);

}
