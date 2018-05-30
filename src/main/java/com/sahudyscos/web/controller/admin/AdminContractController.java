package com.sahudyscos.web.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahudyscos.web.controller.util.Pager;
import com.sahudyscos.web.entity.Artist;
import com.sahudyscos.web.entity.Contract;
import com.sahudyscos.web.entity.Label;
import com.sahudyscos.web.entity.key.ContractId;
import com.sahudyscos.web.repository.ArtistRepository;
import com.sahudyscos.web.repository.ContractRepository;
import com.sahudyscos.web.repository.LabelRepository;
import com.sahudyscos.web.repository.PageContractRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminContractController {
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 20, 30};

    @Autowired
    private PageContractRepository pageContractRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private LabelRepository labelRepository;

    @GetMapping("/admin/contract")
    public String contract(Model model, Pageable pageable) {
        Page<Contract> page = pageContractRepository.findAll(pageable);
        Pager pager = new Pager(page.getTotalPages(),page.getNumber(),BUTTONS_TO_SHOW);
        model.addAttribute("contracts", page);
        model.addAttribute("pageSizes", PAGE_SIZES);
        model.addAttribute("pager", pager);
        model.addAttribute("contract", new Contract());
        return "admin-contract";
    }

    @PostMapping(value = "/admin/contract", consumes="application/json")
    @ResponseBody
    @JsonIgnoreProperties({"releases"})
    public Optional<Contract> view (@RequestBody String json) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Contract> currentcontract;
        contractRequest request;

        try {
            request = mapper.readValue(json, contractRequest.class);
            currentcontract = contractRepository.findById(new ContractId (request.getArtistId(), request.getLabelId()));
            return currentcontract;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
        return null;
    }
    
    @GetMapping(value = "/admin/contract/artist")
    @ResponseBody
    @JsonIgnoreProperties({"description", "genre", "altGenre", "activityStart", "albums", "labelsContracted"})
	List<Artist> getArtists(@RequestParam String name) {
		return artistRepository.findByNameStartsWith(name);
    }

    @GetMapping(value = "/admin/contract/label")
    @ResponseBody
    @JsonIgnoreProperties({"description", "genre", "altGenre", "activityStart", "phone", "altPhone", "artistsContracted", "releases"})
	List<Label> getLabels(@RequestParam String name) {
		return labelRepository.findByNameStartsWith(name);
    }

    @PostMapping("/admin/contract/save")
    public String create(@ModelAttribute Contract contract) {
        contractRepository.save(contract);
        return "admin-contract";
    }

    @PostMapping("/admin/contract/delete")
    public String delete(@ModelAttribute Contract contract) {
        contractRepository.delete(contract);
        return "admin-contract";
    }
}

class contractRequest {
    private String type;
    private Long artistId;
    private Long labelId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setAlbumId(Long artistId) {
        this.artistId = artistId;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

}