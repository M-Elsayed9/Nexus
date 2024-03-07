package com.nexus.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true, length = 50)
    private String userName;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "landlord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Office> offices = new HashSet<>();

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Booking> bookings = new HashSet<>();

    public User() {
    }

    public User(String userName, String firstName, String lastName, String email, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    public boolean isAdmin() {
        return this.role.getName().equals("ADMIN");
    }

    public boolean isGuest() {
        return this.role.getName().equals("GUEST");
    }

    public boolean isUser() {
        return this.role.getName().equals("USER");
    }

    public boolean isLandlord() {
        return this.role.getName().equals("LANDLORD");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getEmail());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }

    public void addRole(Role role) {
        this.role = role;
    }
}
