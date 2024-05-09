package com.nexus.controller.rest;

import com.nexus.dto.OfficeDTO;
import com.nexus.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offices")
public class OfficeRestController {
    private final OfficeService officeService;

    @Autowired
    public OfficeRestController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping
    public ResponseEntity<OfficeDTO> createOffice(@RequestBody OfficeDTO officeDTO) {
        OfficeDTO createdOffice = officeService.createOffice(officeDTO);
        return new ResponseEntity<>(createdOffice, HttpStatus.CREATED);
    }

    @PutMapping("/{officeId}")
    public ResponseEntity<OfficeDTO> updateOffice(@PathVariable Long officeId, @RequestBody OfficeDTO officeDTO) {
        OfficeDTO updatedOffice = officeService.updateOffice(officeId, officeDTO);
        return ResponseEntity.ok(updatedOffice);
    }

    @DeleteMapping("/{officeId}")
    public ResponseEntity<Void> deleteOffice(@PathVariable Long officeId) {
        officeService.deleteOffice(officeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<OfficeDTO>> getAllOffices() {
        List<OfficeDTO> offices = officeService.getAllOffices();
        return ResponseEntity.ok(offices);
    }

    @GetMapping("/{officeId}")
    public ResponseEntity<OfficeDTO> getOfficeById(@PathVariable Long officeId) {
        OfficeDTO office = officeService.getOfficeById(officeId);
        return ResponseEntity.ok(office);
    }
}
