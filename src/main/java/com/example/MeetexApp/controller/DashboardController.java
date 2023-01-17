package com.example.MeetexApp.controller;

import com.example.MeetexApp.domain.Post;
import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.service.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
        List<User> allUsers = userService.findAll();
        for (User user : allUsers) {
            user.setLogged(false);
            userService.save(user);
        }

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/login.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        User user = userService.findByLogged();
        user.setLogged(false);
        logoutLabel.setText("Logged out");
    }


    @FXML
    public void addPost(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/addPost.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @FXML
    public void deletePost0(ActionEvent event) throws IOException {
        postService.delete(postToView.get(0));
    }

    @FXML
    public void deletePost1(ActionEvent event) throws IOException {
        postService.delete(postToView.get(1));
    }

    @FXML
    public void deletePost2(ActionEvent event) throws IOException {
        postService.delete(postToView.get(2));
    }

    public static int index = 0;

    @FXML
    public void editPost0(ActionEvent event) throws IOException {
        index = 0;

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/editPost.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @FXML
    public void editPost1(ActionEvent event) throws IOException {
        index = 1;

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/editPost.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @FXML
    public void editPost2(ActionEvent event) throws IOException {
        index = 2;

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/editPost.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    public static int comIndex=0;
    @FXML
    public void addComment0(ActionEvent event) throws IOException {
        comIndex=1;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/addComment.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }
    @FXML
    public void addComment1(ActionEvent event) throws IOException {
        comIndex=1;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/addComment.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        comIndex=1;
        stage.show();
    }
    @FXML
    public void addComment2(ActionEvent event) throws IOException {
        comIndex=2;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/addComment.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));

        stage.show();
    }

    @FXML
    public void addLike0(ActionEvent event) throws IOException {
        Post post = postToView.get(0);
        post.setReactions(post.getReactions() + 1);
        postService.save(post);
    }

    @FXML
    public void addLike1(ActionEvent event) throws IOException {
        Post post = postToView.get(1);
        post.setReactions(post.getReactions() + 1);
        postService.save(post);
    }

    @FXML
    public void addLike2(ActionEvent event) throws IOException {
        Post post = postToView.get(2);
        post.setReactions(post.getReactions() + 1);
        postService.save(post);
    }

    @FXML
    public void showProfil(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/profil.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @FXML
    public void openChat(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/userList.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    public List<Post> postToView = new ArrayList<>();

    @FXML
    public void dashboardView(ActionEvent event) throws IOException {
        postToView.clear();
        User user = userService.findByLogged();
        firstName.setText(user.getFirstName());

        List<Post> posts = postService.findAll();
        for (int i = posts.size() - 1; i >= 0; i--) {
            if (posts.get(i).getSender().getId().equals(user.getId())) {
                postToView.add(posts.get(i));
            }
        }


        if (postToView.size() != 0) {
            //newest post
            title.setText("Title: " + postToView.get(0).getTitle());
            author.setText(postToView.get(0).getSender().getFirstName());
            date.setText(postToView.get(0).getSendDate().toString());
            postText.setText(postToView.get(0).getText().toString());
            int reactions = postToView.get(0).getReactions();
            likeCount.setText(String.valueOf(reactions));

            title1.setText("Title: " + postToView.get(1).getTitle());
            author1.setText(postToView.get(1).getSender().getFirstName());
            date1.setText(postToView.get(1).getSendDate().toString());
            postText1.setText(postToView.get(1).getText().toString());
            int reactions1 = postToView.get(1).getReactions();
            likeCount1.setText(String.valueOf(reactions1));

            title2.setText("Title: " + postToView.get(2).getTitle());
            author2.setText(postToView.get(2).getSender().getFirstName());
            date2.setText(postToView.get(2).getSendDate().toString());
            postText2.setText(postToView.get(2).getText().toString());
            int reactions2 = postToView.get(2).getReactions();
            likeCount2.setText(String.valueOf(reactions2));
        }
        friendsCount.setText(user.getFriendsCount() + "");
        messagesCount.setText(user.getMsgCount() + "");
        notCount.setText(user.getNotCount() + "");

    }

    @FXML
    private Label friendsCount;
    @FXML
    private Label messagesCount;
    @FXML
    private Label notCount;
    @FXML
    private Label title;
    @FXML
    private Label title1;
    @FXML
    private Label title2;
    @FXML
    private Label date;
    @FXML
    private Label date1;
    @FXML
    private Label date2;
    @FXML
    private Label author;
    @FXML
    private Label author1;
    @FXML
    private Label author2;
    @FXML
    private Label postText;
    @FXML
    private Label postText1;
    @FXML
    private Label postText2;
    @FXML
    private Label likeCount;
    @FXML
    private Label likeCount1;
    @FXML
    private Label likeCount2;
    @FXML
    private Label logoutLabel;
    @FXML
    private Label firstName;
    private Stage stage;

    private Scene scene;

    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
