package com.sahudyscos.web.controller.user;

import java.util.Optional;

import com.sahudyscos.web.entity.Label;
import com.sahudyscos.web.repository.LabelRepository;
import com.sahudyscos.web.repository.ReleaseRepository;
import com.sahudyscos.web.service.WikiMediaService; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LabelController {

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private ReleaseRepository releaseRepository;

    @Autowired
    private WikiMediaService wikiMediaService;

    @GetMapping("/label")
    public String label(@RequestParam(name="id") Integer id, Pageable page, Model model,
                        @RequestHeader(name = "Update-Table", defaultValue = "false") Boolean update) {
        Optional<Label> currentLabel;

        currentLabel = labelRepository.findById(id.longValue());

        model.addAttribute("label", currentLabel.get());
        model.addAttribute("releases", releaseRepository.findAllByLabelId(id.longValue(), page));
        model.addAttribute("description", wikiMediaService.getDescription(currentLabel.get().getName()));
        
        return update ? "label :: searchBody" : "label";
    }

}