package com.sahudyscos.web.controller;

import com.sahudyscos.web.controller.util.Pager;
import com.sahudyscos.web.entity.Album;
import com.sahudyscos.web.entity.Label;
import com.sahudyscos.web.entity.Release;
import com.sahudyscos.web.repository.PageAlbumRepository;
import com.sahudyscos.web.repository.PageLabelRepository;
import com.sahudyscos.web.repository.PageReleaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    PageReleaseRepository pageReleaseRepository;

    @Autowired
    PageAlbumRepository pageAlbumRepository;

    @Autowired
    PageLabelRepository pageLabelRepository;

    @GetMapping("/")
    public String home(Model model, Pageable pageable) {
        // Releases
        Page<Release> releasePage = pageReleaseRepository.findAll(pageable);
        Pager releasePager = new Pager(releasePage.getTotalPages(),releasePage.getNumber(),BUTTONS_TO_SHOW);
        // Labels
        Page<Label> labelPage = pageLabelRepository.findAll(pageable);
        Pager labelPager = new Pager(labelPage.getTotalPages(), labelPage.getNumber(), BUTTONS_TO_SHOW);

        // Albums
        Page<Album> albumPage = pageAlbumRepository.findAll(pageable);
        Pager albumPager = new Pager(albumPage.getTotalPages(),albumPage.getNumber(),BUTTONS_TO_SHOW);

        model.addAttribute("releases", releasePage);
        model.addAttribute("albums", albumPage);
        model.addAttribute("labels", labelPage);

        model.addAttribute("releasePager", releasePager);
        model.addAttribute("albumPager", albumPager);
        model.addAttribute("labelPager", labelPager);

        model.addAttribute("pageSizes", PAGE_SIZES);
        return "index";
    }

}