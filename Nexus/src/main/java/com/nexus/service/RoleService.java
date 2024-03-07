package com.nexus.service;

import com.nexus.entity.Role;
import com.nexus.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Transactional(readOnly = true)
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Transactional
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Transactional
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

}
