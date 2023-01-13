package com.example.MeetexApp.controller;

//import com.example.MeetexApp.config.StageManager;

import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class RegistrationUiController implements Initializable {
    @FXML
    public void switchToLogin(@NotNull ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 630, 580);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Label emptyName;
    @FXML
    private Label emptySurname;
    @FXML
    private Label emptyPassword;
    @FXML
    private Label emptyMatchingPassword;
    @FXML
    private Label emptyEmail;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField matchingPassword;

    @FXML
    private Label success;

    private Stage stage;

    private Scene scene;

    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
