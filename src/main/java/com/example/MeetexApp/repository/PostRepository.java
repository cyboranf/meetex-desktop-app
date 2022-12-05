package com.example.MeetexApp.repository;

import com.example.MeetexApp.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
