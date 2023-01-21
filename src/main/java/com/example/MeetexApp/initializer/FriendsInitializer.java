package com.example.MeetexApp.initializer;

import com.example.MeetexApp.domain.Post;
import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.service.PostService;
import com.example.MeetexApp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FriendsInitializer {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final PostService postService;


    public FriendsInitializer(UserService userService, PasswordEncoder passwordEncoder, PostService postService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.postService = postService;
    }

    public void createFirstFriends(User user) {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();
        LocalDate date = LocalDate.now();
        List<User> newFriends = new ArrayList<>();
        if (userService.findByEmail("admin@admin.com").size() == 0 || userService.findByEmail("admin2@admin.com").size() == 0 || userService.findByEmail("admin3@admin.com").size() == 0) {
            newFriends.clear();
            user1.setEmail("admin@admin.com");
            user1.setFirstName("admin1");
            user1.setLastName("admin1");
            userService.save(user1);

            post1.setReactions(0);
            post1.setText("This is first post from admin1, welcome to Meetex");
            post1.setTitle("Title of first post from admin1");
            post1.setSender(user1);
            post1.setReactions(0);
            post1.setAddressee(user1.getFriends());
            post1.setSendDate(date);
            postService.save(post1);


            user2.setEmail("admin2@admin.com");
            user2.setFirstName("admin2");
            user2.setLastName("admin2");
            userService.save(user2);

            post2.setReactions(0);
            post2.setText("This is first post from admin2, welcome to Meetex");
            post2.setTitle("Title of first post from admin2");
            post2.setSender(user2);
            post2.setReactions(0);
            post2.setSendDate(date);
            post2.setAddressee(user2.getFriends());
            postService.save(post2);


            user3.setEmail("admin3@admin.com");
            user3.setFirstName("admin3");
            user3.setLastName("admin3");
            userService.save(user3);

            post3.setSendDate(date);
            post3.setReactions(0);
            post3.setText("This is first post from admin3, welcome to Meetex");
            post3.setTitle("Title of first post from admin3");
            post3.setSender(user3);
            post3.setReactions(0);
            post3.setAddressee(user3.getFriends());
            postService.save(post3);

            newFriends.add(user1);
            newFriends.add(user2);
            newFriends.add(user3);

            user.setFriends(newFriends);
            user.setFriendsCount(3);
            userService.save(user);
        } else {
            newFriends.clear();
            user1.setEmail("admin4@admin.com");
            user1.setFirstName("admin4");
            user1.setLastName("admin4");
            userService.save(user1);

            post1.setReactions(0);
            post1.setText("This is first post from admin4, welcome to Meetex");
            post1.setTitle("Title of first post from admin4");
            post1.setSender(user1);
            post1.setReactions(0);
            post1.setAddressee(user1.getFriends());
            post1.setSendDate(date);
            postService.save(post1);


            user2.setEmail("admin6@admin.com");
            user2.setFirstName("admin6");
            user2.setLastName("admin6");
            userService.save(user2);

            post2.setReactions(0);
            post2.setText("This is first post from admin6, welcome to Meetex");
            post2.setTitle("Title of first post from admin6");
            post2.setSender(user2);
            post2.setReactions(0);
            post2.setSendDate(date);
            post2.setAddressee(user2.getFriends());
            postService.save(post2);


            user3.setEmail("admin6@admin.com");
            user3.setFirstName("admin6");
            user3.setLastName("admin6");
            userService.save(user3);

            post3.setSendDate(date);
            post3.setReactions(0);
            post3.setText("This is first post from admin3, welcome to Meetex");
            post3.setTitle("Title of first post from admin3");
            post3.setSender(user3);
            post3.setReactions(0);
            post3.setAddressee(user3.getFriends());
            postService.save(post3);

            newFriends.add(user1);
            newFriends.add(user2);
            newFriends.add(user3);

            user.setFriends(newFriends);
            user.setFriendsCount(3);
            userService.save(user);
//            newFriends.clear();
//            newFriends.add(userService.findByEmail("admin@admin.com").get(0));
//            newFriends.add(userService.findByEmail("admin2@admin.com").get(0));
//            newFriends.add(userService.findByEmail("admin3@admin.com").get(0));
//
//            List<Post> allPosts = postService.findAll();
//            //tu pokombinowac zeby jak ktos usunie posty od adminow to byly generowane od poczatku
//            post1.setReactions(0);
//            post1.setText("This is first post from admin1, welcome to Meetex");
//            post1.setTitle("Title of first post from admin1");
//            post1.setSender(userService.findByEmail("admin@admin.com").get(0));
//            post1.setReactions(0);
//            post1.setAddressee(user1.getFriends());
//            post1.setSendDate(date);
//            postService.save(post1);
//
//            post2.setReactions(0);
//            post2.setText("This is first post from admin2, welcome to Meetex");
//            post2.setTitle("Title of first post from admin2");
//            post2.setSender(userService.findByEmail("admin2@admin.com").get(0));
//            post2.setReactions(0);
//            post2.setSendDate(date);
//            post2.setAddressee(user2.getFriends());
//            postService.save(post2);
//
//            post3.setSendDate(date);
//            post3.setReactions(0);
//            post3.setText("This is first post from admin3, welcome to Meetex");
//            post3.setTitle("Title of first post from admin3");
//            post3.setSender(userService.findByEmail("admin3@admin.com").get(0));
//            post3.setReactions(0);
//            post3.setAddressee(user3.getFriends());
//            postService.save(post3);
//
//            user.setFriends(newFriends);
//            user.setFriendsCount(3);
//            userService.save(user);
        }


    }

}
