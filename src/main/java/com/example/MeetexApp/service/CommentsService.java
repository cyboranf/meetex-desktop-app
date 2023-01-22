package com.example.MeetexApp.service;

import com.example.MeetexApp.domain.Comments;
import com.example.MeetexApp.domain.Post;
import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.repository.CommentsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentsService {
    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public Comments save(Comments comments) {
        return commentsRepository.save(comments);
    }

    public List<Comments> findComments(Post post) {
        List<Comments> comments = commentsRepository.findAll();

//        List<Comments> returnedList = comments.stream()
//                .filter(c -> c.getPost().equals(post))
//                .toList();
        List<Comments> returnedList = new ArrayList<>();
        comments.forEach(c -> {
            if (c.getPost().getId() == post.getId()) {
                returnedList.add(c);
            }
        });
        if (returnedList.size() == 0) {
            return returnedList;
        } else {
            Collections.sort(returnedList, new Comparator<Comments>() {
                @Override
                public int compare(Comments com, Comments com2) {
                    return com.getSendDate().compareTo(com2.getSendDate());
                }
            });
            return returnedList;
        }
    }

    @Transactional
    public List<Comments> findComments2(Post post) {
        List<Comments> comments = commentsRepository.findComments(post);
        List<Comments> returnedList = comments.stream().filter(c -> c.getPost().equals(post))
                .collect(Collectors.toList());
        Collections.sort(returnedList, new Comparator<Comments>() {
            @Override
            public int compare(Comments com1, Comments com2) {
                return com1.getSendDate().compareTo(com2.getSendDate());
            }
        });
        return returnedList;
    }

    public void delete(Comments comments) {
        commentsRepository.delete(comments);
    }
}
