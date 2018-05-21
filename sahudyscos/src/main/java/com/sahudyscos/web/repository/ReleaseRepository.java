package com.sahudyscos.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.sahudyscos.web.entity.Release;
import com.sahudyscos.web.entity.key.ReleaseId;

// This will be AUTO IMPLEMENTED by Spring into a Bean called releaseRepository
// CRUD refers Create, Read, Update, Delete

public interface ReleaseRepository extends CrudRepository<Release, ReleaseId> {
    
}