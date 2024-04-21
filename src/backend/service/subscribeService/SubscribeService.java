package backend.service.subscribeService;

import backend.model.channel.Subscribe;
import backend.model.user.User;
import backend.service.BaseService;

import java.util.List;

public interface SubscribeService extends BaseService<Subscribe> {

    int countMembers(String channelId);

    boolean isAdmin(String userId, String channelId);

    void deleteMember(String userId, String channelId);

    List<User> getSubscribersWithoutAdmins(String channelId);

    Subscribe getByMemberId(String userId, String channelId);

    List<User> getAdminsWithoutMe(String channelId, String userId);

    void deleteAllMembers(String channelId);

    void deleteByUserId(String userId);

    boolean isMember(String userId, String channelId);
}
