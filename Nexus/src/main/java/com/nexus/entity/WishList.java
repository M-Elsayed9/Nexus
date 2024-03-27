package com.nexus.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "wishlist")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Getter
@Setter
@NoArgsConstructor
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "renter_id", unique = true, nullable = false, updatable = false, columnDefinition = "BIGINT")
    private User renter;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "wishlist_offices",
            joinColumns = @JoinColumn(name = "wishlist_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "office_id", nullable = false)
    )
    private Set<Office> offices = new HashSet<>();

    public WishList(User renter) {
        this.renter = renter;
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
        final StringBuilder sb = new StringBuilder("WishList{");
        sb.append("offices=").append(offices);
        sb.append('}');
        return sb.toString();
    }
}
