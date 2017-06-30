package com.myapp.services;

import com.myapp.models.Roles;

public interface RolesService {

   void add(Roles roles);

   Roles findByName(String name);

   void delete(Roles roles);

}
