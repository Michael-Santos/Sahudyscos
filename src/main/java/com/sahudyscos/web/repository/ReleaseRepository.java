package com.sahudyscos.web.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sahudyscos.web.entity.Release;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringPath;
import com.sahudyscos.web.entity.QRelease;
import com.sahudyscos.web.entity.key.ReleaseId;
import com.sahudyscos.web.entity.projection.Query1Result;
import com.sahudyscos.web.entity.projection.Query2Result;
import com.sahudyscos.web.entity.projection.Ranking;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called contractRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface ReleaseRepository extends JpaRepository<Release, ReleaseId>, QuerydslPredicateExecutor<Release>, QuerydslBinderCustomizer<QRelease>, JpaSpecificationExecutor<Release> {
    Optional<Release> findById(ReleaseId id);

    default void customize(QuerydslBindings bindings, QRelease release) {
        bindings.bind(release.album.name).first((path, value) -> path.contains(value));
        bindings.bind(release.releaseDate).first((path, value) -> Expressions.booleanTemplate("FUNCTION('checkDecade', {0}, {1}) = true ", path, value.toString()));
    }

    @Query(value = "SELECT COUNT(*) AS ranking, formato AS item FROM versao GROUP BY item ORDER BY ranking DESC", nativeQuery=true)
    public List<Ranking> getFormats();

    @Query(value = "SELECT COUNT(*) AS ranking, tipo_versao AS item FROM versao GROUP BY item ORDER BY ranking DESC", nativeQuery=true)
    public List<Ranking> getTypes();

    @Query(value = "SELECT * FROM consulta1(CAST(?1 AS text), CAST (?2 AS numeric))", nativeQuery=true)
    public Page<Query1Result> getQuery1(String name, Float price, Pageable page);

    @Query(value = "SELECT * FROM consulta2(CAST(?1 AS text), CAST (?2 AS numeric))", nativeQuery=true)
    public Page<Query2Result> getQuery2(String country, Float rating, Pageable page);
}