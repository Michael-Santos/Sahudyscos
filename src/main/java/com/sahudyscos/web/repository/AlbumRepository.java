package com.sahudyscos.web.repository;

import java.util.List;

import com.sahudyscos.web.entity.Album;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called albumRepository
// CRUD refers Create, Read, Update, Delete

public interface AlbumRepository extends CrudRepository<Album, Long> {
    List<Album> findByNameStartsWith(String name);
}