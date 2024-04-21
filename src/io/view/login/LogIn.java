package io.view.login;

import backend.dto.LoginDto;
import backend.model.user.User;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;
import io.mainMenu.MainMenu;
import static io.utils.Utils.*;

import java.awt.*;

public class LogIn {
    static UserService userService = UserServiceImp.getInstance();

    private static User currentUser;

    public static void menu() {
        System.out.println("1. Log In");
        System.out.println("2. Sing Up");
        System.out.println("0. Exit");
    }

    public static void login() {
        System.out.println("Log In ....");
        String username = enterStr("Username: ");
        Integer number;

        do {
            number = enterInt("number: ");
            if (!isNumber(number.toString())) {
                System.out.println("Number faqat raqam bo'lishi kerak. Iltimos, to'g'ri raqam kiriting.");
            }
        } while (!isNumber(number.toString()));

        String password = enterStr("Password: ");
        LoginDto userLogin = new LoginDto(number, password);
        UserServiceImp userService = new UserServiceImp();
        currentUser = userService.login(userLogin);

        if (currentUser == null) {
            System.out.println("wrong❌❌❌");
            System.out.println("Do you want try again ?  1.Yes, 0.No");
            Integer choose = enterInt("choose: ");
            switch (choose){
                case 1:login();
                case 0:{
                    break;
                }
            }
        } else {
            System.out.println("\u001B[33mWelcome " + currentUser.getName());
            MainMenu.methods();
        }
    }

    private static void profile() {
        System.out.println("Come to Profile 🙋🏼‍♂️");
    }

    public static void signUp() {
        String name = enterStr ("Name: ");
        String username = enterStr ("Username: ");
        int phoneNumber = enterInt ( "Phone: ");
        String password = enterStr ("Password: ");
        User user = userService.signUp(new User (name,username,phoneNumber,password));
       /* System.out.println("Sign Up");

        String name = enterStr("Name: ");
        String username = enterStr("username: ");
        Integer number;
        do {
            number = enterInt("number: ");
            if (!isNumber(number.toString())) {
                System.out.println("Number faqat raqam bo'lishi kerak. Iltimos, to'g'ri raqam kiriting.");
            }
        } while (!isNumber(number.toString()));
        String password = enterStr("password: ");

        User newUser = new User(name,username, number, password);

        UserServiceImp userService = new UserServiceImp();

        userService.signUp(newUser);

        System.out.println("User signed up successfully.");
        System.out.println("Welcome " + name);
        MainMenu.methods();*/
    }

}