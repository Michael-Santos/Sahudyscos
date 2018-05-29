package com.sahudyscos.web.controller.admin;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahudyscos.web.entity.Artist;
import com.sahudyscos.web.repository.ArtistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/admin/artist")
    public String home() {
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