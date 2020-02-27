package com.facebook.ui;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.exception.FbWrongCredentialsException;
import com.facebook.service.UserService;

import java.util.Scanner;

public class LoginUI {

    private UserService userService = new UserService();

    public void displayLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        try {
            userService.login(email, password);
            System.out.println("User successfully login");
        } catch (FbWrongCredentialsException e) {
            System.out.println("Wrong Credentials");
        } catch (FbTechnicalException e) {
            e.printStackTrace();
            System.out.println("A system error appeared. Please contact your administrator");
        } catch (FacebookException e) {
            e.printStackTrace();

        }


    }
}
