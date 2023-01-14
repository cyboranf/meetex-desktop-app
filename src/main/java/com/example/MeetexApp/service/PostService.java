package com.example.MeetexApp.service;

import com.example.MeetexApp.domain.Post;
import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.repository.PostRepository;
import com.example.MeetexApp.repository.UserRepository;
import javafx.geometry.Pos;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public PostService(UserRepository userRepository, PostRepository postRepository) {
        this.postRepository = postRepository;
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
}
