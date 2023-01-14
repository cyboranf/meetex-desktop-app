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

    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByLogged() {
        return userRepository.findByLogged().get(0);
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
