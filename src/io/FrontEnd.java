
package io;

import backend.model.user.User;
import io.utils.Utils;
import io.view.login.LoginView;
import static io.view.login.LoginView.*;

public class FrontEnd {
    public static User currentUser;

    public static void main(String[] args) {
        System.out.println("Welcome to our Telegram application 🥳");
        while (true) {
            LoginView.menu();
            Integer choose = Utils.enterInt("choose: ");
            switch (choose) {
                case 1 -> login();
                case 2 -> signUp();
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
}