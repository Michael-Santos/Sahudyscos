package com.sahudyscos.web.controller.user;

import java.util.Optional;

import com.sahudyscos.web.entity.Release;
import com.sahudyscos.web.entity.key.ReleaseId;
import com.sahudyscos.web.repository.ReleaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReleaseController {

    @Autowired
    private ReleaseRepository releaseRepository;


    @GetMapping("/release")
    public String release(@RequestParam(name="id") Integer id,  @RequestParam(name="album") Integer albumId, Model model) {
        Optional<Release> currentRelease;

        currentRelease = releaseRepository.findById(new ReleaseId(id.longValue(), albumId.longValue()));

        model.addAttribute("release", currentRelease.get());
        return "release";
    }

}