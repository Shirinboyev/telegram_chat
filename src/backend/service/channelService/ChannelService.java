package backend.service.channelService;

import backend.model.channel.Subscribe;
import backend.service.BaseService;

import java.util.List;

public interface ChannelService extends BaseService<Subscribe> {
   List<Subscribe> getChannelsOfUser(String userId);

   void  deleteById(String channelId);

   List<Subscribe> getChannelsByWord(String search);

   boolean issUniqueName(String name);
}
