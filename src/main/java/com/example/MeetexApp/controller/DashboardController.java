package com.example.MeetexApp.controller;

import com.example.MeetexApp.service.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class DashboardController implements Initializable {
    private final UserService userService;
    private final PostService postService;
    private final CommentsService commentsService;
    private final NotificationService notificationService;
    private final MessagesService messagesService;
    private final ApplicationContext applicationContext;

    public DashboardController(UserService userService, PostService postService, CommentsService commentsService, NotificationService notificationService, MessagesService messagesService, ApplicationContext applicationContext) {
        this.userService = userService;
        this.postService = postService;
        this.commentsService = commentsService;
        this.notificationService = notificationService;
        this.messagesService = messagesService;
        this.applicationContext = applicationContext;
    }

    @FXML
    public void openSignInView(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/registration.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();

    }


    private Stage stage;

    private Scene scene;

    private Parent root;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
