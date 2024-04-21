package backend.service.channelService;

import backend.enums.Type;
import backend.model.channel.Channel;
import backend.service.chatService.ChatService;

import java.util.ArrayList;
import java.util.List;

public class ChannelServiceImp implements ChannelService {

    private static ChannelService channelService;
    private List<Channel> channels;

    public ChannelServiceImp() {
        this.channels = new ArrayList<> ();
    }

    public static ChannelService getInstance(){
        if (channelService == null){
            channelService = new ChannelServiceImp();
        }
        return channelService;
    }

    @Override
    public boolean add(Channel o) {
        return channels.add(o);
    }

    @Override
    public boolean delete(Channel channel) {
        return channels.remove (channel);
    }

    @Override
    public Channel get(String id) {
        for (Channel channel : channels) {
            if (channel.getId().equals(id)) {
                return channel;
            }
        }
        return null;
    }

    @Override
    public List<Channel> getList() {
        return channels;
    }

    @Override
    public List<Channel> getChannelsOfUser(String userId) {
        List<Channel> channelsList = new ArrayList<>();
        for (Channel channelUsers : channelService.getList()) {
            if (channelUsers.getId().equals(userId)) {
                channelsList.add(channelService.get(channelUsers.getId ()));
            }
        }
        return channelsList;
    }

    @Override
    public void deleteById(String channelId) {
        for (Channel channel : channels) {
            if (channel.getId().equals(channelId)) {
                channels.remove(channel);
            }
        }
    }

    @Override
    public List<Channel> getChannelsByWord(String search) {
        List<Channel> channelsList = new ArrayList<>();
        for (Channel channel : channels) {
            if (channel.getName().contains(search) && channel.getType().equals(Type.PUBLIC)) {
                channelsList.add(channel);
            }
        }
        return channelsList;
    }

    @Override
    public boolean issUniqueName(String name) {
        for (Channel channel : channels) {
            if (channel.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
}
