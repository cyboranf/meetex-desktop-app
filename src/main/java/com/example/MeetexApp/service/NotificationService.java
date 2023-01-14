package com.example.MeetexApp.service;

import com.example.MeetexApp.domain.User;
import com.example.MeetexApp.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Integer countOfNot(User user) {
        return notificationRepository.countOfNotification(user);
    }
}
