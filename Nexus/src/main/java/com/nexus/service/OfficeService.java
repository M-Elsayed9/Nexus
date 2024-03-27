package com.nexus.service;
import com.nexus.entity.Office;
import com.nexus.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    //use dto
    @Transactional(readOnly = true)
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    //use dto, ensure office is added to the landlord offices set
    @Transactional
    public Office addOffice(Office office) {
        return officeRepository.save(office);
    }

    //use dto
    @Transactional(readOnly = true)
    public Office getOfficeById(Long id) {
        return officeRepository.findById(id).orElse(null);
    }

    //use dto, remove office from landlord offices set
    @Transactional
    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }

    //use dto
    @Transactional
    public Office updateOffice(Office office) {
        return officeRepository.save(office);
    }
}
