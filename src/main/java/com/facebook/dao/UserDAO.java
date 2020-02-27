package com.facebook.dao;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbFileException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String USERS_FILE = "./src/main/java/users.txt";

    public List<User> readAllUsers() throws FbTechnicalException {
        List<User> userList = new ArrayList<>();
        try (BufferedReader userReader = new BufferedReader(new FileReader(USERS_FILE))) {
            String userLine = userReader.readLine();
            while(userLine!=null)
            {
                String[] userValues = userLine.split(";");
                userList.add(new User(userValues[0], userValues[1]));
                userLine = userReader.readLine();
            }
        } catch (IOException e) {
            throw new FbFileException("Error reading users", e);
        }

        return userList;
    }


    public void writeUser(User user) throws  FbFileException {

        try (FileWriter writer = new FileWriter(USERS_FILE, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            File file = new File(USERS_FILE);
            if(file.length() != 0)
                bw.newLine();
            bw.write(user.getEmail());
            bw.write(";");
            bw.write(user.getPassword());
        } catch (IOException e) {
            throw new FbFileException("Error writing user to file", e);
        }
    }
}
