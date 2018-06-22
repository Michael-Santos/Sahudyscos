package com.sahudyscos.web.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.sahudyscos.web.entity.Album;
import com.sahudyscos.web.entity.Artist;
import com.sahudyscos.web.entity.Label;
import com.sahudyscos.web.entity.Release;

import org.springframework.data.jpa.domain.Specification;

public class Specifications {
	public static Specification<Album> albumFts(String search) {
		return new Specification<Album>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Album> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.isTrue(cb.function("fts", Boolean.class, cb.literal(search)));
			}
		};
	}

	public static Specification<Release> releaseFts(String search) {
		return new Specification<Release>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Release> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.isTrue(cb.function("fts", Boolean.class, cb.literal(search)));
			}
		};
	}

	public static Specification<Label> labelFts(String search) {
		return new Specification<Label>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.isTrue(cb.function("fts", Boolean.class, cb.literal(search)));
			}
		};
	}

	public static Specification<Artist> artistFts(String search) {
		return new Specification<Artist>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Artist> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.isTrue(cb.function("fts", Boolean.class, cb.literal(search)));
			}
		};
	}
}