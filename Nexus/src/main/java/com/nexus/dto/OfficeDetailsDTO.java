package com.nexus.dto;

import java.math.BigDecimal;

public class OfficeDetailsDTO {
    private Long id;
    private Long officeId;
    private BigDecimal rentalPrice;
    private String description;
    private Short capacity;
    private String mediaUrls;

    public OfficeDetailsDTO() {
    }

    public OfficeDetailsDTO(Long id, Long officeId, BigDecimal rentalPrice, String description, Short capacity, String mediaUrls) {
        this.id = id;
        this.officeId = officeId;
        this.rentalPrice = rentalPrice;
        this.description = description;
        this.capacity = capacity;
        this.mediaUrls = mediaUrls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public BigDecimal getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getCapacity() {
        return capacity;
    }

    public void setCapacity(Short capacity) {
        this.capacity = capacity;
    }

    public String getMediaUrls() {
        return mediaUrls;
    }

    public void setMediaUrls(String mediaUrls) {
        this.mediaUrls = mediaUrls;
    }

    @Override
    public String toString() {
        return "OfficeDetailsDTO{" +
                "id=" + id +
                ", officeId=" + officeId +
                ", rentalPrice=" + rentalPrice +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", mediaUrls='" + mediaUrls + '\'' +
                '}';
    }
}
