package io.mainMenu;

import io.setting.Setting;
import io.utils.Utils;
import io.view.channels.ChannelView;
import io.view.chat.ChatView;
import io.view.contact.ContactView;
import io.view.group.GroupView;

public class MainMenu {
    public static void methods(){
        Integer choose;
        do {
        menu();
        choose = Utils.enterInt("choose: ");
        switch (choose){
            case 1 -> ContactView.addContact();
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

    private static void menu() {
        System.out.println("""
                Menu :
                1. Add contact
                2. Chats
                3. Groups
                4. Channels
                5. Settings
                                
                0. Log Out
                """);
    }
}
