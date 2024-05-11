package com.nexus.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.nexus.entity.User;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserDTO(String username, String firstName, String lastName, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User toUser() {
        return new User(username, firstName, lastName, email, password);
    }

}
