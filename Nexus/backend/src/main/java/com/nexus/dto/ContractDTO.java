package com.nexus.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ContractDTO {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal rentalPrice;
    private Long renterId;
    private Long landLordId;
    private Long officeId;


    public ContractDTO(LocalDate startDate, LocalDate endDate, BigDecimal rentalPrice, Long renterId, Long landLordId, Long officeId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentalPrice = rentalPrice;
        this.renterId = renterId;
        this.landLordId = landLordId;
        this.officeId = officeId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContractDTO{");
        sb.append("id=").append(id);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", rentalPrice=").append(rentalPrice);
        sb.append(", renterId=").append(renterId);
        sb.append(", landLordId=").append(landLordId);
        sb.append(", officeId=").append(officeId);
        sb.append('}');
        return sb.toString();
    }
}
