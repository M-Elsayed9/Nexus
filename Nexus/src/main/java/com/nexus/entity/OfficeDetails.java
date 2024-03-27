package com.nexus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "office_details", indexes = {
        @Index(name = "idx_rental_price", columnList = "rental_price"),
        @Index(name = "idx_capacity", columnList = "capacity")
})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Getter
@Setter
@NoArgsConstructor
public class OfficeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office_id", nullable = false, columnDefinition = "BIGINT", unique = true, updatable = false)
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

    public void setRentalPrice(BigDecimal rentalPrice) {
        if (rentalPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Rental price cannot be negative");
        }
        this.rentalPrice = rentalPrice;
    }

    public void setCapacity(Short capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.capacity = capacity;
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
        final StringBuilder sb = new StringBuilder("OfficeDetails{");
        sb.append("id=").append(id);
        sb.append(", office=").append(office);
        sb.append(", rentalPrice=").append(rentalPrice);
        sb.append(", description='").append(description).append('\'');
        sb.append(", capacity=").append(capacity);
        sb.append(", mediaUrls='").append(mediaUrls).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

