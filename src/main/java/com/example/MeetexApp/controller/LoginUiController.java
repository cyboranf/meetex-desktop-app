package com.example.MeetexApp.controller;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class LoginUiController {

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    private Hyperlink createAccount;

    private Stage stage;

    private Scene scene;

    private Parent root;


    @FXML
    public void switchToRegister(@NotNull ActionEvent event) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("/registration.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setMinHeight(600);
            stage.setMinWidth(325);
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

    }
}
