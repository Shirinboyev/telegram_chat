package backend.service.channelService.channelUserSerrvice;

import backend.model.channel.Channel;
import backend.model.user.User;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;

import java.util.ArrayList;
import java.util.List;

public class ChannelUserServiceImp implements ChannelUserService{
    UserService userService = UserServiceImp.getInstance();
    private static ChannelUserService channelUserService;

    private List<Channel> channelUsers;

    public ChannelUserServiceImp() {
        this.channelUsers = new ArrayList<> ();
    }


    @Override
    public boolean add(Channel o) {
        return channelUsers.add(o);
    }

    @Override
    public boolean delete(Channel channel) {
        return channelUsers.remove(channel);

    }

    @Override
    public Channel get(String id) {
        for (Channel channelUser : channelUsers) {
            if (channelUser.getId().equals(id)) {
                return channelUser;
            }
        }
        return null;
    }

    @Override
    public List<Channel> getList() {
        return channelUsers;

    }

    @Override
    public int countMembers(String channelId) {
        int count = 0;
        for (Channel channelUser : channelUsers) {
            if (channelUser.getChannelId().equals(channelId)) {
                count++;
            }
        }
        return count;


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
    public Channel getByMemberId(String userId, String channelId) {
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
