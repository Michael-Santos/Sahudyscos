package com.sahudyscos.web.repository;

import com.sahudyscos.web.entity.Label;

import org.springframework.data.repository.PagingAndSortingRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called contractRepository
// CRUD refers Create, Read, Update, Delete

public interface PageLabelRepository extends PagingAndSortingRepository<Label, Long> {
}