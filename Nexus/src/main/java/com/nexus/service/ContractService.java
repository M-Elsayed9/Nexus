package com.nexus.service;
import com.nexus.entity.Contract;
import com.nexus.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Transactional
    public void addContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Transactional(readOnly = true)
    public Contract getContractById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Transactional
    public Contract updateContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Transactional
    public void deleteContract(Long id) { contractRepository.deleteById(id); }

    @Transactional
    public void deleteAllContracts(Long id) { contractRepository.deleteAll(); }

}
