package com.example.demo.services;

import com.example.demo.dao.message.MessageDAO;
import com.example.demo.dao.message.MessageDAOImpl;
import com.example.demo.model.Message;

import java.util.Date;
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


    public static void main(String[] args) {
        MessageServices ms = new MessageServices();

        Message hello = new Message("today", new Date());
        System.out.println("message, before saving in db" + hello);

        ms.save(hello);
        System.out.println("saving success");

        List<Message> all = ms.getAll();
        System.out.println("extracting success");

        System.out.println("message, retrieved from db");
        all.forEach(System.out::println);
    }
}
