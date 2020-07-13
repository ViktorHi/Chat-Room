package com.example.demo.services;

import com.example.demo.dao.message.MessageDAO;
import com.example.demo.dao.message.MessageDAOImpl;
import com.example.demo.model.Message;

import java.util.List;

public class MessageServices {

    private final MessageDAO messageDAO = new MessageDAOImpl();

    public void save(Message message) {
        messageDAO.save(message);
    }

    public Message getById(int id) {
        return messageDAO.getById(id);
    }

    public void update(Message message) {
        messageDAO.update(message);
    }

    public void delete(Message message) {
        messageDAO.delete(message);
    }

    public List<Message> getAll(){
        return messageDAO.getAll();
    }

}
