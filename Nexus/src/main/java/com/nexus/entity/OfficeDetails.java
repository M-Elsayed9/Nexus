package com.nexus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "office_details", indexes = {
        @Index(name = "idx_rental_price", columnList = "rental_price"),
        @Index(name = "idx_capacity", columnList = "capacity")
})
public class OfficeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office_id", nullable = false, columnDefinition = "BIGINT", unique = true, updatable = false)
    @JsonBackReference
    private Office office;

    @Column(name = "rental_price", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal rentalPrice;

    @Lob
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "capacity", nullable = false, columnDefinition = "SMALLINT")
    private Short capacity;

    @Column(name = "media_urls", columnDefinition = "VARCHAR(255)")
    private String mediaUrls;

    public OfficeDetails() {
    }

    public OfficeDetails(Office office, String description, Short capacity, String mediaUrls, BigDecimal rentalPrice) {
        this.office = office;
        this.description = description;
        this.capacity = capacity;
        this.mediaUrls = mediaUrls;
        this.rentalPrice = rentalPrice;
    }

    public OfficeDetails(Office office, String description, Short capacity, BigDecimal rentalPrice) {
        this.office = office;
        this.description = description;
        this.capacity = capacity;
        this.rentalPrice = rentalPrice;
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

    public BigDecimal getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        if (rentalPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Rental price cannot be negative");
        }
        this.rentalPrice = rentalPrice;
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
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
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
        return Objects.equals(getOffice().getId(), that.getOffice().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOffice().getId());
    }

    @Override
    public String toString() {
        return "OfficeDetails{" +
                "id=" + id +
                ", office=" + office.getId() +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

