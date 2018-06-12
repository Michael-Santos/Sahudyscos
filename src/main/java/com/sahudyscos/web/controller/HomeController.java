package com.sahudyscos.web.controller;

import com.sahudyscos.web.controller.util.Pager;
import com.sahudyscos.web.entity.Album;
import com.sahudyscos.web.entity.Label;
import com.sahudyscos.web.entity.Release;
import com.sahudyscos.web.repository.AlbumRepository;
import com.sahudyscos.web.repository.LabelRepository;
import com.sahudyscos.web.repository.ReleaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 20, 30};

    @Autowired
    ReleaseRepository releaseRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    LabelRepository labelRepository;

    @Async
    @GetMapping("/")
    public String home(Model model, @Qualifier("release") Pageable releaseTab, @Qualifier("album") Pageable albumTab, @Qualifier("label") Pageable labelTab) {

        model.addAttribute("releases", releaseRepository.findAll(releaseTab));
        model.addAttribute("albums", albumRepository.findAll(albumTab));
        model.addAttribute("labels", labelRepository.findAll(labelTab));

        return "index";
    }

}