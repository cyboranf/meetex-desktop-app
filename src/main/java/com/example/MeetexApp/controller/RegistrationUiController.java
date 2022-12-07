package com.example.MeetexApp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class RegistrationUiController {
    private Stage stage;

    private Scene scene;

    private Parent root;


    @FXML
    public void switchToLogin(@NotNull ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
