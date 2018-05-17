package com.sahudyscos.web.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.sahudyscos.web.entity.Recording;

// This will be AUTO IMPLEMENTED by Spring into a Bean called albumRepository
// CRUD refers Create, Read, Update, Delete

public interface RecordingRepository extends CrudRepository<Recording, Long> {
    public List<Recording> findByAlbumId(Long albumId);
}