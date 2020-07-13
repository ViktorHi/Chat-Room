package com.example.demo.dao.message;

import com.example.demo.model.Message;

import java.util.List;

public interface MessageDAO {

    void save(Message message);

    Message getById(int id);

    void update(Message message);

    void delete(Message message);

    List<Message> getAll();
}
