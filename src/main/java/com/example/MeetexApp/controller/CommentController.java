package com.example.MeetexApp.controller;

import com.example.MeetexApp.domain.Comments;
import com.example.MeetexApp.domain.Post;
import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.service.CommentsService;
import com.example.MeetexApp.service.PostService;
import com.example.MeetexApp.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

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

    public CommentController(UserService userService, PostService postService, CommentsService commentsService) {
        this.userService = userService;
        this.postService = postService;
        this.commentsService = commentsService;
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
        sender.setNotCount(sender.getNotCount() + 1);
    }
    public List<Post> postToView = new ArrayList<>();
    @FXML
    public void refresh(){
        postToView.clear();
        User user = userService.findByLogged2();
        List<Post> posts = postService.findAll();
        for (int i = posts.size() - 1; i >= 0; i--) {
            if (posts.get(i).getSender().getId().equals(user.getId())) {
                postToView.add(posts.get(i));
            }
        }
        Post post = postToView.get(DashboardController.comIndex);
        title.setText(post.getTitle());
        postText.setText(post.getText());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Label title;
    @FXML
    private Label postText;
    @FXML
    private TextField text;
}
