package com.sahudyscos.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminAlbumController {

    @GetMapping("/admin/album")
    public String home() {
        return "admin-album";
    }

}