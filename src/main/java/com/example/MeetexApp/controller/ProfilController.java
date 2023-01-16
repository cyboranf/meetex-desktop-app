package com.example.MeetexApp.controller;

import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class ProfilController {
    private final UserService userService;
    private final ApplicationContext applicationContext;

    public ProfilController(UserService userService, ApplicationContext applicationContext) {
        this.userService = userService;
        this.applicationContext = applicationContext;
    }

    @FXML
    public void logout() {
        User user = userService.findByLogged();
        user.setLogged(false);

    }

    @FXML
    public void showUser() {
        User user = userService.findByLogged();
        firstNamelastName.setText(user.getFirstName() + " " + user.getLastName());
        email.setText(user.getEmail());
        friendsCount.setText(user.getFriendsCount() + " ");
        role.setText(user.getRole());
    }

    @FXML
    public void switchToEditName() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/editName.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @FXML
    public void switchToEditEmail() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/editEmail.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @FXML
    public void editName() {
        try {
            User user = userService.findByLogged();
            if (user.getFirstName().equals(oldName.getText()) && user.getLastName().equals(oldLastName.getText()) && !newName.getText().equals("") && !newLastName.getText().equals("")) {
                user.setFirstName(newName.getText());
                user.setLastName(newLastName.getText());
                userService.save(user);
                eSuccess.setText("Success you can close this window and refresh profil");
            } else {
                eSuccess.setText("Something went wrong, try again");
            }
        } catch (NullPointerException e) {
            eSuccess.setText("Text fields can not be empty!");
        }

    }

    @FXML
    public void editEmail() {
        try {
            User user = userService.findByLogged();
            if (oldEmail.getText().equals(user.getEmail()) && !newEmail.getText().equals("")){
                user.setEmail(newEmail.getText());
                userService.save(user);
                eSuccess2.setText("Success you can close this window and refresh main page or profil page.");
            }

        }catch (NullPointerException e){
            eSuccess2.setText("Text fields can not be empty");
        }

    }

    @FXML
    private TextField oldEmail;
    @FXML
    private TextField newEmail;
    @FXML
    private Label eSuccess;
    @FXML
    private Label eSuccess2;
    @FXML
    private TextField newLastName;
    @FXML
    private TextField oldName;
    @FXML
    private TextField oldLastName;
    @FXML
    private TextField newName;
    @FXML
    private Label firstNamelastName;
    @FXML
    private Label email;
    @FXML
    private Label friendsCount;
    @FXML
    private Label role;
}
