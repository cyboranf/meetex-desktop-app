package com.example.MeetexApp.controller;


import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

@Controller
public class LoginUiController implements Initializable {
    private final UserService userService;
    private final ApplicationContext applicationContext;

    public LoginUiController(UserService userService, ApplicationContext applicationContext) {
        this.userService = userService;
        this.applicationContext = applicationContext;
    }

    @FXML
    public void switchToRegister(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/registration.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @FXML
    public void LogIn(ActionEvent event) throws IOException {
        List<User> userList = userService.findAll();
        AtomicReference<User> logUser = new AtomicReference<>(new User());
        userList.forEach(u -> {
            if (u.getEmail().equals(emailField.getText()) && u.getPassword().equals(passwordField.getText())) {
                logUser.set(u);
            }
        });
        User user = logUser.get();
        user.setLogged(true);

        success.setText("Success!");
        closeLabel.setText("You can close this window.");
    }


    @FXML
    private AnchorPane pane;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label success;

    @FXML
    private Label closeLabel;
    @FXML
    private Button submitButton;

    @FXML
    private Hyperlink createAccount;

    @FXML
    private Label noSuccess;

    private Stage stage;

    private Scene scene;

    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
