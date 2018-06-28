package com.sahudyscos.web.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sahudyscos.web.entity.Album;
import com.sahudyscos.web.entity.Artist;
import com.sahudyscos.web.entity.Label;
import com.sahudyscos.web.entity.Release;
import com.sahudyscos.web.repository.AlbumRepository;
import com.sahudyscos.web.repository.ArtistRepository;
import com.sahudyscos.web.repository.LabelRepository;
import com.sahudyscos.web.repository.ReleaseRepository;
import com.sahudyscos.web.specification.Specifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("apiService")
public class ApiServiceImpl implements ApiService{

	@Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ReleaseRepository releaseRepository;
    
    @PersistenceContext
    private EntityManager em;
	
	@Override
    public List<Album> findAllAlbumsFTS(String search) {
        return albumRepository.findAll(Specifications.albumFts(search));
    }

    public List<Label> findAllLabelsFTS(String search) {
        return labelRepository.findAll(Specifications.labelFts(search));
    }

    public List<Artist> findAllArtistsFTS(String search) {
        return artistRepository.findAll(Specifications.artistFts(search));
    }

    public List<Release> findAllReleasesFTS(String search) {
        return releaseRepository.findAll(Specifications.releaseFts(search));
    }
}