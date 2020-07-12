package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "jmess")
public class Message {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int messid;

    @Column(name = "messtext")
    private String text;

    @Column(name = "messpostime")
    private Date sendingTime;

    //region constructors
    protected Message() {
    }

    public Message(String text, Date sendingTime) {
        this.text = text;
        this.sendingTime = sendingTime;
    }
    //endregion

    //region set get
    public long getMessid() {
        return messid;
    }

    public String getText() {
        return text;
    }

    public Date getSendingTime() {
        return sendingTime;
    }
    //endregion

    @Override
    public String toString() {
        return "Message{" +
                "messid=" + messid +
                ", text='" + text + '\'' +
                ", sendingTime=" + sendingTime +
                '}';
    }
}