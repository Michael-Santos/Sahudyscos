package com.sahudyscos.web.repository;

import java.util.List;

import com.sahudyscos.web.entity.Artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

// This will be AUTO IMPLEMENTED by Spring into a Bean called albumRepository
// CRUD refers Create, Read, Update, Delete

public interface ArtistRepository extends JpaRepository<Artist, Long>, QuerydslPredicateExecutor<Artist> {
    List<Artist> findByNameStartsWith(String name);
}