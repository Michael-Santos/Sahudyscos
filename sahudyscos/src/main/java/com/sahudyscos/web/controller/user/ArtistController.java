package com.sahudyscos.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtistController {

    @GetMapping("/artist")
    public String home() {
        return "artist";
    }

}