package com.sahudyscos.web.repository;

import com.sahudyscos.web.entity.Artist;

import org.springframework.data.repository.PagingAndSortingRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called albumRepository
// CRUD refers Create, Read, Update, Delete

public interface PageArtistRepository extends PagingAndSortingRepository<Artist, Long> {
}