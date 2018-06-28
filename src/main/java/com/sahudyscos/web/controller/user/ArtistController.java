package com.sahudyscos.web.controller.user;

import java.util.Optional;

import com.sahudyscos.web.entity.Artist;
import com.sahudyscos.web.repository.AlbumRepository;
import com.sahudyscos.web.repository.ArtistRepository;
import com.sahudyscos.web.service.WikiMediaService; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private WikiMediaService wikiMediaService;

    @GetMapping("/artist")
    public String artist(@RequestParam(name="id") Integer id, Pageable page, Model model,
                         @RequestHeader(name = "Update-Table", defaultValue = "false") Boolean update) {
        Optional<Artist> currentArtist;

        currentArtist = artistRepository.findById(id.longValue());

        model.addAttribute("artist", currentArtist.get());
        model.addAttribute("description", wikiMediaService.getDescription(currentArtist.get().getName()));
        model.addAttribute("albums", albumRepository.findAllByArtistsId(id.longValue(), page));
        return update ? "artist :: searchBody" : "artist";
    }

}