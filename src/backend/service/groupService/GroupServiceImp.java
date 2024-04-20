package backend.service.groupService;

public class GroupServiceImp implements GroupService{
    private static GroupService groupService;

    public static GroupService getInstance() {

        if (groupService == null) {
            groupService = new GroupServiceImp();
        }

        return groupService;
    }
}
