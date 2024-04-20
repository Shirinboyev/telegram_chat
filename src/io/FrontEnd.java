
package io;

import backend.model.user.User;
import io.utils.Utils;
import io.view.login.LogIn;

public class FrontEnd {
    public static User currentUser;

    public static void main(String[] args) {
        System.out.println("Welcome to our Telegram apphyhybylication 🥳");

        LogIn.menu();
        Integer choose = Utils.enterInt("choose: ");
        switch (choose){
            case 1 -> LogIn.login();
            case 2 -> LogIn.signUp();
            case 0 -> {
                System.out.println("Bye Bye Came back 🥲");
                return;
            }
            default -> {
                System.out.println("Wrong Choose ❌❌❌");
            }
        }
    }
}