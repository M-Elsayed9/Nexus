package com.nexus.repository;

import com.nexus.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {
    Office findByName(String name);

    Office findByLandlordId(Long landlordId);

    Office findByAvailability(boolean availability);

    Office findByOfficeDetailsId(Long officeDetailsId);

    Office findByOfficeDetailsIdAndAvailability(Long officeDetailsId, boolean availability);
}
