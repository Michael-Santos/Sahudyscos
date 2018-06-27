package com.sahudyscos.web.controller.admin.benchmark;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.Predicate;
import com.sahudyscos.web.controller.util.Pager;
import com.sahudyscos.web.entity.access.Role;
import com.sahudyscos.web.entity.access.User;
import com.sahudyscos.web.entity.projection.Query1Result;
import com.sahudyscos.web.repository.AlbumRepository;
import com.sahudyscos.web.repository.ReleaseRepository;
import com.sahudyscos.web.repository.access.RoleRepository;
import com.sahudyscos.web.repository.access.UserRepository;
import com.sahudyscos.web.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminBenchmarkController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReleaseRepository releaseRepository;

    @RequestMapping("/admin/benchmark/query1")
    public String query1(Model model, Pageable pageable, 
                        @RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "price", required = false) Float price,
                        @RequestHeader(name = "Update-Table", defaultValue = "false") Boolean update) {
        if (name != null && price != null) {
            model.addAttribute("results", releaseRepository.getQuery1(name, price, pageable));
        }
        return update ? "admin/benchmark/query1 :: searchBody" : "admin/benchmark/query1";
    }

    @RequestMapping("/admin/benchmark/query2")
    public String query2(Model model, Pageable pageable, 
                         @RequestParam(value = "country", required = false) String country,
                         @RequestParam(value = "rating", required = false) Float rating,
                         @RequestHeader(name = "Update-Table", defaultValue = "false") Boolean update) {
        if (country != null && rating != null) {
            model.addAttribute("results", releaseRepository.getQuery2(country, rating, pageable));
        }
        return update ? "admin/benchmark/query2 :: searchBody" : "admin/benchmark/query2";
    }
}