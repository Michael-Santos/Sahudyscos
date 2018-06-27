package com.sahudyscos.web.controller.user;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Optional;

import com.sahudyscos.web.entity.Album;
import com.sahudyscos.web.repository.AlbumRepository;
import com.sahudyscos.web.service.WikiMediaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private WikiMediaService wikiMediaService;

    @GetMapping("/album")
    public String album(@RequestParam(name="id") Integer id, Model model) {
        Optional<Album> currentAlbum;

        currentAlbum = albumRepository.findById(id.longValue());
        
        model.addAttribute("album", currentAlbum.get());
        model.addAttribute("description", wikiMediaService.getDescription(currentAlbum.get().getName()));
        return "album";
    }

}