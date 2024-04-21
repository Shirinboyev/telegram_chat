package ui.setting;

import backend.model.user.User;
import ui.FrontEnd;
import ui.utils.Utils;

public class Setting {

    public static void methods() {
        while (true) {
            menu();
            switch (Utils.enterInt("Choice : ")) {
                case 1 -> changeName();

                case 2 -> changeNickname();

                case 3 -> changePassword();

                case 4 -> {
                    deleteAccount();
                    return;
                }

                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void deleteAccount() {

    }

    private static void changePassword() {

    }

    private static void changeNickname() {
        User curUser = FrontEnd.currentUser;
        String name = Utils.enterStr("Enter new name : ");
        if (name.equals("0")) {
            return;
        }

        curUser.setName(name);

    }

    private static void changeName() {
        User curUser = FrontEnd.currentUser;
        String name = Utils.enterStr("Enter new name : ");
        if (name.equals("0")) {
            return;
        }

        curUser.setName(name);
    }

    private static void menu() {
        System.out.println("""
                1. Change name
                2. Change nickname
                3. Change password
                4. Delete account
                                
                0. Go back
                """);
    }
}
