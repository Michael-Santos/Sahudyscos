package com.sahudyscos.web.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahudyscos.web.controller.util.Pager;
import com.sahudyscos.web.entity.Album;
import com.sahudyscos.web.entity.Artist;
import com.sahudyscos.web.repository.AlbumRepository;
import com.sahudyscos.web.repository.ArtistRepository;
import com.sahudyscos.web.repository.PageAlbumRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AdminAlbumController {
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 20, 30};

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PageAlbumRepository pageAlbumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/admin/album")
    public String album(Model model, Pageable pageable) {
        Page<Album> page = pageAlbumRepository.findAll(pageable);
        Pager pager = new Pager(page.getTotalPages(),page.getNumber(),BUTTONS_TO_SHOW);
        model.addAttribute("albums", page);
        model.addAttribute("pageSizes", PAGE_SIZES);
        model.addAttribute("pager", pager);
        model.addAttribute("formContent", new albumFormPOJO(new Album(), new ArrayList<Long>()));
        return "admin-album";
    }

    @PostMapping(value = "/admin/album", consumes="application/json")
    @ResponseBody
    @JsonIgnoreProperties({"releases"})
    public Optional<Album> view (@RequestBody String json) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Album> currentAlbum;
        albumRequest request;

        try {
            request = mapper.readValue(json, albumRequest.class);
            currentAlbum = albumRepository.findById(Long.valueOf(request.getId()));
            return currentAlbum;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/admin/album/artist")
    @ResponseBody
    @JsonIgnoreProperties({"description", "genre", "altGenre", "activityStart", "albums", "labelsContracted"})
	List<Artist> getArtists(@RequestParam String name) {
		return artistRepository.findByNameStartsWith(name);
    }
    
    @PostMapping(value = "/admin/album/save")
    public String create(@ModelAttribute albumFormPOJO formContent) {
        List<Artist> artists = (List<Artist>) artistRepository.findAllById(formContent.getArtistsIds());
        formContent.getAlbum().setArtists(artists);
        logger.info(formContent.getArtistsIds().toString());
        albumRepository.save(formContent.getAlbum());
        return "admin-album";
    }

    @PostMapping(value = "/admin/album/delete")
    public String delete(@ModelAttribute albumFormPOJO formContent) {
        albumRepository.delete(formContent.getAlbum());
        return "admin-album";
    }

    @RequestMapping(value="/admin/album", params={"addArtist"})
    public String addArtist(final Album album, final BindingResult bindingResult, @RequestParam("artist") Artist reqArtist) {
        Optional<Artist> artist = artistRepository.findById(reqArtist.getId());
        if (artist.get() != null) {
            album.getArtists().add(artist.get());
        }
        return "admin-album";
    }

    @RequestMapping(value="/admin/album", params={"viewAlbum"})
    public String viewAlbum(albumFormPOJO formContent, final BindingResult bindingResult, @RequestParam("id") Integer id) {
        formContent.setAlbum(albumRepository.findById(Long.valueOf(id)).get());
        return "admin-album";
    }

    @RequestMapping(value="/admin/album", params={"removeArtist"})
    public String removeArtist(
            final Album album, final BindingResult bindingResult, 
            final HttpServletRequest req) {
        album.getArtists().remove(Integer.valueOf(req.getParameter("removeArtist")).intValue());
        return "admin-album";
    }
}

class albumRequest {
    private String type;
    private Integer id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

class albumFormPOJO {
    private Album album;
    private List<Long> artistsIds;

    albumFormPOJO () { }

    albumFormPOJO(Album album, List<Long> artistsIds) {
        this.album = album;
        this.artistsIds = artistsIds;
        artistsIds.size();
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Long> getArtistsIds() {
        return artistsIds;
    }

    public void setArtistsIds(List<Long> artistIds) {
        this.artistsIds = artistIds;
    }
}