package com.example.demo.controllers;

import com.example.demo.model.Message;
import com.example.demo.services.MessageServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final MessageServices messageServices = new MessageServices();

    @GetMapping
    private synchronized List<Message> getList(){
        return messageServices.getAll();
    }

    @GetMapping("{id}")
    private synchronized Message getOne(@PathVariable String id){
        return messageServices.getById(Integer.parseInt(id));
    }

    @PostMapping()
    private Message create (@RequestBody String mess){
        Message message = new Message(mess);

        messageServices.save(message);

        return message;
    }

    @DeleteMapping("{id}")
    private void delete (@PathVariable int id){

        Message toDel = messageServices.getById(id);
        messageServices.delete(toDel);
    }

}
