package com.sahudyscos.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;

import com.sahudyscos.web.entity.Album;

// This will be AUTO IMPLEMENTED by Spring into a Bean called albumRepository
// CRUD refers Create, Read, Update, Delete

public interface AlbumRepository extends CrudRepository<Album, Long> {
}