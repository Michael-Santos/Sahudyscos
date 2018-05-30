package com.sahudyscos.web.controller.admin;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahudyscos.web.controller.util.Pager;
import com.sahudyscos.web.entity.Artist;
import com.sahudyscos.web.repository.ArtistRepository;
import com.sahudyscos.web.repository.PageArtistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminArtistController {
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 20, 30};

    @Autowired
    private PageArtistRepository pageArtistRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/admin/artist")
    public String artist(Model model, Pageable pageable) {
        Page<Artist> page = pageArtistRepository.findAll(pageable);
        Pager pager = new Pager(page.getTotalPages(),page.getNumber(),BUTTONS_TO_SHOW);
        model.addAttribute("artists", page);
        model.addAttribute("pageSizes", PAGE_SIZES);
        model.addAttribute("pager", pager);
        model.addAttribute("artist", new Artist());
        return "admin-artist";
    }

    @PostMapping(value = "/admin/artist", consumes="application/json")
    @ResponseBody
    @JsonIgnoreProperties({"releases"})
    public Optional<Artist> view (@RequestBody String json) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Artist> currentArtist;
        artistRequest request;

        try {
            request = mapper.readValue(json, artistRequest.class);
            currentArtist = artistRepository.findById(Long.valueOf(request.getId()));
            return currentArtist;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/admin/artist/save")
    public String create(@ModelAttribute Artist artist) {
        return "admin-artist";
    }
}

class artistRequest {
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