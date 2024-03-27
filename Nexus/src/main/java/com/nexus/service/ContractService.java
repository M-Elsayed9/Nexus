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

    //use dto, ensure the set of the contracts in the user entity is added
    @Transactional
    public void addContract(Contract contract) {
        contractRepository.save(contract);
    }

    //use dto
    @Transactional(readOnly = true)
    public Contract getContractById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    //use dto
    @Transactional(readOnly = true)
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    //use dto
    @Transactional
    public Contract updateContract(Contract contract) {
        return contractRepository.save(contract);
    }

    //use dto, ensure the contract is removed from contracts in the user entity is removed
    @Transactional
    public void deleteContract(Long id) { contractRepository.deleteById(id); }
}
