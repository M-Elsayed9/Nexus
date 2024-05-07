package com.nexus.service;
import com.nexus.dto.OfficeDTO;
import com.nexus.entity.Office;
import com.nexus.entity.User;
import com.nexus.repository.OfficeRepository;
import com.nexus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;
    private final UserRepository userRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository, UserRepository userRepository) {
        this.officeRepository = officeRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public OfficeDTO createOffice(OfficeDTO officeDTO) {
        User landlord = userRepository.findById(officeDTO.getLandlordId())
                .orElseThrow(() -> new IllegalArgumentException("Landlord not found"));

        Office office = new Office(officeDTO.getName(), landlord, officeDTO.isAvailability());
        office = officeRepository.save(office);

        return convertToDTO(office);
    }

    @Transactional
    public OfficeDTO updateOffice(Long officeId, OfficeDTO officeDTO) {
        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> new IllegalArgumentException("Office not found"));

        User landlord = userRepository.findById(officeDTO.getLandlordId())
                .orElseThrow(() -> new IllegalArgumentException("Landlord not found"));

        office.setName(officeDTO.getName());
        office.setLandlord(landlord);
        office.setAvailability(officeDTO.isAvailability());

        office = officeRepository.save(office);
        return convertToDTO(office);
    }

    @Transactional
    public void deleteOffice(Long officeId) {
        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> new IllegalArgumentException("Office not found"));
        officeRepository.delete(office);
    }

    @Transactional(readOnly = true)
    public List<OfficeDTO> getAllOffices() {
        List<Office> offices = officeRepository.findAll();
        return offices.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OfficeDTO getOfficeById(Long officeId) {
        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> new IllegalArgumentException("Office not found"));
        return convertToDTO(office);
    }

    private OfficeDTO convertToDTO(Office office) {
        return new OfficeDTO(
                office.getName(),
                office.getLandlord().getId(),
                office.isAvailability(),
                office.getOfficeDetails().getRentalPrice(),
                office.getOfficeDetails().getDescription(),
                office.getOfficeDetails().getCapacity().intValue()
        );
    }
}
