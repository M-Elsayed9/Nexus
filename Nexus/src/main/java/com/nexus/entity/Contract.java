package com.nexus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "booking")
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
    @JsonBackReference
    private User renter;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_id", columnDefinition = "BIGINT", nullable = false)
    @JsonBackReference
    private User landlord;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", columnDefinition = "BIGINT", nullable = false)
    @JsonBackReference
    private Office office;

    @Column(name = "documents_url", columnDefinition = "VARCHAR(255)")
    private String documentUrl;

    public Contract() {
    }

    public Contract(LocalDate startDate, LocalDate endDate, User renter, User landlord, Office office, String documentUrl) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.renter = renter;
        this.landlord = landlord;
        this.office = office;
        this.documentUrl = documentUrl;
    }

    public Contract(Long id, LocalDate startDate, LocalDate endDate, User renter, User landlord, Office office) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.renter = renter;
        this.landlord = landlord;
        this.office = office;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public User getRenter() {
        return renter;
    }

    public void setRenter(User renter) {
        this.renter = renter;
    }

    public User getLandlord() {
        return landlord;
    }

    public void setLandlord(User landlord) {
        this.landlord = landlord;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getDocumentsUrl() {
        return documentUrl;
    }

    public void setDocumentsUrl(String documentsUrl) {
        this.documentUrl = documentsUrl;
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
        return "Booking{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", renterID=" + renter.getId() +
                ", landLordID=" + landlord.getId() +
                ", officeID=" + office.getId() +
                '}';
    }
}
