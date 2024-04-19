package io.view;

import backend.dto.LoginDto;
import backend.model.user.User;
import backend.service.userService.UserServiceImp;
import io.utils.Utils;

public class LogIn {
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
        String username = Utils.enterStr("username: ");
        Integer number = Utils.enterInt("number");
        String password = Utils.enterStr("password");

        User newUser = new User(name,username, number, password);

        UserServiceImp userService = new UserServiceImp(new LoginDto(number,password));
        userService.signUp(newUser);

        System.out.println("User signed up successfully.");

        profile();
    }
}