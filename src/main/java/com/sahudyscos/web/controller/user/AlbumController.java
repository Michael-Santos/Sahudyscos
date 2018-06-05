package com.sahudyscos.web.controller.user;

import java.util.Optional;

import com.sahudyscos.web.entity.Album;
import com.sahudyscos.web.repository.AlbumRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;


    @GetMapping("/album")
    public String album(@RequestParam(name="id") Integer id, Model model) {
        Optional<Album> currentAlbum;

        currentAlbum = albumRepository.findById(id.longValue());

        model.addAttribute("id", id);
        model.addAttribute("name", currentAlbum.get().getName());
        model.addAttribute("country", currentAlbum.get().getCountry());
        model.addAttribute("publication", currentAlbum.get().getPublication());
        model.addAttribute("rating", currentAlbum.get().getRating());
        model.addAttribute("artists", currentAlbum.get().getArtists());
        model.addAttribute("releases", currentAlbum.get().getReleases());
        return "album";
    }

}