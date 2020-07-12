package com.example.demo.dao.message;

import com.example.demo.dao.message.MessageDAO;
import com.example.demo.model.Message;
import com.example.demo.utils.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MessageDAOImpl implements MessageDAO {
    @Override
    public void save(Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(message);
        transaction.commit();
        session.close();
    }

    @Override
    public Message getById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Message.class, id);
    }

    @Override
    public void update(Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(message);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(message);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Message> getAll(){
        return (List<Message>)  HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From Message")
                .list();
    }
}
