package com.myapp.controllers;

import com.myapp.models.Roles;
import com.myapp.models.User;
import com.myapp.services.RolesService;
import com.myapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;



    //Need it for adding user from register form.
    @ModelAttribute("user")
    public User constructUser() {
        return new User();
    }

    @RequestMapping("/register")
    public String displayForm() {
        return "register";
    }


    //Adding new user.
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerFrom(@Valid @ModelAttribute("user") User user,BindingResult result) {


        //If we have errors ( see models.User )
        //We will return user to register.jsp page and we will display errors ( look register.jsp )
        if (result.hasErrors()){
           return "/register";
        }

        //If we don't have errors , we will redirect user to register.jsp page and display success.
        userService.addUser(user);
        return "redirect:/register?success=true";
    }

    //Getting all users.
    @RequestMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    //Get specific user by his id.
    @RequestMapping("/users/{id}")
    public String userDetails(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.findById(id));
        return "userDetails";
    }

    //Deleting user based on his id ( only user with ROLE_ADMIN ) can do this.
    //Also deleting authority and username from Roles table , look ( models.Roles )
    @RequestMapping("/users/delete/{id}")
    public String removeUser(@PathVariable int id) {
        User user = userService.findById(id);
        String userName = user.getName();
        userService.removeUser(user);
        Roles userRoles = rolesService.findByName(userName);
        rolesService.delete(userRoles);


        //Redirecting user with ROLE_ADMIN when he delete some user.
        return "redirect:/index?success=true";
    }


}
