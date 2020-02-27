package com.facebook.service;

import com.facebook.dao.UserDAO;
import com.facebook.exception.FacebookException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.exception.FbUserAlreadyExistsException;
import com.facebook.exception.FbWrongCredentialsException;
import com.facebook.model.User;

import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User login(String inputEmail, String inputPassword) throws FacebookException {
        for (User user: userDAO.readAllUsers()) {
            if (inputEmail.equals(user.getEmail()) && inputPassword.equals(user.getPassword())) {
                return user;
            }
        }

        throw new FbWrongCredentialsException();
    }
    public void signUp(User newUser) throws FacebookException {

        for (User user : this.userDAO.readAllUsers()) {
            if (newUser.getEmail().equals(user.getEmail())) {
                throw new FbUserAlreadyExistsException();
            }
        }
        userDAO.writeUser(newUser);
    }

}
