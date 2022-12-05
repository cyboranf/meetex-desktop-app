package com.example.MeetexApp.repository;

import com.example.MeetexApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByEmail(String email);

    User findFirstById(Long userId);

    User findByFirstName(String name);
}

