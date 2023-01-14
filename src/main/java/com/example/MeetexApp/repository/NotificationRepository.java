package com.example.MeetexApp.repository;

import com.example.MeetexApp.domain.Notification;
import com.example.MeetexApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Query(value = "SELECT count(n) from notification n WHERE n.toUser = :us", nativeQuery = true)
    Integer countOfNotification(@Param("us") User us);
}
