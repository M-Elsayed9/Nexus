package com.nexus.entity;

import com.fasterxml.jackson.annotation.*;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "office", indexes = {
        @Index(name = "idx_office_name", columnList = "name"),
        @Index(name = "idx_availability", columnList = "availability")
})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Getter
@Setter
@NoArgsConstructor
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_id", nullable = false, columnDefinition = "BIGINT")
    private User landlord;

    @Getter
    @Column(name = "availability", nullable = false, columnDefinition = "BOOLEAN")
    private boolean availability;

    @OneToOne(mappedBy = "office", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private OfficeDetails officeDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<Contract> contracts = new HashSet<>();

    public Office(String name, User landlord, boolean availability) {
        this.name = name;
        this.landlord = landlord;
        this.availability = availability;
    }

    public void addContract(Contract contract) {
        contracts.add(contract);
        contract.setOffice(this);
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
        final StringBuilder sb = new StringBuilder("Office{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", landlord=").append(landlord.getId());
        sb.append(", availability=").append(availability);
        sb.append(", officeDetails=").append(officeDetails);
        sb.append('}');
        return sb.toString();
    }
}

