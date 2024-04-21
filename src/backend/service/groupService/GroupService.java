package backend.service.groupService;

import backend.model.group.Group;
import backend.service.baseService.BaseService;

import java.util.List;

public interface GroupService extends BaseService<Group> {

    List<Group> getGroupsOfUser(String userId);

    void deleteById(String groupId);

    boolean isUnique(String name);

}
