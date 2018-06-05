package com.sahudyscos.web.controller;

import com.sahudyscos.web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
	private UserService userService;

    @RequestMapping("/admin/home")
    public String home(Model model) {
        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        model.addAttribute("username", user.getUsername());*/
        return "admin";
    }

}