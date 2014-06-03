package com.maciej.imiela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.Role;
import com.maciej.imiela.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

    public Role findOne(int id) {
        return this.roleRepository.findOne(id);
    }

    public Role save(Role role) {
        Role oldRole = role;
        if (role.getId() != null) {
            oldRole = this.findOne(role.getId());
            oldRole.update(role);
        }
        return this.roleRepository.save(oldRole);
    }

}
