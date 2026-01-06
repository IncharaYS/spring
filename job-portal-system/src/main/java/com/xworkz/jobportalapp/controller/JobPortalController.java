package com.xworkz.jobportalapp.controller;

import com.xworkz.jobportalapp.dto.JobSeekerDTO;
import com.xworkz.jobportalapp.dto.SearchDTO;
import com.xworkz.jobportalapp.service.JobPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class JobPortalController {

    @Autowired
    private JobPortalService service;

    @PostMapping("/register")
    public String register(JobSeekerDTO dto, Model model) {

        boolean saved = service.validateAndSave(dto);
        if (saved) {
            model.addAttribute("successMsg", "Registration successful");
        }
        return "Response";
    }

    @GetMapping("/search")
    public String search(SearchDTO dto, Model model) {

        Optional<JobSeekerDTO> result = service.validateAndSearch(dto);
        if (result.isPresent()) {
            model.addAttribute("jobSeeker", result.get());
        } else {
            model.addAttribute("error", "User not found");
        }
        return "Search";
    }

    @PostMapping("/update")
    public String update(JobSeekerDTO dto, Model model) {

        JobSeekerDTO updated = service.update(dto);
        if (updated != null) {
            model.addAttribute("jobSeeker", updated);
            model.addAttribute("successMsg", "Updated successfully");
        }
        return "Search";
    }

    @GetMapping("/delete")
    public String delete(SearchDTO dto, Model model) {

        service.deleteByEmail(dto.getEmail());
        model.addAttribute("successMsg", "Deleted successfully");
        return "Search";
    }
}
