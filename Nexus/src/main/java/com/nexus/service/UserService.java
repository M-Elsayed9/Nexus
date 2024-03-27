package com.nexus.service;

import com.nexus.entity.Role;
import com.nexus.entity.User;
import com.nexus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    @Autowired
    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Transactional
    public User addUserRole(User user, String role) {
        Role userRole = roleService.getRoleByName(role);
        user.setRole(userRole);
        User newUser = userRepository.save(user);
        return newUser;
    }

    @Transactional
    public void addCustomer(User user) {
        User newUser = addUserRole(user, "USER");
    }

    @Transactional
    public void addAdmin(User user) {
        User newUser = addUserRole(user, "ADMIN");
    }

    @Transactional
    public void addLandlord(User user) {
        User newUser = addUserRole(user, "LANDLORD");
    }

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
