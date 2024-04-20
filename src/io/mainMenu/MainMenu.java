package io.mainMenu;

import backend.model.channel.Channel;
import backend.model.contact.Contact;
import backend.model.group.Group;
import backend.service.chatService.ChatService;
import io.setting.Setting;
import io.utils.Utils;
import io.view.login.LogIn;

public class MainMenu {
    public static void mwthods(){
        Integer choose;
        do {
        menu();
        choose = Utils.enterInt("choose: ");

        switch (choose){
            case 1 -> Contact.addContact();
            case 2 -> ChatService.methods();
            case 3 -> Group.methods();
            case 4 -> Channel.methods();
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
