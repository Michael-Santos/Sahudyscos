package com.sahudyscos.web.repository;

import com.sahudyscos.web.entity.Contract;

import org.springframework.data.repository.PagingAndSortingRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called contractRepository
// CRUD refers Create, Read, Update, Delete

public interface PageContractRepository extends PagingAndSortingRepository<Contract, Long> {
}