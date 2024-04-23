package ui.view.login;

import backend.dto.LoginDto;
import backend.model.user.User;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;
import ui.FrontEnd;
import ui.mainMenu.MainMenu;
import static ui.utils.Utils.*;

public class LoginView {
    static UserService userService = UserServiceImp.getInstance();
    public static void menu() {
        System.out.println("1. Log In");
        System.out.println("2. Sing Up");
        System.out.println("0. Exit");
    }

    public static void login() throws Exception {
        String username = enterStr("Username: ");
        String password = enterStr("Password: ");
        FrontEnd.currentUser = userService.login(new LoginDto(username,password));
        if(FrontEnd.currentUser==null){
            System.out.println("User not found");
            return;
        }
        System.out.println("User login success");
        MainMenu.methods();
    }

    public static void signUp() {
        String name = enterStr("Name: ");
        String username = enterStr("Username: ");
        int num = enterInt("Number: ");
        String password = enterStr("Password: ");
        boolean add = userService.add(new User(name, username, num, password));
        System.out.println("User added successfully");
    }

}