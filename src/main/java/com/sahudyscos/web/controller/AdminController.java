package com.sahudyscos.web.controller;

import com.sahudyscos.web.repository.ReleaseRepository;
import com.sahudyscos.web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    ReleaseRepository releaseRepository;

    private static int THRESHOLD = 3;

    @RequestMapping("/admin/home")
    public String home(Model model) {
        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        model.addAttribute("username", user.getUsername());*/
        Float threshold = Float.valueOf(THRESHOLD);
        model.addAttribute("warningCount", releaseRepository.getWarningCount(threshold));
        model.addAttribute("threshold", THRESHOLD);
        return "admin";
    }

}