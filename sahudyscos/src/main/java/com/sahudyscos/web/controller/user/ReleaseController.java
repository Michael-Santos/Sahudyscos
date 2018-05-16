package com.sahudyscos.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReleaseController {

    @GetMapping("/release")
    public String home() {
        return "release";
    }

}