
package io;

import io.utils.Utils;
import io.view.LogIn;

public class FrontEnd {

    public static void main(String[] args) {
        System.out.println("Welcome to our Telegram application 🥳");

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