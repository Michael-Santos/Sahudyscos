package com.sahudyscos.web.repository;

import java.util.List;

import com.sahudyscos.web.entity.Album;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

// This will be AUTO IMPLEMENTED by Spring into a Bean called albumRepository
// CRUD refers Create, Read, Update, Delete

/* TODO rename this maybe? */
public interface AlbumRepository extends JpaRepository<Album, Long>, QuerydslPredicateExecutor<Album> {
    List<Album> findByNameStartsWith(String name);
}