package com.example.demo.controllers;

import com.example.demo.Const;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Message;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/chat")
public class ChatController {

    AtomicLong messageId = new AtomicLong(0);

    List<Message> messages = new ArrayList<Message>(){{
        add(new Message(messageId.get(), Const.ADMIN_ID, "hello", new Date()));
        add(new Message(messageId.incrementAndGet(), Const.ADMIN_ID, "world", new Date()));
        add(new Message(messageId.incrementAndGet(), Const.ADMIN_ID, "it is", new Date()));
        add(new Message(messageId.incrementAndGet(), Const.ADMIN_ID, "me", new Date()));
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
        long userId = Const.ADMIN_ID;

        Message message = new Message(messageId.incrementAndGet(),
                userId,
                mess,
                new Date());

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
                .filter(message -> message.getId()==id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
