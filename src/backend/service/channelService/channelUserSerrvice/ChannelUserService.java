package backend.service.channelService.channelUserSerrvice;

import backend.model.channel.Channel;
import backend.model.user.User;
import backend.service.baseService.BaseService;

import java.util.List;

public interface ChannelUserService extends BaseService<Channel> {

    int countMembers(String channelId);

    boolean isAdmin(String userId, String channelId);

    void deleteMember(String userId, String channelId);

    List<User> getSubscribersWithoutAdmins(String channelId);

    Channel getByMemberId(String userId, String channelId);

    List<User> getAdminsWithoutMe(String channelId, String userId);

    void deleteAllMembers(String channelId);

    void deleteByUserId(String userId);

    boolean isMember(String userId, String channelId);
}
