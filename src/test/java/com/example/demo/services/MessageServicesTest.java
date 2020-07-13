package com.example.demo.services;

import com.example.demo.model.Message;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageServicesTest {
    MessageServices ms = new MessageServices();
    private Message message =new Message("today22");;


    @BeforeEach
    void save(){
        ms.save(message);

        Message expected = ms.getById(message.getMessid());

        assertTrue(expected.getMessid()== message.getMessid() && expected.getText().equals(message.getText()));
    }

    @Test
    void update(){


        message.setText("today sunny");

        ms.update(message);

        Message expected = ms.getById(message.getMessid());

        assertTrue(expected.getMessid()== message.getMessid() && expected.getText().equals(message.getText()));

    }

    @AfterEach
    void delete(){

        ms.delete(message);

        System.out.println(message.getMessid());

        Message expected = ms.getById(message.getMessid());

        assertNull(expected);
    }


}