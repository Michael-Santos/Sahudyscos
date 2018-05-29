package com.sahudyscos.web.controller.user;

import java.util.Optional;

import com.sahudyscos.web.entity.Artist;
import com.sahudyscos.web.repository.ArtistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;


    @GetMapping("/artist")
    public String artist(@RequestParam(name="id") Integer id, Model model) {
        Optional<Artist> currentArtist;

        currentArtist = artistRepository.findById(id.longValue());

        model.addAttribute("name", currentArtist.get().getName());
        model.addAttribute("description", currentArtist.get().getDescription());
        model.addAttribute("date", currentArtist.get().getActivityStart());
        model.addAttribute("genre", currentArtist.get().getGenre());
        model.addAttribute("altGenre", currentArtist.get().getAltGenre());
        model.addAttribute("albums", currentArtist.get().getAlbums());
        return "artist";
    }

}