package com.facebook.ui;

import com.facebook.exception.FacebookException;
import com.facebook.model.User;
import com.facebook.service.UserService;

import java.util.Scanner;


public class SignUpUI {

    public  void displaySignUp() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Email: ");
        String email = scanner.nextLine();
        System.out.println("Create a Password: ");
        String password = scanner.nextLine();
        User user = new User(email,password);
        UserService userService = new UserService();
        try {
            userService.signUp(user);
            System.out.println("User successfully registered: "  + email + " ");
        } catch (FacebookException e) {
            e.printStackTrace();
        }
    }

}
