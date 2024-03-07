package com.nexus.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "office_details")
public class OfficeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    @JoinColumn(name = "office_id")
    private Office office;

    @Lob
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "capacity", nullable = false, columnDefinition = "SMALLINT")
    private Short capacity;

    @Column(name = "media_urls", length = 255)
    private String mediaUrls;

    public OfficeDetails() {
    }

    public OfficeDetails(Office office, String description, Short capacity, String mediaUrls) {
        this.office = office;
        this.description = description;
        this.capacity = capacity;
        this.mediaUrls = mediaUrls;
    }

    public OfficeDetails(Office office, String description, Short capacity) {
        this.office = office;
        this.description = description;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setCapacity(Short capacity) {
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
        return Objects.equals(getOffice(), that.getOffice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOffice());
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

