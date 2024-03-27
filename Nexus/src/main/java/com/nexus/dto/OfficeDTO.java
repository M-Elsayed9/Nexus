package com.nexus.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OfficeDTO {

    private String name;
    private Long landlordId;
    private boolean availability;
    private BigDecimal rentalPrice;
    private String description;
    private Integer capacity;

    public OfficeDTO(String name, Long landlordId, boolean availability, BigDecimal rentalPrice, String description, Integer capacity) {

        this.name = name;
        this.landlordId = landlordId;
        this.availability = availability;
        this.rentalPrice = rentalPrice;
        this.description = description;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OfficeDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", landlordId=").append(landlordId);
        sb.append(", availability=").append(availability);
        sb.append(", rentalPrice=").append(rentalPrice);
        sb.append(", description='").append(description).append('\'');
        sb.append(", capacity=").append(capacity);
        sb.append('}');
        return sb.toString();
    }
}
