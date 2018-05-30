package com.sahudyscos.web.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.sahudyscos.web.entity.Label;

// This will be AUTO IMPLEMENTED by Spring into a Bean called labelRepository
// CRUD refers Create, Read, Update, Delete

public interface LabelRepository extends CrudRepository<Label, Long> {
    List<Label> findByNameStartsWith(String name);
}