package com.nexus.dto;

import java.math.BigDecimal;

public class OfficeDTO {
    private Long id;
    private String name;
    private Long landlordId;
    private boolean availability;
    private BigDecimal rentalPrice;
    private String description;
    private Integer capacity;
    private String mediaUrls;

    public OfficeDTO() {
    }

    public OfficeDTO(Long id, String name, Long landlordId, boolean availability, BigDecimal rentalPrice, String description, Integer capacity, String mediaUrls) {
        this.id = id;
        this.name = name;
        this.landlordId = landlordId;
        this.availability = availability;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Long landlordId) {
        this.landlordId = landlordId;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
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
        return "OfficeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", landlordId=" + landlordId +
                ", availability=" + availability +
                ", rentalPrice=" + rentalPrice +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", mediaUrls='" + mediaUrls + '\'' +
                '}';
    }
}
