package com.example.MeetexApp.repository;

import com.example.MeetexApp.domain.Comments;
import com.example.MeetexApp.domain.Post;
import com.example.MeetexApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    @Query(value = "SELECT * FROM comment WHERE post = :po", nativeQuery = true)
    List<Comments> findComments(@Param("po") Post po);
}
