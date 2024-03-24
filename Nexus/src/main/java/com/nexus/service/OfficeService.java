package com.nexus.service;
import com.nexus.entity.Office;
import com.nexus.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    public Office getOfficeById(Long id) {
        return officeRepository.findById(id).orElse(null);
    }

    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }

    public Office updateOffice(Office office) {
        return officeRepository.save(office);
    }
}
