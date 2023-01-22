package com.example.MeetexApp.controller;

import com.example.MeetexApp.domain.Comments;
import com.example.MeetexApp.domain.Post;
import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.service.CommentsService;
import com.example.MeetexApp.service.PostService;
import com.example.MeetexApp.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class CommentController implements Initializable {
    private final UserService userService;
    private final PostService postService;
    private final CommentsService commentsService;
    private final ApplicationContext applicationContext;

    public CommentController(UserService userService, PostService postService, CommentsService commentsService, ApplicationContext applicationContext) {
        this.userService = userService;
        this.postService = postService;
        this.commentsService = commentsService;
        this.applicationContext = applicationContext;
    }

    @FXML
    public void addComment() {
        Post post = postToView.get(DashboardController.comIndex);
        User sender = userService.findByLogged2();
        LocalDate date = LocalDate.now();

        Comments comments = new Comments();

        comments.setText(text.getText());
        comments.setSender(sender);
        comments.setSendDate(date);
        comments.setPost(post);
        commentsService.save(comments);
        post.setComCount(post.getComCount() + 1);
        postService.save(post);
        sender.setNotCount(sender.getNotCount() + 1);
        success.setText("Comment added");
    }

    public List<Post> postToView = new ArrayList<>();

    @FXML
    public void refresh() {
        postToView.clear();
        User user = userService.findByLogged2();
        List<Post> posts = postService.findAll();
        postToView = postService.findPostToShow(user);

        Post post = postToView.get(DashboardController.comIndex);
        title.setText(post.getTitle());
        postText.setText(post.getText());
    }

    @FXML
    public void delete0() {
        User loggedUser = userService.findByLogged2();
        if (comments.size() > 0 && comments.get(0).getSender().equals(loggedUser)) {
            cantDelete.setText("");
            postToView.get(0).setComCount(postToView.get(0).getComCount() - 1);
            postService.save(postToView.get(0));
            commentsService.delete(comments.get(0));
            refreshComments();
        } else {
            cantDelete.setText("Can not delete com");
        }
    }

    @FXML
    public void delete1() {
        User loggedUser = userService.findByLogged2();
        if (comments.size() >= 1 && comments.get(1).getSender().equals(loggedUser)) {
            cantDelete.setText("");
            postToView.get(1).setComCount(postToView.get(1).getComCount() - 1);
            postService.save(postToView.get(1));
            commentsService.delete(comments.get(1));
            refreshComments();
        } else {
            cantDelete.setText("Can not delete com");
        }
    }

    @FXML
    public void delete2() {
        User loggedUser = userService.findByLogged2();
        if (comments.size() >= 2 && comments.get(2).getSender().equals(loggedUser)) {
            cantDelete.setText("");
            postToView.get(2).setComCount(postToView.get(2).getComCount() - 1);
            postService.save(postToView.get(2));
            commentsService.delete(comments.get(2));
            refreshComments();
        } else {
            cantDelete.setText("Can not delete com");
        }
    }

    @FXML
    public void delete3() {
        User loggedUser = userService.findByLogged2();
        if (comments.size() >= 3 && comments.get(3).getSender().equals(loggedUser)) {
            cantDelete.setText("");
            postToView.get(3).setComCount(postToView.get(3).getComCount() - 1);
            postService.save(postToView.get(3));
            commentsService.delete(comments.get(3));
            refreshComments();
        } else {
            cantDelete.setText("Can not delete com");
        }
    }

    public List<Comments> comments = new ArrayList<>();

    @FXML
    public void refreshComments() {
        User user = userService.findByLogged2();
        firstName.setText(user.getFirstName());

        postToView = postService.findPostToShow(user);

        Post post = postToView.get(DashboardController.comIndex);
        postTitle.setText("Title: " + post.getTitle());
        postText2.setText(post.getText());

        comments = commentsService.findComments(post);

        if (comments.size() == 0) {
            com0.setText("");
            comSender0.setText("");
            dateCom0.setText("");

            com1.setText("");
            comSender1.setText("");
            dateCom1.setText("");

            com2.setText("");
            comSender2.setText("");
            dateCom2.setText("");

            com3.setText("");
            comSender3.setText("");
            dateCom3.setText("");
        }

        if (comments.size() > 0) {
            com0.setText(comments.get(0).getText());
            comSender0.setText(comments.get(0).getSender().getFirstName());
            dateCom0.setText(comments.get(0).getSendDate().toString());

            com1.setText("");
            comSender1.setText("");
            dateCom1.setText("");

            com2.setText("");
            comSender2.setText("");
            dateCom2.setText("");

            com3.setText("");
            comSender3.setText("");
            dateCom3.setText("");
        }

        if (comments.size() > 1) {
            com0.setText(comments.get(0).getText());
            comSender0.setText(comments.get(0).getSender().getFirstName());
            dateCom0.setText(comments.get(0).getSendDate().toString());

            com1.setText(comments.get(1).getText());
            comSender1.setText(comments.get(1).getSender().getFirstName());
            dateCom1.setText(comments.get(1).getSendDate().toString());

            com2.setText("");
            comSender2.setText("");
            dateCom2.setText("");

            com3.setText("");
            comSender3.setText("");
            dateCom3.setText("");
        }

        if (comments.size() > 2) {
            com0.setText(comments.get(0).getText());
            comSender0.setText(comments.get(0).getSender().getFirstName());
            dateCom0.setText(comments.get(0).getSendDate().toString());

            com1.setText(comments.get(1).getText());
            comSender1.setText(comments.get(1).getSender().getFirstName());
            dateCom1.setText(comments.get(1).getSendDate().toString());

            com2.setText(comments.get(2).getText());
            comSender2.setText(comments.get(2).getSender().getFirstName());
            dateCom2.setText(comments.get(2).getSendDate().toString());

            com3.setText("");
            comSender3.setText("");
            dateCom3.setText("");
        }

        if (comments.size() > 3) {
            com0.setText(comments.get(0).getText());
            comSender0.setText(comments.get(0).getSender().getFirstName());
            dateCom0.setText(comments.get(0).getSendDate().toString());

            com1.setText(comments.get(1).getText());
            comSender1.setText(comments.get(1).getSender().getFirstName());
            dateCom1.setText(comments.get(1).getSendDate().toString());

            com2.setText(comments.get(2).getText());
            comSender2.setText(comments.get(2).getSender().getFirstName());
            dateCom2.setText(comments.get(2).getSendDate().toString());

            com3.setText(comments.get(3).getText());
            comSender3.setText(comments.get(3).getSender().getFirstName());
            dateCom3.setText(comments.get(3).getSendDate().toString());
        }
    }

    @FXML
    public void showAddComment() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        fxmlLoader.setLocation(getClass().getResource("/addComment.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Label cantDelete;
    @FXML
    private Label firstName;
    @FXML
    private Label postText2;
    @FXML
    private Label postTitle;
    @FXML
    private Label com0;
    @FXML
    private Label com1;
    @FXML
    private Label com2;
    @FXML
    private Label com3;
    @FXML
    private Label comSender0;
    @FXML
    private Label comSender1;
    @FXML
    private Label comSender2;
    @FXML
    private Label comSender3;
    @FXML
    private Label dateCom0;
    @FXML
    private Label dateCom1;
    @FXML
    private Label dateCom2;
    @FXML
    private Label dateCom3;
    @FXML
    private Label success;

    //add com
    @FXML
    private Label title;
    @FXML
    private Label postText;
    @FXML
    private TextField text;
}
