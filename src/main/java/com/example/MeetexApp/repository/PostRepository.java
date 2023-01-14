package com.example.MeetexApp.repository;

import com.example.MeetexApp.domain.Post;
import com.example.MeetexApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT * FROM post WHERE sender = :us", nativeQuery = true)
    List<Post> findByUserId(@Param("us") User us);
}
