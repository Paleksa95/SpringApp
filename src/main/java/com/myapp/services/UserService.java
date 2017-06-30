package com.myapp.services;

import com.myapp.models.User;
import java.util.List;

public interface UserService {


   User findById(int id);

    List<User> getAllUsers();

    void addUser(User user);

    void removeUser( User user);


}
