package com.sahudyscos.web.repository;

import com.sahudyscos.web.entity.Label;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

// This will be AUTO IMPLEMENTED by Spring into a Bean called contractRepository
// CRUD refers Create, Read, Update, Delete

public interface LabelRepository extends JpaRepository<Label, Long>, QuerydslPredicateExecutor<Label> {
    List<Label> findByNameStartsWith(String name);
}