package backend.service.channelService.postServis;

import backend.service.channelService.ChannelService;
import backend.service.channelService.ChannelServiceImp;

public class PostServiceImp {
    private static PostService postService;

    public static PostService getInstance(){
        if (postService == null){
            postService = new PostServiceImp ();
        }
        return postService;
    }
}
