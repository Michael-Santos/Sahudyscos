package com.sahudyscos.web.service;


import java.util.List;

import com.sahudyscos.web.entity.Album;
import com.sahudyscos.web.entity.Artist;
import com.sahudyscos.web.entity.Label;
import com.sahudyscos.web.entity.Release;

public interface ApiService {
    public List<Album> findAllAlbumsFTS(String search);
    public List<Label> findAllLabelsFTS(String search);
    public List<Artist> findAllArtistsFTS(String search);
    public List<Release> findAllReleasesFTS(String search);
}