package ui.view.login;

import backend.dto.LoginDto;
import backend.model.user.User;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;
import ui.mainMenu.MainMenu;
import static ui.utils.Utils.*;

public class LoginView {
    static UserService userService = UserServiceImp.getInstance();

    private static User currentUser;

    public static void menu() {
        System.out.println("1. Log In");
        System.out.println("2. Sing Up");
        System.out.println("0. Exit");
    }

    public static void login() {
        String username = enterStr("Username: ");
        String password = enterStr("Password: ");
        currentUser = userService.login(new LoginDto(username,password));
        if(currentUser==null){
            System.out.println("User not found");
            return;
        }
        System.out.println("User login success");
        MainMenu.methods();
    }

    private static void profile() {
        System.out.println("Come to Profile 🙋🏼‍♂️");
    }

    public static void signUp() {
        String name = enterStr("Name: ");
        String username = enterStr("Username: ");
        int num = enterInt("Number: ");
        String password = enterStr("Password: ");
        boolean add = userService.add(new User(name, username, num, password));
        System.out.println("User added successfully");
        /*System.out.println("Sign Up");

        String name = Utils.enterStr("Name: ");
        String username = Utils.enterStr("username: ");
        Integer number;
        do {
            number = Utils.enterInt("number: ");
            if (!Utils.isNumber(number.toString())) {
                System.out.println("Number faqat raqam bo'lishi kerak. Iltimos, to'g'ri raqam kiriting.");
            }
        } while (!Utils.isNumber(number.toString()));
        String password = Utils.enterStr("password: ");

        User newUser = new User(name,username, number, password);

        UserServiceImp userService = new UserServiceImp();

        userService.signUp(newUser);

        System.out.println("User signed up successfully.");
        System.out.println("Welcome " + name);
        menu();
        login();*/
    }

}