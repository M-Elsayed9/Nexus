package com.nexus.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContractDTO {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal rentalPrice;
    private Long renterId;
    private Long landLordId;
    private Long officeId;
    private String documentUrl;

    public ContractDTO() {
    }

    public ContractDTO(LocalDate startDate, LocalDate endDate, BigDecimal rentalPrice, Long renterId, Long landLordId, Long officeId, String documentUrl) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentalPrice = rentalPrice;
        this.renterId = renterId;
        this.landLordId = landLordId;
        this.officeId = officeId;
        this.documentUrl = documentUrl;
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

    public Long getRenterId() {
        return renterId;
    }

    public void setRenterId(Long renterId) {
        this.renterId = renterId;
    }

    public Long getLandLordId() {
        return landLordId;
    }

    public void setLandLordId(Long landLordId) {
        this.landLordId = landLordId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    @Override
    public String toString() {
        return "ContractDTO{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", rentalPrice=" + rentalPrice +
                ", renterId=" + renterId +
                ", landLordId=" + landLordId +
                ", officeId=" + officeId +
                ", documentUrl='" + documentUrl + '\'' +
                '}';
    }
}
