package com.example.MeetexApp.service;

import com.example.MeetexApp.domain.Post;
import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.repository.PostRepository;
import com.example.MeetexApp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository1) {
        this.postRepository = postRepository;
        this.userRepository = userRepository1;
    }

    public List<Post> findByUserId(User user) {
        return postRepository.findByUserId(user);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    @Transactional
    public List<Post> findPostToShow(User user) {
        List<Post> posts = postRepository.findAll();
        List<Post> returnedList = new ArrayList<>();
        List<User> friendsList = user.getFriends();
        for (int i = posts.size() - 1; i >= 0; i--) {
            if (posts.get(i).getSender().getId().equals(user.getId())) {
                returnedList.add(posts.get(i));
            } else {
                for (int j = 0; j < friendsList.size(); j++) {
                    if (posts.get(i).getSender().getId().equals(friendsList.get(j).getId())) {
                        returnedList.add(posts.get(i));
                    }
                }
            }
        }

        Collections.sort(returnedList, new Comparator<Post>() {
            @Override
            public int compare(Post post, Post post2) {
                return post.getSendDate().compareTo(post2.getSendDate());
            }
        });
        return returnedList;
    }
}
