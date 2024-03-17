package com.nexus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "wishlist")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "renter_id", unique = true, nullable = false, updatable = false, columnDefinition = "BIGINT")
    @JsonBackReference
    private User renter;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "wishlist_offices",
            joinColumns = @JoinColumn(name = "wishlist_id", columnDefinition = "BIGINT", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "office_id", columnDefinition = "BIGINT", nullable = false, updatable = false)
    )
    private Set<Office> offices = new HashSet<>();

    public WishList() {
    }

    public WishList(User renter) {
        this.renter = renter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRenter() {
        return renter;
    }

    public void setRenter(User renter) {
        this.renter = renter;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    public void addOffice(Office office) {
        this.offices.add(office);
    }

    public void removeOffice(Office office) {
        this.offices.remove(office);
    }

    public void clearOffices() {
        this.offices.clear();
    }

    public boolean containsOffice(Office office) {
        return this.offices.contains(office);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishList wishList = (WishList) o;
        return Objects.equals(getRenter().getId(), wishList.getRenter().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRenter().getId());
    }

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                ", renter=" + renter.getId() +
                ", offices=" + offices +
                '}';
    }
}
