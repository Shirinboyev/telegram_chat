package ui.view.channels;

import backend.enums.Type;
import backend.model.channel.Subscribe;
import backend.service.channelService.ChannelService;
import backend.service.channelService.ChannelServiceImp;
import ui.utils.Utils;

public class ChannelView {
    static ChannelService channelService = ChannelServiceImp.getInstance();

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
                case 1 -> sendMessage();
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
        String name = Utils.enterStr("Enter the name for the new channel: ");
        if (!name.isBlank()) {
            System.out.println("Choose the type of the channel:");
            System.out.println("1. Public");
            System.out.println("2. Private");
            int typeChoice = Utils.enterInt("Choose: ");
            Type type = (typeChoice == 1) ? Type.PUBLIC : Type.PRIVATE;
            if (channelService.createChannel(name, type)) {
                System.out.println("Channel successfully created.");
            } else {
                System.out.println("Failed to create channel. Channel name is already in use.");
            }
        } else {
            System.out.println("Invalid channel name! Please try again.");
        }
    }

    private static void sendMessage() {

        System.out.println(" ");
    }
}
