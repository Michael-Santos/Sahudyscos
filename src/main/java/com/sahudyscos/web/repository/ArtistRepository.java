package com.sahudyscos.web.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.sahudyscos.web.entity.Artist;

// This will be AUTO IMPLEMENTED by Spring into a Bean called albumRepository
// CRUD refers Create, Read, Update, Delete

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    List<Artist> findByNameStartsWith(String name);
}