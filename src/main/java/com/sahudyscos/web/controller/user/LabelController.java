package com.sahudyscos.web.controller.user;

import java.util.Optional;

import com.sahudyscos.web.entity.Label;
import com.sahudyscos.web.repository.LabelRepository;
import com.sahudyscos.web.service.WikiMediaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LabelController {

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private WikiMediaService wikiMediaService;
    
    @GetMapping("/label")
    public String artist(@RequestParam(name="id") Integer id, Model model) {
        Optional<Label> currentLabel;

        currentLabel = labelRepository.findById(id.longValue());

        model.addAttribute("name", currentLabel.get().getName());
        model.addAttribute("date", currentLabel.get().getActivityStart());
        model.addAttribute("genre", currentLabel.get().getGenre());
        model.addAttribute("altGenre", currentLabel.get().getAltGenre());
        model.addAttribute("releases", currentLabel.get().getReleases());
        model.addAttribute("description", wikiMediaService.getDescription(currentLabel.get().getName()));

        return "label";
    }

}