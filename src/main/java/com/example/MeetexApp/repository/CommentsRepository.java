package com.example.MeetexApp.repository;

import com.example.MeetexApp.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
}
