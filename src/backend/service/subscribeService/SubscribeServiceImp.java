package backend.service.subscribeService;

import backend.model.channel.Subscribe;
import backend.model.user.User;
import backend.service.chatService.ChatService;
import backend.service.chatService.ChatServiceImp;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;

import java.util.ArrayList;
import java.util.List;

public class SubscribeServiceImp implements SubscribeService {
    UserService userService = UserServiceImp.getInstance();
    private static SubscribeService subscribeService;

    private List<Subscribe> subscribeUsers;

    public SubscribeServiceImp() {
        this.subscribeUsers = new ArrayList<> ();
    }

    public static  SubscribeService getInstance(){
        if (subscribeService==null){
            subscribeService= new SubscribeServiceImp ();
        }
        return subscribeService;
    }


    @Override
    public boolean add(Subscribe o) {
        return subscribeUsers.add(o);
    }

    @Override
    public boolean delete(Subscribe subscribe) {
        return subscribeUsers.remove(subscribe);

    }

    @Override
    public Subscribe get(String id) {
        for (Subscribe subscribeUser : subscribeUsers) {
            if (subscribeUser.getId().equals(id)) {
                return subscribeUser;
            }
        }
        return null;
    }

    @Override
    public List<Subscribe> getList() {
        return subscribeUsers;

    }

    @Override
    public int countMembers(String channelId) {
        return 0;
    }

    @Override
    public boolean isAdmin(String userId, String channelId) {

        return false;
    }

    @Override
    public void deleteMember(String userId, String channelId) {

    }

    @Override
    public List<User> getSubscribersWithoutAdmins(String channelId) {
        return null;
    }

    @Override
    public Subscribe getByMemberId(String userId, String channelId) {
        return null;
    }

    @Override
    public List<User> getAdminsWithoutMe(String channelId, String userId) {
        return null;
    }

    @Override
    public void deleteAllMembers(String channelId) {

    }

    @Override
    public void deleteByUserId(String userId) {

    }

    @Override
    public boolean isMember(String userId, String channelId) {
        return false;
    }
}
