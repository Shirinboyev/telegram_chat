package backend.service.channelService;

import backend.model.channel.Channel;
import backend.service.baseService.BaseService;

import java.util.List;

public interface ChannelService extends BaseService<Channel> {
   List<Channel> getChannelsOfUser(String userId);

   void  deleteById(String channelId);

   List<Channel> getChannelsByWord(String search);

   boolean issUniqueName(String name);
}
