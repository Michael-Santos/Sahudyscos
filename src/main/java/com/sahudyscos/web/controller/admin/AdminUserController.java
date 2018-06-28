package com.sahudyscos.web.controller.admin;

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
public class AdminUserController {
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 20, 30};
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
	private UserService userService;

    @GetMapping("/admin/user")
    public String user(Model model, @QuerydslPredicate(root = User.class) Predicate predicate,
                       Pageable pageable, @RequestParam MultiValueMap<String, String> parameters, 
                       @RequestHeader(name = "Update-Table", defaultValue = "false") Boolean update) {
        model.addAttribute("users", userRepository.findAll(predicate, pageable));
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("formContent", new userFormPOJO(new User(), new ArrayList<String>()));
        return update ? "admin/user :: searchBody" : "admin/user";
    }

    @PostMapping(value = "/admin/user", consumes="application/json")
    @ResponseBody
    public Optional<User> view (@RequestBody String json) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<User> currentUser;
        userRequest request;

        try {
            request = mapper.readValue(json, userRequest.class);
            currentUser = userRepository.findById(request.getId());
            return currentUser;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
        return null;
    }

    /*@GetMapping(value = "/admin/user/role")
    @ResponseBody
    @JsonIgnoreProperties({"description", "genre", "altGenre", "activityStart", "albums", "labelsContracted"})
	List<Role> getArtists(@RequestParam String name) {
		return roleRepository.findByNameStartsWith(name);
    }*/
    
    @PostMapping(value = "/admin/user/save")
    public ModelAndView create(@ModelAttribute userFormPOJO formContent, BindingResult result) {
		logger.info("Save user!");
        List<Role> roles = roleRepository.findAllByRole(formContent.getRoles());
        userService.saveUserAndRoles(formContent.getUser(), roles);
        return new ModelAndView("redirect:/admin/user");
    }

    @PostMapping(value = "/admin/user/delete")
    public ModelAndView delete(@ModelAttribute userFormPOJO formContent, BindingResult result) {
        userRepository.delete(formContent.getUser());
        return new ModelAndView("redirect:/admin/user");
    }
}

class userRequest {
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

class userFormPOJO {
    private User user;
    private List<String> roles;

    userFormPOJO () { }

    userFormPOJO(User user, List<String> roles) {
        this.user = user;
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
