package com.myapp.dao;


import com.myapp.models.Roles;

public interface RoleDAO {

    void add(Roles roles);

    Roles findByName(String name);

    void delete(Roles roles);
}
