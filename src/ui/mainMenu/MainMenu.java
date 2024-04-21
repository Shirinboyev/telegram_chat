package ui.mainMenu;

import ui.setting.Setting;
import ui.utils.Utils;
import ui.view.channels.ChannelView;
import ui.view.chat.ChatView;
import ui.view.contact.ContactView;
import ui.view.group.GroupView;

public class MainMenu {
    public static void methods(){
        Integer choose;
        do {
        menu();
        choose = Utils.enterInt("choose: ");
        switch (choose){
            case 1 -> ContactView.search();
            case 2 -> ChatView.methods();
            case 3 -> GroupView.methods();
            case 4 -> ChannelView.methods();
            case 5 -> Setting.methods();

            case 0 -> {

                return;

            }
        }

        }while (true);

    }

    public static void menu() {
        System.out.println("""
                Menu :
                1. Search
                2. Chats
                3. Groups
                4. Channels
                5. Settings
                0. Log Out
                """);
    }
    public static void message(){
        System.out.println("""
                1.Send Message
                2.Edit Message
                3.Delete Message
                """);
    }
}
