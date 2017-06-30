package com.myapp.dao.Implementation;

import com.myapp.dao.MessagesDAO;
import com.myapp.models.Messages;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessagesDAOImplementation implements MessagesDAO {


    @Autowired
    private SessionFactory sessionFactory;



    //Returning list of all messages.
    public List<Messages> getAllMessages() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Messages> messages = session.createQuery("from Messages").list();
        return messages;
    }



    //Finding message by id.
    //we don't need this method since deleting messages with message ID by user who have ROLE_ADMIN is not implemented yet.
    //But i added this metohd.
    public Messages findById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session.get(Messages.class, id);
    }


    //Adding new message.
    public void addMessage(Messages messages) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(messages);
        session.getTransaction().commit();
        session.close();
    }

}
