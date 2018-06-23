package com.sahudyscos.web.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.sahudyscos.web.entity.Album;
import com.sahudyscos.web.entity.Artist;
import com.sahudyscos.web.entity.Label;
import com.sahudyscos.web.entity.Release;
import com.sahudyscos.web.repository.AlbumRepository;
import com.sahudyscos.web.service.ApiService;
import com.sahudyscos.web.service.HibernateSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {

	@Autowired
	private ApiService apiService;

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private HibernateSearchService hibernateSearchService;

	// TODO metaprogramação?

	@RequestMapping("/api/album/fts")
	@ResponseBody
	@JsonIgnoreProperties({ "artists" })
	Iterable<Album> getAlbums(@RequestParam(value = "search", required = false) String q, Predicate predicate) {
		return hibernateSearchService.fuzzySearch(q);
	}

	@RequestMapping("/api/artist/fts")
	@ResponseBody
	@JsonIgnoreProperties({ "albums", "labelsContracted" })
	List<Artist> getArtists(@RequestParam(name = "query") String search, Pageable pageable, Predicate predicate) {
		return apiService.findAllArtistsFTS(search);
	}

	@RequestMapping("/api/label/fts")
	@ResponseBody
	@JsonIgnoreProperties({ "artists" })
	List<Label> getLabels(@RequestParam(name = "query") String search, Pageable pageable, Predicate predicate) {
		return apiService.findAllLabelsFTS(search);
	}

	@RequestMapping("/api/release/fts")
	@ResponseBody
	@JsonIgnoreProperties({ "artists" })
	List<Release> getReleases(@RequestParam(name = "query") String search, Pageable pageable, Predicate predicate) {
		return apiService.findAllReleasesFTS(search);
	}

}
