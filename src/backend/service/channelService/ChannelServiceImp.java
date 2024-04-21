package backend.service.channelService;

import backend.enums.Type;
import backend.model.channel.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ChannelServiceImp implements ChannelService {

    private static ChannelService channelService;
    private List<Subscribe> subscribes;
    private static ChannelServiceImp instance;
    private Map<String, Subscribe> channels;
    public ChannelServiceImp() {
        this.subscribes = new ArrayList<> ();
    }

    public static ChannelService getInstance(){
        if (channelService == null){
            channelService = new ChannelServiceImp();
        }
        return channelService;
    }

    @Override
    public boolean add(Subscribe o) {
        return subscribes.add(o);
    }

    @Override
    public boolean delete(Subscribe subscribe) {
        return subscribes.remove (subscribe);
    }

    @Override
    public Subscribe get(String id) {
        for (Subscribe subscribe : subscribes) {
            if (subscribe.getId().equals(id)) {
                return subscribe;
            }
        }
        return null;
    }

    @Override
    public List<Subscribe> getList() {
        return subscribes;
    }

    @Override
    public List<Subscribe> getChannelsOfUser(String userId) {
        List<Subscribe> channelsList = new ArrayList<>();
        for (Subscribe subscribeUsers : channelService.getList()) {
            if (subscribeUsers.getId().equals(userId)) {
                channelsList.add(channelService.get(subscribeUsers.getId()));
            }
        }
        return channelsList;
    }

    @Override
    public void deleteById(String channelId) {
        for (Subscribe subscribe : subscribes) {
            if (subscribe.getId().equals(channelId)) {
                subscribes.remove(subscribe);
            }
        }
    }

    @Override
    public List<Subscribe> getChannelsByWord(String search) {
        List<Subscribe> channelsList = new ArrayList<>();
        for (Subscribe subscribe : subscribes) {
            if (subscribe.getName().contains(search) && subscribe.getType().equals(Type.PUBLIC)) {
                channelsList.add(subscribe);
            }
        }
        return channelsList;
    }

    @Override
    public boolean issUniqueName(String name) {
        for (Subscribe subscribe : subscribes) {
            if (subscribe.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean createChannel(String name, Type type) {
        String channelId = generateChannelId();
        if (!channels.containsKey(channelId)) {
            Subscribe channel = new Subscribe(channelId, name, type,channelId);
            channels.put(channelId, channel);
            return true;
        }
        return false;
    }

    private String generateChannelId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder channelId = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            channelId.append(characters.charAt(random.nextInt(characters.length())));
        }
        return channelId.toString();
    }
}

