package com.example.MeetexApp.controller;


import com.example.MeetexApp.domain.Messages;
import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.service.MessagesService;
import com.example.MeetexApp.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfilController {
    private final UserService userService;
    private final ApplicationContext applicationContext;

    private final MessagesService messagesService;

    public ProfilController(UserService userService, ApplicationContext applicationContext, MessagesService messagesService) {
        this.userService = userService;
        this.applicationContext = applicationContext;
        this.messagesService = messagesService;
    }

    @FXML
    public void logout() {
        User user = userService.findByLogged2();
        user.setLogged(false);

    }

    @FXML
    public void showUser() {
        User user = userService.findByLogged2();
        firstNamelastName.setText(user.getFirstName() + " " + user.getLastName());
        email.setText(user.getEmail());
        friendsCount.setText(user.getFriendsCount() + " ");
        role.setText(user.getRole());
    }

    @FXML
    public void showFriendsList() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/friendsList.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();

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
            User user = userService.findByLogged2();
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
            User user = userService.findByLogged2();
            if (oldEmail.getText().equals(user.getEmail()) && !newEmail.getText().equals("")) {
                user.setEmail(newEmail.getText());
                userService.save(user);
                eSuccess2.setText("Success you can close this window and refresh main page or profil page.");
            }

        } catch (NullPointerException e) {
            eSuccess2.setText("Text fields can not be empty");
        }
    }

    public int indexToChat = 0;
    public List<User> friends = new ArrayList<>();

    @FXML
    public void refreshUserList() {
        user = userService.findByLogged2();
        firstName.setText(user.getFirstName());

        //change it a little
        friends = user.getFriends();

        if (friends.size() >= 4) {
            user0.setText(friends.get(0).getFirstName() + " " + friends.get(0).getLastName());
            user1.setText(friends.get(1).getFirstName() + " " + friends.get(1).getLastName());
            user2.setText(friends.get(2).getFirstName() + " " + friends.get(2).getLastName());
            user3.setText(friends.get(3).getFirstName() + " " + friends.get(3).getLastName());
            indexToChat = 4;
        }
        if (friends.size() == 3) {
            user0.setText(friends.get(0).getFirstName() + " " + friends.get(0).getLastName());
            user1.setText(friends.get(1).getFirstName() + " " + friends.get(1).getLastName());
            user2.setText(friends.get(2).getFirstName() + " " + friends.get(2).getLastName());
            user3.setText("");
            indexToChat = 3;
        }
        if (friends.size() == 2) {
            user0.setText(friends.get(0).getFirstName() + " " + friends.get(0).getLastName());
            user1.setText(friends.get(1).getFirstName() + " " + friends.get(1).getLastName());
            user2.setText("");
            user3.setText("");
            indexToChat = 2;
        }
        if (friends.size() == 1) {
            user0.setText(friends.get(0).getFirstName() + " " + friends.get(0).getLastName());
            user1.setText("");
            user2.setText("");
            user3.setText("");
            indexToChat = 1;
        }
        if (friends.size() == 0) {
            user0.setText("");
            user1.setText("");
            user2.setText("");
            user3.setText("");
            indexToChat = 0;
        }

    }

    public User user;
    public User chattingUser;


    public int chatIndex = 0;

    @FXML
    public void chat0() throws IOException {
        if (indexToChat > 0) {
            cantChat.setText("");
            chatIndex = 0;

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/chatFromFriends.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        } else {
            cantChat.setText("Can not open chat");
        }
    }

    @FXML
    public void chat1() throws IOException {
        if (indexToChat > 1) {
            cantChat.setText("");
            chatIndex = 1;
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/chatFromFriends.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        } else {
            cantChat.setText("Can not open chat");
        }

    }

    @FXML
    public void chat2() throws IOException {
        if (indexToChat > 2) {
            cantChat.setText("");
            chatIndex = 2;
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/chatFromFriends.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        } else {
            cantChat.setText("Can not open chat");
        }

    }

    @FXML
    public void chat3() throws IOException {
        if (indexToChat > 3) {
            cantChat.setText("");
            chatIndex = 3;
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/chatFromFriends.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        } else {
            cantChat.setText("Can not open chat");
        }
    }



    @FXML
    public void chatRefresh() {
        loggedUsername.setText(user.getFirstName());

        chattedUser.setText(friends.get(chatIndex).getFirstName());

        List<Messages> messagesFromMe = messagesService.findAllFromMe(user.getId(), friends.get(chatIndex).getId());
        List<Messages> messagesToMe = messagesService.findAllToMe(friends.get(chatIndex).getId(), user.getId());

        if (messagesFromMe.size() == 0) {
            myMsg0.setText("");
            myMsg1.setText("");
            myMsg2.setText("");
        }
        if (messagesFromMe.size() > 0) {
            myMsg0.setText(messagesFromMe.get(1).getText());
            myMsg1.setText("");
            myMsg2.setText("");
        }
        if (messagesFromMe.size() > 1) {
            myMsg0.setText(messagesFromMe.get(1).getText());
            myMsg1.setText(messagesFromMe.get(0).getText());
            myMsg2.setText("");
        }
        if (messagesFromMe.size() > 2) {
            myMsg0.setText(messagesFromMe.get(1).getText());
            myMsg1.setText(messagesFromMe.get(0).getText());
            myMsg2.setText("");
        }

        if (messagesToMe.size() == 0) {
            toMeMsg0.setText("");
            toMeMsg1.setText("");
        }
        if (messagesToMe.size() > 0) {
            toMeMsg0.setText(messagesToMe.get(1).getText());
            toMeMsg1.setText("");
        }
        if (messagesToMe.size() > 1) {
            toMeMsg0.setText(messagesToMe.get(1).getText());
            toMeMsg1.setText(messagesToMe.get(0).getText());
        }

    }

    @FXML
    public void sendMessage() {
        List<User> userList = userService.findAll();
        LocalDate date = LocalDate.now();

        Messages messages = new Messages();

        messages.setText(msgText.getText());
        messages.setAddressee(friends.get(chatIndex));
        messages.setSender(user);
        messages.setSendDate(date);
        messagesService.save(messages);
        chatRefresh();
    }

    @FXML
    private Label cantChat;
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
    private Label logoutLabel;


}
