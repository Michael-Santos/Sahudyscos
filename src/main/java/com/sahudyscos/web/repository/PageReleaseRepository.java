package com.sahudyscos.web.repository;

import com.sahudyscos.web.entity.Release;
import com.sahudyscos.web.entity.key.ReleaseId;

import org.springframework.data.repository.PagingAndSortingRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called contractRepository
// CRUD refers Create, Read, Update, Delete

public interface PageReleaseRepository extends PagingAndSortingRepository<Release, ReleaseId> {
}