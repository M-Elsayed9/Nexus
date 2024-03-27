package com.nexus.dto;
import com.nexus.entity.Office;
import com.nexus.entity.WishList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class WishListDTO {

    private Long id;
    private Long renterId;
    private Set<Office> offices;

    public WishListDTO(Long id, Long renterId, Set<Office> offices) {
        this.id = id;
        this.renterId = renterId;
        this.offices = offices;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WishListDTO{");
        sb.append("id=").append(id);
        sb.append(", renterId=").append(renterId);
        sb.append('}');
        return sb.toString();
    }
}
