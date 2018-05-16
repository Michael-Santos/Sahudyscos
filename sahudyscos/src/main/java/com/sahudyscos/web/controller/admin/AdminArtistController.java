package com.sahudyscos.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminArtistController {

    @GetMapping("/admin/artist")
    public String home() {
        return "admin-artist";
    }

}