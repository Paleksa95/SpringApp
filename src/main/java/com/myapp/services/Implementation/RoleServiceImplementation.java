package com.myapp.services.Implementation;


import com.myapp.dao.RoleDAO;
import com.myapp.models.Roles;
import com.myapp.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplementation implements RolesService {


    @Autowired
    private RoleDAO roleDAO;


    public void add(Roles roles) {
        roleDAO.add(roles);
    }

    public Roles findByName(String name) {
       return roleDAO.findByName(name);
    }

    public void delete(Roles roles) {
        roleDAO.delete(roles);
    }
}
