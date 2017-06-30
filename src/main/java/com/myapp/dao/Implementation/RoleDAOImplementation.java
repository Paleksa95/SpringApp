package com.myapp.dao.Implementation;


import com.myapp.dao.RoleDAO;
import com.myapp.models.Roles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImplementation implements RoleDAO{


    @Autowired
    private SessionFactory sessionFactory;

    //Add roles.
    public void add(Roles roles) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(roles);
        session.getTransaction().commit();
        session.close();
    }

    //Finding role by user name.
    public Roles findByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session.get(Roles.class, name);
    }

    //When we delete user we also need to delete his roles.
    public void delete(Roles roles) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(roles);
        session.getTransaction().commit();
        session.close();
    }
}
