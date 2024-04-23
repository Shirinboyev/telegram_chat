package ui.view.channels;

import backend.enums.Role;
import backend.enums.Type;
import backend.model.channel.Subscribe;
import backend.service.channelService.ChannelService;
import backend.service.channelService.ChannelServiceImp;
import backend.service.channelService.postServis.PostService;
import backend.service.channelService.postServis.PostServiceImp;
import backend.service.subscribeService.SubscribeService;
import backend.service.subscribeService.SubscribeServiceImp;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;
import ui.FrontEnd;
import ui.utils.Utils;

import java.nio.channels.Channel;

public class ChannelView {
    private static final ChannelService channelService = ChannelServiceImp.getInstance();
    private static final PostService postService = PostServiceImp.getInstance();
    private static final SubscribeService subscribeService = SubscribeServiceImp.getInstance();
    private static final UserService userService = UserServiceImp.getInstance();
    public static void methods() {
        System.out.println("1. Send Message");
        System.out.println("2. Create Channel");
        System.out.println("3. Rename Channel");
        System.out.println("4. Delete Channel");
        System.out.println("0. Exit");

        Integer choose;
        do {
            choose = Utils.enterInt("Choose: ");
            switch (choose) {
                case 1 -> sendPost();
                case 2 -> createChannel();
                case 3 -> renameChannel();
                case 4 -> deleteChannel();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (true);
    }

    private static void deleteChannel() {
        String channelId = Utils.enterStr("Enter the ID of the channel you want to delete: ");
        Subscribe channel = channelService.get(channelId);
        if (channel != null) {
            System.out.println("Deleting channel: " + channel.getName());
            channelService.deleteById(channelId);
            System.out.println("Channel successfully deleted.");
        } else {
            System.out.println("Channel not found with ID: " + channelId);
        }
    }

    private static void renameChannel() {
        String channelId = Utils.enterStr("Enter the ID of the channel you want to rename: ");
        Subscribe channel = channelService.get(channelId);
        if (channel != null) {
            String newName = Utils.enterStr("Enter the new name for the channel '" + channel.getName() + "': ");
            if (!newName.isBlank()) {
                channel.setName(newName);
                System.out.println("Channel name successfully changed to: " + newName);
            } else {
                System.out.println("Invalid channel name! Please try again.");
            }
        } else {
            System.out.println("Channel not found with ID: " + channelId);
        }
    }

    private static void createChannel() {
        String name = Utils.enterStr ("name: ");
        Type type = Type.choose ();
        Subscribe channel = new Subscribe (name, FrontEnd.currentUser.getId (),type);
        Subscribe subscribe = new Subscribe(FrontEnd.currentUser.getId(), channel.getId());
        subscribe.setType (Role.ADMIN);
        subscribeService.add(subscribe);
        boolean isWorked = channelService.add(channel);



    }



    private static void sendPost() {

    }

}
