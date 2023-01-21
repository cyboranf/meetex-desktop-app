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
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            User user = logUser.get(0);
            user.setLogged(false);
            userService.save(user);
            logoutLabel.setText("Logged out");
            dashboardView();
        }

    }

    @FXML
    public void addPost(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/addPost.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        }

    }

    @FXML
    public void deletePost0(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            postService.delete(postToView.get(0));
            dashboardView();
        }
    }

    @FXML
    public void deletePost1(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            postService.delete(postToView.get(1));
            dashboardView();
        }
    }

    @FXML
    public void deletePost2(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            postService.delete(postToView.get(2));
            dashboardView();
        }
    }

    public static int index = 0;

    @FXML
    public void editPost0(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            index = 0;

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/editPost.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        }
    }

    @FXML
    public void editPost1(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            index = 1;

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/editPost.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        }
    }

    @FXML
    public void editPost2(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            index = 2;

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/editPost.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        }
    }

    public static int comIndex = 0;

    @FXML
    public void addComment0(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            comIndex = 0;
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/addComment.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        }
    }

    @FXML
    public void addComment1(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            comIndex = 1;
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/addComment.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        }
    }

    @FXML
    public void addComment2(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            comIndex = 2;
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/addComment.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        }
    }

    @FXML
    public void addLike0(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            Post post = postToView.get(0);
            post.setReactions(post.getReactions() + 1);
            postService.save(post);
            dashboardView();
        }
    }

    @FXML
    public void addLike1(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            Post post = postToView.get(1);
            post.setReactions(post.getReactions() + 1);
            postService.save(post);
            dashboardView();
        }
    }

    @FXML
    public void addLike2(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            Post post = postToView.get(2);
            post.setReactions(post.getReactions() + 1);
            postService.save(post);
            dashboardView();
        }
    }

    @FXML
    public void showProfil(ActionEvent actionEvent) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            dashboardView();
            logoutLabel.setText("");
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/profil.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        }

    }

    @FXML
    public void openChat(ActionEvent event) throws IOException {
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            fxmlLoader.setLocation(getClass().getResource("/userList.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        }
    }

    public List<Post> postToView = new ArrayList<>();
    public List<User> logUser = new ArrayList<>();

    @FXML
    public void dashboardView() throws IOException {
        postToView.clear();
        logUser = userService.findByLogged();
        if (logUser.size() == 0) {
            logoutLabel.setText("Sign in to use app");
        } else {
            logoutLabel.setText("");
            User user = logUser.get(0);
            firstName.setText(user.getFirstName());

            postToView = postService.findPostToShow(user);

            if (postToView.size() >= 3) {
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
            if (postToView.size() == 2) {
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

                title2.setText("");
                author2.setText("");
                date2.setText("");
                postText2.setText("");
                int reactions2 = 0;
                likeCount2.setText("");
            }
            if (postToView.size() == 1) {
                title.setText("Title: " + postToView.get(0).getTitle());
                author.setText(postToView.get(0).getSender().getFirstName());
                date.setText(postToView.get(0).getSendDate().toString());
                postText.setText(postToView.get(0).getText().toString());
                int reactions = postToView.get(0).getReactions();
                likeCount.setText(String.valueOf(reactions));

                title2.setText("");
                author2.setText("");
                date2.setText("");
                postText2.setText("");
                int reactions2 = 0;
                likeCount2.setText("");

                title1.setText("");
                author1.setText("");
                date1.setText("");
                postText1.setText("");
                int reactions1 = 0;
                likeCount1.setText("");
            }
            if (postToView.size() == 0) {
                title.setText("");
                author.setText("");
                date.setText("");
                postText.setText("");
                int reactions = 0;
                likeCount.setText("");

                title2.setText("");
                author2.setText("");
                date2.setText("");
                postText2.setText("");
                int reactions2 = 0;
                likeCount2.setText("");

                title1.setText("");
                author1.setText("");
                date1.setText("");
                postText1.setText("");
                int reactions1 = 0;
                likeCount1.setText("");
            }
            friendsCount.setText(user.getFriendsCount() + "");
            messagesCount.setText(user.getMsgCount() + "");
            notCount.setText(user.getNotCount() + "");
        }


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
