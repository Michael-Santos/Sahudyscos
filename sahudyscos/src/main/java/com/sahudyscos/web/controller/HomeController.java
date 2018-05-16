package com.sahudyscos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    /*@GetMapping("/album")
    public String album() {
        return "album";
    }

    @GetMapping("/artist")
    public String artist() {
        return "artist";
    }

    @GetMapping("/label")
    public String label() {
        return "label";
    }*/

    

}