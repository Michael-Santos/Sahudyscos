package com.sahudyscos.web.controller.admin;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.Predicate;
import com.sahudyscos.web.controller.util.Pager;
import com.sahudyscos.web.entity.Label;
import com.sahudyscos.web.repository.LabelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminLabelController {
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 20, 30};

    @Autowired
    private LabelRepository labelRepository;

    @GetMapping("/admin/label")
    public String artist(Model model, @QuerydslPredicate(root = Label.class) Predicate predicate,
                         Pageable pageable, @RequestParam MultiValueMap<String, String> parameters, 
                         @RequestHeader(name = "Search", defaultValue = "false") Boolean search) {
        model.addAttribute("labels", labelRepository.findAll(predicate, pageable));
        model.addAttribute("label", new Label());
        return search ? "admin-label :: searchBody" : "admin-label";
    }

    @PostMapping(value = "/admin/label", consumes="application/json")
    @ResponseBody
    @JsonIgnoreProperties({"releases"})
    public Optional<Label> view (@RequestBody String json) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Label> currentLabel;
        artistRequest request;

        try {
            request = mapper.readValue(json, artistRequest.class);
            currentLabel = labelRepository.findById(Long.valueOf(request.getId()));
            return currentLabel;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/admin/label/save")
    public String create(@ModelAttribute Label label) {
        labelRepository.save(label);
        return "admin-label";
    }

    @PostMapping("/admin/label/delete")
    public String delete(@ModelAttribute Label label) {
        labelRepository.delete(label);
        return "admin-label";
    }
}

class labelRequest {
    private String type;
    private Integer id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}