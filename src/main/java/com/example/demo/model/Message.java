package com.example.demo.model;

import java.util.Date;

public class Message {

    final long id;
    final long userId;
    final String text;
    final Date sendingTime;

    public Message(long id, long userId, String text, Date sendingTime) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.sendingTime = sendingTime;
    }

    //region set get
    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public Date getSendingTime() {
        return sendingTime;
    }
    //endregion
}