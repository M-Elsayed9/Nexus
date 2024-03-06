package com.nexus.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private User landlord;

    @Column(name = "availability", nullable = false)
    private boolean availability;

    public Office() {
    }

    public Office(String name, User landlord, boolean availability) {
        this.name = name;
        this.landlord = landlord;
        this.availability = availability;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getLandlord() {
        return landlord;
    }

    public void setLandlord(User landlord) {
        this.landlord = landlord;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return availability == office.availability && Objects.equals(id, office.id) && Objects.equals(name, office.name) && Objects.equals(landlord, office.landlord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, landlord, availability);
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", landlord=" + landlord +
                ", availability=" + availability +
                '}';
    }
}

