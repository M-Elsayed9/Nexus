package com.nexus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "office", indexes = {
        @Index(name = "idx_office_name", columnList = "name"),
        @Index(name = "idx_availability", columnList = "availability")
})
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_id", nullable = false, columnDefinition = "BIGINT")
    @JsonBackReference
    private User landlord;

    @Column(name = "availability", nullable = false, columnDefinition = "BOOLEAN")
    private boolean availability;

    @OneToOne(mappedBy = "office", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    @JsonManagedReference
    private OfficeDetails officeDetails;

    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonManagedReference
    private Set<Contract> contracts = new HashSet<>();

    public Office() {
    }

    public Office(String name, User landlord, boolean availability) {
        this.name = name;
        this.landlord = landlord;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public OfficeDetails getOfficeDetails() {
        return officeDetails;
    }

    public void setOfficeDetails(OfficeDetails officeDetails) {
        this.officeDetails = officeDetails;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public void addContract(Contract contract) {
        contracts.add(contract);
        contract.setOffice(this);
    }

    public BigDecimal getRentalPrice() {
        return officeDetails.getRentalPrice();
    }

    public String getDescription() {
        return officeDetails.getDescription();
    }

    public Integer getCapacity() {
        return officeDetails.getCapacity();
    }

    public String getMediaUrls() {
        return officeDetails.getMediaUrls();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return Objects.equals(getName(), office.getName())
                && Objects.equals(getLandlord().getId(), office.getLandlord().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLandlord().getId());
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", landlordID=" + landlord.getId() +
                ", availability=" + availability +
                '}';
    }
}

