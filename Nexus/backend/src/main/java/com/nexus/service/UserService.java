package com.nexus.service;

import com.nexus.dto.UserDTO;
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
    public UserDTO addUserRole(UserDTO userDTO, String roleName) {
        Role userRole = roleService.getRoleByName(roleName);
        User user = userDTO.toUser();
        user.setRole(userRole);
        User savedUser = userRepository.save(user);
        return convertToUserDTO(savedUser);
    }

    @Transactional
    public void addCustomer(UserDTO userDTO) {
        addUserRole(userDTO, "USER");
    }

    @Transactional
    public void addAdmin(UserDTO userDTO) {
        addUserRole(userDTO, "ADMIN");
    }

    @Transactional
    public void addLandlord(UserDTO userDTO) {
        addUserRole(userDTO, "LANDLORD");
    }

    @Transactional(readOnly = true)
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return convertToUserDTO(user);
    }

    @Transactional(readOnly = true)
    public UserDTO getUserByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        return convertToUserDTO(user);
    }

    @Transactional(readOnly = true)
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return convertToUserDTO(user);
    }

    @Transactional
    public UserDTO updateUser(UserDTO userDTO) {
        User existingUser = userRepository.findByUserName(userDTO.getUsername());
        if (existingUser != null) {
            existingUser.setFirstName(userDTO.getFirstName());
            existingUser.setLastName(userDTO.getLastName());
            existingUser.setPassword(userDTO.getPassword());
            User updatedUser = userRepository.save(existingUser);
            return convertToUserDTO(updatedUser);
        }
        return null;
    }
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO convertToUserDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    }
}
