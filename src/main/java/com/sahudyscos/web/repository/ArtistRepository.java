package com.sahudyscos.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.sahudyscos.web.entity.Artist;

// This will be AUTO IMPLEMENTED by Spring into a Bean called albumRepository
// CRUD refers Create, Read, Update, Delete

public interface ArtistRepository extends CrudRepository<Artist, Long> {

}