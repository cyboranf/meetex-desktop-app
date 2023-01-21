package com.example.MeetexApp.controller;

//import com.example.MeetexApp.config.StageManager;

import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.initializer.FriendsInitializer;
import com.example.MeetexApp.service.PostService;
import com.example.MeetexApp.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class RegistrationUiController implements Initializable {
    private final UserService userService;
    private final ApplicationContext applicationContext;
    private final PasswordEncoder passwordEncoder;
    private final PostService postService;


    public RegistrationUiController(UserService userService, ApplicationContext applicationContext, PasswordEncoder passwordEncoder, PostService postService) {
        this.userService = userService;
        this.applicationContext = applicationContext;
        this.passwordEncoder = passwordEncoder;

        this.postService = postService;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    @FXML
    public void switchToLogin(@NotNull ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/login.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @FXML
    public void createUser(ActionEvent event) {
        int count = 0;
        User user = new User();
        if (firstName.getText().isEmpty()) {
            emptyName.setText("First name is empty");
        } else {
            user.setFirstName(firstName.getText());
            count++;
        }

        if (lastName.getText().isEmpty()) {
            emptySurname.setText("Last name is empty");
        } else {
            user.setLastName(lastName.getText());
            count++;
        }

        if (email.getText().isEmpty()) {
            emptyEmail.setText("Email is empty");
        } else {
            count++;
        }
        if (!validate(email.getText())) {
            emptyEmail.setText("Wrong email");
        } else {
            user.setEmail(email.getText());
            count++;
        }

        if (password.getText().isEmpty() || !password.getText().equals(matchingPassword.getText())) {
            emptyPassword.setText("Wrong Pass");
            emptyMatchingPassword.setText("Wrong verify Pass");
        } else {
            user.setPassword(password.getText());
            user.setMatchingPassword(matchingPassword.getText());
            count++;
        }

        if (count == 5) {
            user.setRole("USER");
            successLabel.setText("Congrats, u have an account.");
            closeWindowText.setText("Close this window.");
            userService.save(user);
            FriendsInitializer friendsInitializer = new FriendsInitializer(userService, passwordEncoder, postService);
            friendsInitializer.createFirstFriends(user);
        }
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
    private Label successLabel;

    @FXML
    private Label closeWindowText;

    @FXML
    private Label success;

    private Stage stage;

    private Scene scene;

    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
