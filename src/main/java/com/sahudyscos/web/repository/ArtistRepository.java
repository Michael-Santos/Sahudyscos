package com.sahudyscos.web.repository;

import java.util.List;
import java.util.Optional;

import com.querydsl.core.types.dsl.StringPath;
import com.sahudyscos.web.entity.Artist;
import com.sahudyscos.web.entity.QArtist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

// This will be AUTO IMPLEMENTED by Spring into a Bean called albumRepository
// CRUD refers Create, Read, Update, Delete

public interface ArtistRepository extends JpaRepository<Artist, Long>, QuerydslPredicateExecutor<Artist>, QuerydslBinderCustomizer<QArtist>, JpaSpecificationExecutor<Artist> {
    Optional<Artist> findById(Long id);
    List<Artist> findByNameStartsWith(String name);

    default void customize(QuerydslBindings bindings, QArtist artist) {
        bindings.bind(artist.name).first((path, value) -> path.contains(value));
        bindings.bind(String.class).first((StringPath path, String value) -> path.contains(value));
    }
}