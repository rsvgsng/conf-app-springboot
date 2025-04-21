package com.ghising.crud.controllers;

import com.ghising.crud.dto.ConfessionDTO;
import com.ghising.crud.services.ConfessionService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("confession")
public class ConfessionController {

    private final ConfessionService confessionService;

    @GetMapping("/all")
    public String confessionPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        model.addAttribute("confessions", confessionService.getAllConfessions());
        model.addAttribute("username", username);
        return "confessions/allConfessions";
    }

    @GetMapping("{id}")
    public String confessionDetailsPage(@PathVariable UUID id, Model model) {
        ConfessionDTO confession = confessionService.getConfessionById(id);
        model.addAttribute("confession", confession);
        return "confessions/confessionDetails";
    }

    @GetMapping("/create")
    public String createConfessionPage(Model model) {
        model.addAttribute("confession", new ConfessionDTO());
        return "confessions/createConfession";
    }

    @PostMapping("/createconfession")
    public String createConfession(ConfessionDTO confessionDTO) {
        confessionService.createConfession(confessionDTO);
        return "redirect:/confession/all";
    }
    
    @GetMapping("/my-confessions")
    public String myConfessions(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        model.addAttribute("confessions", confessionService.getConfessionsByUser(username));
        return "confessions/myConfessions";
    }
}