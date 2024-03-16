package com.nexus.repository;

import com.nexus.entity.OfficeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeDetailsRepository extends JpaRepository<OfficeDetails, Long> {
    OfficeDetails findByOfficeId(Long officeId);
}
