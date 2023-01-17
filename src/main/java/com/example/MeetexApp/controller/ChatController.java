package com.example.MeetexApp.controller;

import com.example.MeetexApp.domain.Messages;
import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.service.MessagesService;
import com.example.MeetexApp.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class ChatController implements Initializable {
    private final UserService userService;
    private final MessagesService messagesService;
    private final ApplicationContext applicationContext;

    public ChatController(UserService userService, MessagesService messagesService, ApplicationContext applicationContext) {
        this.userService = userService;
        this.messagesService = messagesService;
        this.applicationContext = applicationContext;
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        User user = userService.findByLogged();
        user.setLogged(false);
        logoutLabel.setText("Logged out");
    }

    @FXML
    public void refreshUserList() {
        user = userService.findByLogged();
        firstName.setText(user.getFirstName());

        //change it a little
        List<User> allUsers = userService.findAll();
        allUsers.remove(user);

        user0.setText(allUsers.get(1).getFirstName() + " " + allUsers.get(1).getLastName());
        user1.setText(allUsers.get(2).getFirstName() + " " + allUsers.get(2).getLastName());
        user2.setText(allUsers.get(3).getFirstName() + " " + allUsers.get(3).getLastName());
        user3.setText(allUsers.get(4).getFirstName() + " " + allUsers.get(4).getLastName());
    }

    public User user;

    @FXML
    public void invite0() {
        List<User> allUsers = userService.findAll();
        allUsers.remove(user);

        User toInvite = allUsers.get(1);
        toInvite.setNotCount(toInvite.getNotCount() + 1);
        userService.save(toInvite);
        success.setText("Success you sent friends request");
    }

    @FXML
    public void invite1() {
        List<User> allUsers = userService.findAll();
        allUsers.remove(user);

        User toInvite = allUsers.get(2);
        toInvite.setNotCount(toInvite.getNotCount() + 1);
        userService.save(toInvite);
        success.setText("Success you sent friends request");
    }

    @FXML
    public void invite2() {
        User user = userService.findByLogged();

        List<User> allUsers = userService.findAll();
        allUsers.remove(user);

        User toInvite = allUsers.get(3);
        toInvite.setNotCount(toInvite.getNotCount() + 1);
        userService.save(toInvite);
        success.setText("Success you sent friends request");
    }

    @FXML
    public void invite3() {
        User user = userService.findByLogged();

        List<User> allUsers = userService.findAll();
        allUsers.remove(user);

        User toInvite = allUsers.get(4);
        toInvite.setNotCount(toInvite.getNotCount() + 1);
        userService.save(toInvite);
        success.setText("Success you sent friends request");
    }

    public int chatIndex = 0;

    @FXML
    public void chat0() throws IOException {
        chatIndex = 0;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/chat.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @FXML
    public void chat1() throws IOException {
        chatIndex = 1;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/chat.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @FXML
    public void chat2() throws IOException {
        chatIndex = 2;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/chat.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();

    }

    @FXML
    public void chat3() throws IOException {
        chatIndex = 3;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/chat.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @FXML
    public void chatRefresh() {
        loggedUsername.setText(user.getFirstName());
        List<User> userList = userService.findAll();
        chattedUser.setText(userList.get(chatIndex + 1).getFirstName());

        List<Messages> messagesFromMe = messagesService.findAllFromMe(user.getId(), userList.get(chatIndex + 1).getId());
        List<Messages> messagesToMe = messagesService.findAllToMe(userList.get(chatIndex + 1).getId(), user.getId());
        try {
            myMsg0.setText(messagesFromMe.get(1).getText());
            myMsg1.setText(messagesFromMe.get(0).getText());


            toMeMsg0.setText(messagesToMe.get(1).getText());
            toMeMsg1.setText(messagesToMe.get(0).getText());
        } catch (NullPointerException e) {
            error.setText("Something went wrong, try again later.");
        }
    }

    @FXML
    public void sendMessage() {
        List<User> userList = userService.findAll();
        LocalDate date = LocalDate.now();

        Messages messages = new Messages();

        messages.setText(msgText.getText());
        messages.setAddressee(userList.get(chatIndex + 1));
        messages.setSender(user);
        messages.setSendDate(date);
        messagesService.save(messages);
        chatRefresh();
    }

    @FXML
    private TextArea msgText;
    @FXML
    private Label error;
    @FXML
    private Label myMsg0;
    @FXML
    private Label myMsg1;
    @FXML
    private Label myMsg2;
    @FXML
    private Label toMeMsg0;
    @FXML
    private Label toMeMsg1;
    @FXML
    private Label loggedUsername;
    @FXML
    private Label chattedUser;
    @FXML
    private Label success;
    @FXML
    private Label firstName;
    @FXML
    private Label user0;
    @FXML
    private Label user1;
    @FXML
    private Label user2;
    @FXML
    private Label user3;
    @FXML
    private Label logoutLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
