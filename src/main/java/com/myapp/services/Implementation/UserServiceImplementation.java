package com.myapp.services.Implementation;

import com.myapp.dao.UserDAO;
import com.myapp.models.Roles;
import com.myapp.models.User;
import com.myapp.services.RolesService;
import com.myapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImplementation implements UserService {


    @Autowired
    private UserDAO userDAO;


    @Autowired
    private RolesService rolesService;


    public User findById(int id) {
        return userDAO.findById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }


    // Adding new user
    public void addUser(User user) {
        //Hashing users password.
        BCryptPasswordEncoder securePassword = new BCryptPasswordEncoder();
        user.setPassword(securePassword.encode(user.getPassword()));

        //Set every user by default USER_ROLE , in role table.
        Roles roles = new Roles();
        roles.setUsername(user.getName());
        roles.setAuthority("ROLE_USER");
        //Saving to roles table.
        rolesService.add(roles);
        //Saving user.
        userDAO.addUser(user);
    }


    /**
     * @param user
     *
     * Here we use PreAuthorize annotation.
     * If user with different ROLE than "ROLE_ADMIN" try to delete some user from Database
     * Access will be denied
     *
     */

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void removeUser(User user) {
        userDAO.removeUser(user);
    }

}
