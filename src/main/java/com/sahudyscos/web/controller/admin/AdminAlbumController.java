package com.sahudyscos.web.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.Predicate;
import com.sahudyscos.web.entity.Album;
import com.sahudyscos.web.entity.Artist;
import com.sahudyscos.web.repository.AlbumRepository;
import com.sahudyscos.web.repository.ArtistRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    private ArtistRepository artistRepository;

    @Async
    @GetMapping("/admin/album")
    public String album(Model model, @QuerydslPredicate(root = Album.class) Predicate predicate, 
                        Pageable pageable, @RequestParam MultiValueMap<String, String> parameters, 
                        @RequestHeader(name = "Update-Table", defaultValue = "false") Boolean update) {
        model.addAttribute("albums", albumRepository.findAll(predicate, pageable));
        model.addAttribute("formContent", new albumFormPOJO(new Album(), new ArrayList<Long>()));
        
        return update ? "admin/album :: searchBody" : "admin/album";
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
    public ModelAndView create(@ModelAttribute albumFormPOJO formContent) {
        List<Artist> artists = (List<Artist>) artistRepository.findAllById(formContent.getArtistsIds());
        formContent.getAlbum().setArtists(artists);
        logger.info(formContent.getArtistsIds().toString());
        albumRepository.save(formContent.getAlbum());
        return new ModelAndView("redirect:/admin/album");
    }

    @PostMapping(value = "/admin/album/delete")
    public ModelAndView delete(@ModelAttribute albumFormPOJO formContent) {
        albumRepository.delete(formContent.getAlbum());
        return new ModelAndView("redirect:/admin/album");
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
