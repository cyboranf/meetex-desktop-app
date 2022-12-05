package com.example.MeetexApp.repository;

import com.example.MeetexApp.domain.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<Messages, Long> {
}
