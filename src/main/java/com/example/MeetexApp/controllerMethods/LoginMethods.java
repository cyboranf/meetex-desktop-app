package com.example.MeetexApp.controllerMethods;

import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.util.List;

public class LoginMethods {
    private  UserService userService;

    public LoginMethods() {
    }

    public boolean LogIn(TextField emailField, PasswordField passwordField) {
        List<User> userWithEmail=userService.findByEmail(emailField.getText());
        if (!userService.findByEmail(emailField.getText()).equals(null) && passwordField.getText().equals(userWithEmail.get(0))) {
            return true;
        } else {
            return false;
        }
    }


}
