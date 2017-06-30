package com.myapp.models;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //Doing some hibernate validation with Hibernate Validator.
    @Size(min = 3, max = 10, message = "Put username between 3-10 characters.")
    @Column(unique = true)
    private String name;


    //Doing some hibernate validation with Hibernate Validator.
    @Size(min = 6, message = "Password needs to be at least 6 characters long.")
    private String password;

    //Doing some hibernate validation with Hibernate Validator.
    @Email
    @Column(unique = true)
    @NotEmpty(message = "Enter valid e mail" )
    private String email;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
