package com.example.MeetexApp.service;

import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
