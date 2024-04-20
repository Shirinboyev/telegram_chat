package backend.service.channelService;

import backend.service.chatService.ChatService;

public class ChannelServiceImp implements ChannelService {

    private static ChannelService chatService;

    public static ChannelService getInstance(){
        if (chatService == null){
            chatService = new ChannelServiceImp();
        }
        return chatService;
    }

}
