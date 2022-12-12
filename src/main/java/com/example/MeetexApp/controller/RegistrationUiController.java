package com.example.MeetexApp.controller;

import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.repository.UserRepository;
import com.example.MeetexApp.service.UserService;
import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class RegistrationUiController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    private Stage stage;

    private Scene scene;

    private Parent root;


    public void init() {

    }


    //byc moze trzeba bedzie zrobic jeszcze jeden widok afterRegister
    @FXML
    public void createUser(ActionEvent event) throws IOException {
        if (firstName.getText().isEmpty()) {
            emptyName.setText("First name is empty.");
        }
        if (lastName.getText().isEmpty()) {
            emptySurname.setText("Last name is empty.");
        }
        if (email.getText().isEmpty()) {
            emptyEmail.setText("Email is empty.");
        }
        if (password.getText().isEmpty()) {
            emptyPassword.setText("Password is empty.");
        }
        if (matchingPassword.getText().isEmpty() || !matchingPassword.getText().equals(password.getText())) {
            emptyMatchingPassword.setText("Passwords doesn't equals");
        }
        User user = new User();
        user.setFirstName(firstName.getText());
        user.setLastName(lastName.getText());
        user.setEmail(email.getText());
        user.setPassword(password.getText());
        user.setMatchingPassword(matchingPassword.getText());
        user.setRole("USER");

        userRepository.save(user);
        success.setText("success");

    }

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
    @FXML
    private Button signUp;


}
