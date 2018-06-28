package com.sahudyscos.web.repository;

import java.util.Optional;

import com.sahudyscos.web.entity.Contract;
import com.sahudyscos.web.entity.QContract;

import com.sahudyscos.web.entity.key.ContractId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBindings;

// This will be AUTO IMPLEMENTED by Spring into a Bean called contractRepository
// CRUD refers Create, Read, Update, Delete

public interface ContractRepository extends JpaRepository<Contract, ContractId>,  QuerydslBinderCustomizer<QContract>, QuerydslPredicateExecutor<Contract> {
    Optional<Contract> findById(ContractId id);

    default void customize(QuerydslBindings bindings, QContract contract) {
        bindings.bind(contract.artist.name).first((path, value) -> path.contains(value));
        bindings.bind(contract.label.name).first((path, value) -> path.contains(value));
    }
}