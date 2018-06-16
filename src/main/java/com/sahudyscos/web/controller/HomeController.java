package com.sahudyscos.web.controller;

import com.querydsl.core.types.Predicate;
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
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class HomeController {
    private static final int BUTTONS_TO_SHOW = 6;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 20, 30};

    @Autowired
    ReleaseRepository releaseRepository;

    @GetMapping("/")
    @Transactional(readOnly = true)
    public String home(Model model, Pageable pageable, @QuerydslPredicate(root = Release.class) Predicate predicate,
                       @RequestHeader(name = "Update-Table", defaultValue = "false") Boolean update) {
        Page<Release> releasePage = releaseRepository.findAll(pageable);
        Pager releasePager = new Pager(releasePage.getTotalPages(),releasePage.getNumber(),BUTTONS_TO_SHOW);

        model.addAttribute("releasePager", releasePager);
        model.addAttribute("pageSizes", PAGE_SIZES);
        model.addAttribute("releases", releaseRepository.findAll(predicate, pageable));

        return update ? "index :: searchBody" : "index";
    }

}