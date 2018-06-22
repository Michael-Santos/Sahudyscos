package com.sahudyscos.web.repository;

import java.util.List;
import java.util.Optional;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;
import com.sahudyscos.web.entity.Album;
import com.querydsl.core.types.dsl.Expressions;
import com.sahudyscos.web.entity.QAlbum;

import com.querydsl.core.types.TemplateExpression;;

import org.hibernate.SQLQuery;
import org.hibernate.query.NativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RestResource;

import com.querydsl.core.types.dsl.BooleanTemplate;

// This will be AUTO IMPLEMENTED by Spring into a Bean called albumRepository
// CRUD refers Create, Read, Update, Delete

/* TODO rename this maybe? */
public interface AlbumRepository extends JpaRepository<Album, Long>, QuerydslPredicateExecutor<Album>, QuerydslBinderCustomizer<QAlbum>, JpaSpecificationExecutor<Album> {
    Optional<Album> findById(Long id);

    List<Album> findByNameStartsWith(String name);

    @RestResource(rel = "name")
    Page<Album> findByNameStartsWith(Pageable page, String name);

    @RestResource(rel = "expName")
    @Query(value = "SELECT * FROM (SELECT album.cod_album AS cod_album FROM album WHERE to_tsvector('english', nome) @@ plainto_tsquery('english', ?1)) AS t1 NATURAL JOIN album", nativeQuery = true)
    List<Album> findByExpName(String name);

    @RestResource(rel = "expName")
    @Query(value = "SELECT * FROM (SELECT album.cod_album AS cod_album FROM album WHERE to_tsvector('english', nome) @@ plainto_tsquery('english', ?1)) AS t1 NATURAL JOIN album", nativeQuery = true)
    Page<Album> findByExpNamePaged(String name, Pageable pageable, Predicate predicate);

    default void customize(QuerydslBindings bindings, QAlbum album) {
		  bindings.bind(album.name).first((path, value) -> path.contains(value));
          bindings.bind(album.document).first((StringPath path, String value) -> Expressions.booleanTemplate("FUNCTION('fts', {0}, {1}) = true ", path, value)); // TODO add boolean op!!! maybe change the source code of querydsl itself
    }
}