package com.example.MeetexApp.repository;

import com.example.MeetexApp.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
