package com.example.demo.controllers;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    List<Message> messages = new ArrayList<Message>(){{
//        add(new Message(messageId.get(), "hello", new Date()));
//        add(new Message(messageId.incrementAndGet(), "world", new Date()));
//        add(new Message(messageId.incrementAndGet(), "it is", new Date()));
//        add(new Message(messageId.incrementAndGet(), "me", new Date()));
    }};

    @GetMapping
    private synchronized List<Message> getList(){
        return messages;
    }

    @GetMapping("{id}")
    private synchronized Message getOne(@PathVariable String id){
        return getMessage(Long.parseLong(id));
    }

    @PostMapping()
    private Message create (@RequestBody String mess){

        Message message = new Message(
                mess
        );

        synchronized (this){
            messages.add(message);
        }

        return message;
    }

    @DeleteMapping("{id}")
    private void delete (@PathVariable long id){
        Message mess = getMessage(id);

        messages.remove(mess);
    }

    private Message getMessage(long id){
        return messages.stream()
                .filter(message -> message.getMessid()==id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
