package com.myapp.models;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //Doing some hibernate validation with Hibernate Validator.
    @NotNull
    @NotEmpty(message = "Can't enter empty message.")
    private String title;

    //Doing some hibernate validation with Hibernate Validator.
    @NotNull
    @NotEmpty(message = "Can't enter empty description.")
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
