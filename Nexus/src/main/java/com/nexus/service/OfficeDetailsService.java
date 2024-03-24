package com.nexus.service;

import com.nexus.entity.OfficeDetails;
import com.nexus.repository.OfficeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeDetailsService {

    private final OfficeDetailsRepository officeDetailsRepository;

    @Autowired
    public OfficeDetailsService(OfficeDetailsRepository officeDetailsRepository) {
        this.officeDetailsRepository = officeDetailsRepository;
    }

    public List<OfficeDetails> getAllOfficeDetails() {
        return officeDetailsRepository.findAll();
    }

    public OfficeDetails saveOfficeDetails(OfficeDetails officeDetails) {
        return officeDetailsRepository.save(officeDetails);
    }

    public OfficeDetails getOfficeDetailsById(Long id) {
        return officeDetailsRepository.findById(id).orElse(null);
    }

    public void deleteOfficeDetails(Long id) {
        officeDetailsRepository.deleteById(id);
    }

    public OfficeDetails updateOfficeDetails(OfficeDetails officeDetails) {
        return officeDetailsRepository.save(officeDetails);
    }
}
