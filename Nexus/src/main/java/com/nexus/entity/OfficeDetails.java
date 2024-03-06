package com.nexus.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "office_details")
public class OfficeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "office_id")
    private Office office;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "media_urls")
    private String mediaUrls;

    public OfficeDetails() {
    }

    public OfficeDetails(Office office, String description, int capacity, String mediaUrls) {
        this.office = office;
        this.description = description;
        this.capacity = capacity;
        this.mediaUrls = mediaUrls;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getMediaUrls() {
        return mediaUrls;
    }

    public void setMediaUrls(String mediaUrls) {
        this.mediaUrls = mediaUrls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficeDetails that = (OfficeDetails) o;
        return Objects.equals(office, that.office);
    }

    @Override
    public int hashCode() {
        return Objects.hash(office);
    }


    @Override
    public String toString() {
        return "OfficeDetails{" +
                "id=" + id +
                ", office=" + office +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", mediaUrls='" + mediaUrls + '\'' +
                '}';
    }
}

