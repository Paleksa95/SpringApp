package com.myapp.models;


import javax.persistence.*;


@Entity
public class Roles {


    @Id
    private String username;

    private String authority;


    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
