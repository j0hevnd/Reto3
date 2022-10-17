package com.gym.reto3.services;

import com.gym.reto3.entities.Machine;
import com.gym.reto3.entities.Message;
import com.gym.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessageById(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message c) {
        if (c.getIdMessage() == null) {
            return messageRepository.save(c);
        } else {
            Optional<Message> message = messageRepository.getMessage(c.getIdMessage());
            if (message.isPresent()) {
                return c;
            } else {
                return messageRepository.save(c);
            }
        }
    }

    public Message update(Message c) {
        Optional<Message> MessageServer = messageRepository.getMessage(c.getIdMessage());
        if (MessageServer.isPresent() && c.getIdMessage() != null) {
            MessageServer.get().setMessageText(c.getMessageText());
            return messageRepository.save(MessageServer.get());
        }
        return c;
    }

    public Boolean delete(int id){
        Optional<Message> MessageId = messageRepository.getMessage(id);
        if (MessageId.isPresent()) {
            messageRepository.delete(MessageId.get());
            return true;
        }
        return false;
    }
}
