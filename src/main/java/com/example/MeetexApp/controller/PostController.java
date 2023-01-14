package com.example.MeetexApp.controller;

import com.example.MeetexApp.domain.Post;
import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.service.PostService;
import com.example.MeetexApp.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class PostController implements Initializable {
    private final UserService userService;
    private final PostService postService;
    private final ApplicationContext applicationContext;

    public PostController(UserService userService, PostService postService, ApplicationContext applicationContext) {
        this.userService = userService;
        this.postService = postService;
        this.applicationContext = applicationContext;
    }

    @FXML
    public void addPost(ActionEvent event) {
        LocalDate date = LocalDate.now();
        User user = userService.findByLogged();

        Post post = new Post();
        post.setReactions(0);
        post.setSendDate(date);
        post.setTitle(title.getText());
        post.setText(text.getText());
        post.setSender(user);

        postService.save(post);
        success.setText("Success, you can close this window and refresh main page");
    }

    @FXML
    public void editPost(ActionEvent event) {
        List<Post> postToView = new ArrayList<>();
        User user = userService.findByLogged();

        List<Post> posts = postService.findAll();
        for (int i = posts.size() - 1; i >= 0; i--) {
            if (posts.get(i).getSender().getId().equals(user.getId())) {
                postToView.add(posts.get(i));
            }
        }

        Post post = postToView.get(DashboardController.index);
        post.setTitle(eTitle.getText());
        post.setText(eText.getText());
        postService.save(post);
        eSuccess.setText("Success, you can close this window and refresh main page");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private TextField eTitle;
    @FXML
    private TextField eText;
    @FXML
    private Label eSuccess;
    @FXML
    private Label success;
    @FXML
    private TextField title;
    @FXML
    private javafx.scene.control.TextField text;
}
