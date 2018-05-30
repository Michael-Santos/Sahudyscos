package com.sahudyscos.web.repository;

import com.sahudyscos.web.entity.Contract;
import com.sahudyscos.web.entity.key.ContractId;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called contractRepository
// CRUD refers Create, Read, Update, Delete

public interface ContractRepository extends CrudRepository<Contract, ContractId> {
}