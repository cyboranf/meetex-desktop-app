package com.example.MeetexApp.service;

import com.example.MeetexApp.domain.Messages;
import com.example.MeetexApp.repository.MessagesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MessagesService {
    private final MessagesRepository messagesRepository;

    public MessagesService(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    public Messages save(Messages messages) {
        return messagesRepository.save(messages);
    }

    public List<Messages> findAllFromMe(long mine, long to) {
        List<Messages> returnedList = new ArrayList<>();
        messagesRepository.findAll().forEach(m -> {
            if (m.getSender().getId().equals(mine) && m.getAddressee().getId().equals(to)) {
                returnedList.add(m);
            }
        });
        List<Messages> finalList = new ArrayList<>();
        for (int i = returnedList.size() - 1; i >= 0; i--) {
            if (finalList.size() == 3) {
                return finalList;
            } else {
                finalList.add(returnedList.get(i));
            }
        }
        return finalList;
    }

    public List<Messages> findAllToMe(long from, long me) {
        List<Messages> returnedList = new ArrayList<>();
        messagesRepository.findAll().forEach(m -> {
            if (m.getSender().getId().equals(from) && m.getAddressee().getId().equals(me)) {
                returnedList.add(m);
            }
        });
        List<Messages> finalList = new ArrayList<>();
        for (int i = returnedList.size() - 1; i >= 0; i--) {
            if (finalList.size() == 3) {
                return finalList;
            } else {
                finalList.add(returnedList.get(i));
            }
        }
        return finalList;
    }
}
