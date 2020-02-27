package com.facebook.ui;

import sun.rmi.runtime.Log;

import java.util.Scanner;

public class MainUI {

    private LoginUI loginUI = new LoginUI();
    private SignUpUI signUpUI = new SignUpUI();

//    private SignUpUI signUpUI

    public void start() {
        System.out.println("1.Login\n"+"2.SignUp");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        switch(option){
            case "1":
                loginUI.displayLogin();
                break;
            case "2":
                signUpUI.displaySignUp();
                break;
        }
    }

}
