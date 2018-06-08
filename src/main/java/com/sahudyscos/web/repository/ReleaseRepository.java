package com.sahudyscos.web.repository;

import com.sahudyscos.web.entity.Release;
import com.sahudyscos.web.entity.key.ReleaseId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

// This will be AUTO IMPLEMENTED by Spring into a Bean called contractRepository
// CRUD refers Create, Read, Update, Delete

public interface ReleaseRepository extends JpaRepository<Release, ReleaseId>, QuerydslPredicateExecutor<Release> {
}