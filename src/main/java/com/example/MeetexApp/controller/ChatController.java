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
        User user = userService.findByLogged2();
        user.setLogged(false);
        logoutLabel.setText("Logged out");
    }

    public int indexToChat = 0;
    public List<User> friends = new ArrayList<>();
    public List<User> toShow = new ArrayList<>();

    @FXML
    public void refreshUserList() {
        user = userService.findByLogged2();
        firstName.setText(user.getFirstName());

        //change it a little
        friends = userService.findAll();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).getId().equals(user.getId())) {

            } else {
                toShow.add(friends.get(i));
            }
        }

        if (toShow.size() >= 4) {
            user0.setText(toShow.get(0).getFirstName() + " " + toShow.get(0).getLastName());
            user1.setText(toShow.get(1).getFirstName() + " " + toShow.get(1).getLastName());
            user2.setText(toShow.get(2).getFirstName() + " " + toShow.get(2).getLastName());
            user3.setText(toShow.get(3).getFirstName() + " " + friends.get(3).getLastName());
            indexToChat = 4;
        }
        if (toShow.size() == 3) {
            user0.setText(toShow.get(0).getFirstName() + " " + toShow.get(0).getLastName());
            user1.setText(toShow.get(1).getFirstName() + " " + toShow.get(1).getLastName());
            user2.setText(toShow.get(2).getFirstName() + " " + toShow.get(2).getLastName());
            user3.setText("");
            indexToChat = 3;
        }
        if (toShow.size() == 2) {
            user0.setText(toShow.get(0).getFirstName() + " " + toShow.get(0).getLastName());
            user1.setText(toShow.get(1).getFirstName() + " " + toShow.get(1).getLastName());
            user2.setText("");
            user3.setText("");
            indexToChat = 2;
        }
        if (toShow.size() == 1) {
            user0.setText(toShow.get(0).getFirstName() + " " + toShow.get(0).getLastName());
            user1.setText("");
            user2.setText("");
            user3.setText("");
            indexToChat = 1;
        }
        if (toShow.size() == 0) {
            user0.setText("");
            user1.setText("");
            user2.setText("");
            user3.setText("");
            indexToChat = 0;
        }


    }

    public User user;

    @FXML
    public void invite0() {
        if (indexToChat > 0) {
            cantChat.setText("");
            List<User> allUsers = userService.findAll();
            allUsers.remove(user);

            User toInvite = allUsers.get(1);
            toInvite.setNotCount(toInvite.getNotCount() + 1);
            userService.save(toInvite);
            success.setText("Success, you sent friends request");
        } else {
            cantChat.setText("Can not send a friend request");
        }

    }

    @FXML
    public void invite1() {
        if (indexToChat > 1) {
            cantChat.setText("");
            List<User> allUsers = userService.findAll();
            allUsers.remove(user);

            User toInvite = allUsers.get(2);
            toInvite.setNotCount(toInvite.getNotCount() + 1);
            userService.save(toInvite);
            success.setText("Success, you sent friends request");
        } else {
            cantChat.setText("Can not send a friend request");
        }

    }

    @FXML
    public void invite2() {
        if (indexToChat > 2) {
            cantChat.setText("");
            User user = userService.findByLogged2();

            List<User> allUsers = userService.findAll();
            allUsers.remove(user);

            User toInvite = allUsers.get(3);
            toInvite.setNotCount(toInvite.getNotCount() + 1);
            userService.save(toInvite);
            success.setText("Success, you sent friends request");

        } else {
            cantChat.setText("Can not send a friend request");
        }

    }

    @FXML
    public void invite3() {
        if (indexToChat > 3) {
            cantChat.setText("");
            User user = userService.findByLogged2();

            List<User> allUsers = userService.findAll();
            allUsers.remove(user);

            User toInvite = allUsers.get(4);
            toInvite.setNotCount(toInvite.getNotCount() + 1);
            userService.save(toInvite);
            success.setText("Success you sent friends request");
        } else {
            cantChat.setText("Can not send a friend request");
        }

    }

    public int chatIndex = 0;

    @FXML
    public void chat0() throws IOException {
        if (indexToChat > 0) {
            cantChat.setText("");
            chatIndex = 0;
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/chat.fxml"));
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
            fxmlLoader.setLocation(getClass().getResource("/chat.fxml"));
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
            fxmlLoader.setLocation(getClass().getResource("/chat.fxml"));
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
            fxmlLoader.setLocation(getClass().getResource("/chat.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        } else {
            cantChat.setText("Can not open chat");
        }

    }

    @FXML
    public void chatRefresh() {
        loggedUsername.setText(user.getFirstName());

        chattedUser.setText(toShow.get(chatIndex).getFirstName());

        List<Messages> messagesFromMe = messagesService.findAllFromMe(user.getId(), friends.get(chatIndex).getId());
        List<Messages> messagesToMe = messagesService.findAllToMe(toShow.get(chatIndex).getId(), user.getId());

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
        messages.setAddressee(userList.get(chatIndex + 1));
        messages.setSender(user);
        messages.setSendDate(date);
        messagesService.save(messages);
        chatRefresh();
    }

    @FXML
    private Label cantChat;
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
