package com.myapp.dao.Implementation;

import com.myapp.dao.UserDAO;
import com.myapp.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImplementation implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    //Getting list of all users.
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User").list();
        return users;
    }

    //Find user by id.
    public User findById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session.get(User.class, id);
    }


    //Adding new user.
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }


    //Removing user.
    public void removeUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

}
