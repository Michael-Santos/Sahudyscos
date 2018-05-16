package com.sahudyscos.web.controller.user;

import java.util.Optional;

import com.sahudyscos.web.entity.Album;
import com.sahudyscos.web.repository.AlbumRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    /*@GetMapping("/")
    public String home() {
        return "album";
    }*/

    @RequestMapping(path="/album")
	public @ResponseBody Optional<Album> getById(@RequestParam(name="id") Integer id) {
        // This returns a JSON or XML with the users
        return albumRepository.findById(id.longValue());
	}

}