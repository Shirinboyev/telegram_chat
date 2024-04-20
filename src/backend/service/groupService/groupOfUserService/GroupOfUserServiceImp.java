package backend.service.groupService.groupOfUserService;

public class GroupOfUserServiceImp implements GroupOfUserService{
    private static GroupOfUserService groupOfUserService;
    public static GroupOfUserService getInstance() {
        if( groupOfUserService == null ){
            groupOfUserService = new GroupOfUserServiceImp();
        }
        return groupOfUserService;
    }
}
