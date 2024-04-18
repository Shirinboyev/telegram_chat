
package io;

import backend.model.user.User;
import io.utils.Utils;
import io.view.View;
import jdk.jshell.execution.Util;

import java.util.Scanner;

public class FrontEnd {

    public static void main(String[] args) {
        System.out.println("Welcome to our Telegram application 🥳");

        View.menu();
        Integer choose = Utils.enterInt("choose: ");
        switch (choose){
            case 1 -> View.login();
            case 2 -> View.signUp();
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