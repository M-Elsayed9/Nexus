package com.nexus.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne()
    @JoinColumn(name = "renter_id", referencedColumnName = "id")
    private User renter;

    @ManyToOne()
    @JoinColumn(name = "landlord_id", referencedColumnName = "id")
    private User landLord;

    @ManyToOne()
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    private Office office;
    @Column(name = "documents_url")
    private String documentsUrl;

    public Booking() {
    }

    public Booking(LocalDate startDate, LocalDate endDate, User renter, User landLord, Office office, String documentsUrl) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.renter = renter;
        this.landLord = landLord;
        this.office = office;
        this.documentsUrl = documentsUrl;
    }

    public Booking(Long id, LocalDate startDate, LocalDate endDate, User renter, User landLord, Office office) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.renter = renter;
        this.landLord = landLord;
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

    public User getRenter() {
        return renter;
    }

    public void setRenter(User renter) {
        this.renter = renter;
    }

    public User getLandLord() {
        return landLord;
    }

    public void setLandLord(User landLord) {
        this.landLord = landLord;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getDocumentsUrl() {
        return documentsUrl;
    }

    public void setDocumentsUrl(String documentsUrl) {
        this.documentsUrl = documentsUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(getStartDate(), booking.getStartDate()) && Objects.equals(getEndDate(), booking.getEndDate()) && Objects.equals(getRenter(), booking.getRenter()) && Objects.equals(getLandLord(), booking.getLandLord()) && Objects.equals(getOffice(), booking.getOffice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartDate(), getEndDate(), getRenter(), getLandLord(), getOffice());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", renterID=" + renter.getId() +
                ", landLordID=" + landLord.getId() +
                ", officeID=" + office.getId() +
                ", documentsUrl='" + documentsUrl + '\'' +
                '}';
    }
}
