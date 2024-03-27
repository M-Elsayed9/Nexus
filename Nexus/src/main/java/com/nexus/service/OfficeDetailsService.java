package com.nexus.service;

import com.nexus.dto.OfficeDetailsDTO;
import com.nexus.entity.OfficeDetails;
import com.nexus.repository.OfficeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OfficeDetailsService {

    private final OfficeDetailsRepository officeDetailsRepository;

    @Autowired
    public OfficeDetailsService(OfficeDetailsRepository officeDetailsRepository) {
        this.officeDetailsRepository = officeDetailsRepository;
    }

    //use dto
    @Transactional
    public OfficeDetails saveOfficeDetails(OfficeDetails officeDetails) {
        return officeDetailsRepository.save(officeDetails);
    }

    //use dto
    @Transactional(readOnly = true)
    public OfficeDetails getOfficeDetailsById(Long id) {
        return officeDetailsRepository.findById(id).orElse(null);
    }

    //use dto
    @Transactional
    public OfficeDetails updateOfficeDetails(OfficeDetails officeDetails) {
        return officeDetailsRepository.save(officeDetails);
    }
}
