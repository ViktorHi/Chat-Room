package com.example.demo.services;

import com.example.demo.dao.message.MessageDAO;
import com.example.demo.dao.message.MessageDAOImpl;
import com.example.demo.model.Message;

import java.util.List;

public class MessageServices {

    private final MessageDAO messageDAO = new MessageDAOImpl();

    void save(Message message) {
        messageDAO.save(message);
    }

    Message getById(int id) {
        return messageDAO.getById(id);
    }

    void update(Message message) {
        messageDAO.update(message);
    }

    void delete(Message message) {
        messageDAO.delete(message);
    }

    List<Message> getAll(){
        return messageDAO.getAll();
    }

}
