package com.myapp.dao;


import com.myapp.models.User;

import java.util.List;

public interface UserDAO {

    User findById(int id);

    List<User> getAllUsers();

    void addUser(User user);

    void removeUser(User user);


}
