package com.example.MeetexApp.service;

import com.example.MeetexApp.domain.Comments;
import com.example.MeetexApp.repository.CommentsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentsService {
    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public Comments save(Comments comments){
        return commentsRepository.save(comments);
    }
}
