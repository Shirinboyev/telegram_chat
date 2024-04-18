package io.view;

import backend.dto.LoginDto;
import backend.model.user.User;
import backend.service.userService.UserServiceImp;
import io.utils.Utils;

import java.util.List;

public class View {
    private static User currentUser;

    public static void menu() {
        System.out.println("1. Log In");
        System.out.println("2. Sing Up");
        System.out.println("0. Exit");
    }

    public static void login() {
        System.out.println("Log In ....");
        String username = Utils.enterStr("Username: ");
        Integer number = Utils.enterInt("number: ");
        String password = Utils.enterStr("Password: ");

        LoginDto userLogin = new LoginDto(number, password);

        UserServiceImp userService = new UserServiceImp(new LoginDto(number,password));
        currentUser = userService.login(userLogin);

        if (currentUser == null) {
            System.out.println("wrong❌❌❌");
        } else {
            System.out.println("Welcome to system!");
            profile();
        }
        System.out.println("===================================================");
    }

    private static void profile() {
        System.out.println("Come to Profile 🙋🏼‍♂️");
    }

    public static void signUp() {
        System.out.println("Sign Up");

        String name = Utils.enterStr("Name: ");
        String number = Utils.enterStr("number");
        String password = Utils.enterStr("password");
    }
}