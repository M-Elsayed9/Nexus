package com.nexus.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OfficeDetailsDTO {

    private Long officeId;
    private BigDecimal rentalPrice;
    private String description;
    private Short capacity;


    public OfficeDetailsDTO(Long officeId, BigDecimal rentalPrice, String description, Short capacity) {

        this.officeId = officeId;
        this.rentalPrice = rentalPrice;
        this.description = description;
        this.capacity = capacity;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        if (rentalPrice.compareTo(BigDecimal.ZERO) < 1) {
            throw new IllegalArgumentException("Rental price cannot be less than 1");
        }
        this.rentalPrice = rentalPrice;
    }

    public void setCapacity(Short capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.capacity = capacity;
    }
}
