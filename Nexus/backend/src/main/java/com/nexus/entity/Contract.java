package com.nexus.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table(name = "contract", indexes = {
        @Index(name = "idx_rental_price", columnList = "rental_price")
})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Getter
@Setter
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date", nullable = false, columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false, columnDefinition = "DATE")
    private LocalDate endDate;

    @Column(name = "rental_price", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal rentalPrice;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "renter_id", columnDefinition = "BIGINT", nullable = false)
    @JsonIgnore
    private User renter;

    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_id", columnDefinition = "BIGINT", nullable = false)
    private User landlord;

    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", columnDefinition = "BIGINT", nullable = false)
    private Office office;

    @Column(name = "documents_url", columnDefinition = "VARCHAR(255)")
    private String documentUrl;

    public Contract(LocalDate startDate, LocalDate endDate, User renter, User landlord, Office office) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.renter = renter;
        this.landlord = landlord;
        this.office = office;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        if (rentalPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Rental price cannot be negative");
        }
        this.rentalPrice = rentalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Contract contract = (Contract) o;
        return Objects.equals(getStartDate(), contract.getStartDate())
                && Objects.equals(getEndDate(), contract.getEndDate())
                && Objects.equals(getRenter().getId(), contract.getRenter().getId())
                && Objects.equals(getLandlord().getId(), contract.getLandlord().getId())
                && Objects.equals(getOffice().getId(), contract.getOffice().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartDate(), getEndDate(), getRenter().getId(), getLandlord().getId(), getOffice().getId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contract{");
        sb.append("id=").append(id);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", rentalPrice=").append(rentalPrice);
        sb.append(", renter=").append(renter.getId());
        sb.append(", landlord=").append(landlord.getId());
        sb.append(", office=").append(office.getId());
        sb.append(", documentUrl='").append(documentUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
