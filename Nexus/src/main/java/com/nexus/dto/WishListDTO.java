package com.nexus.dto;
import com.nexus.entity.Office;
import java.util.HashSet;
import java.util.Set;

public class WishListDTO {

    private Long id;
    private Long renterId;
    private Set<Office> offices = new HashSet<>();

    public WishListDTO() {

    }

    public WishListDTO(Long id, Long renterId, Set<Office> offices) {
        this.id = id;
        this.renterId = renterId;
        this.offices = offices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRenterId() {
        return renterId;
    }

    public void setRenterId(Long renterId) {
        this.renterId = renterId;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    @Override
    public String toString() {
        return "WishListDTO{" +
                "id=" + id +
                ", renterId=" + renterId +
                ", offices=" + offices +
                '}';
    }
}
