package com.sahudyscos.web.repository;

import com.querydsl.core.types.dsl.StringPath;
import com.sahudyscos.web.entity.Label;
import com.sahudyscos.web.entity.QLabel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

// This will be AUTO IMPLEMENTED by Spring into a Bean called contractRepository
// CRUD refers Create, Read, Update, Delete

public interface LabelRepository extends JpaRepository<Label, Long>, QuerydslPredicateExecutor<Label>, QuerydslBinderCustomizer<QLabel>, JpaSpecificationExecutor<Label> {
    Optional<Label> findById(Long id);
    List<Label> findByNameStartsWith(String name);

    default void customize(QuerydslBindings bindings, QLabel label) {
        bindings.bind(label.name).first((path, value) -> path.contains(value));
        bindings.bind(String.class).first((StringPath path, String value) -> path.contains(value));
    }
}