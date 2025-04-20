package com.ghising.crud.controllers;


import com.ghising.crud.dto.ConfessionDTO;
import com.ghising.crud.services.ConfessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("confession")
public class ConfessionController {

    private  final ConfessionService confessionService;

    @GetMapping("/all")
    public String confessionPage(Model model) {
        model.addAttribute("confessions", confessionService.getAllConfessions());
        System.out.println(confessionService.getAllConfessions());
        return "confessions/allConfessions";
    }

    @GetMapping("{id}")
    public String confessionDetailsPage(@PathVariable UUID id, Model model) {
        ConfessionDTO confession = confessionService.getConfessionById(id);
        model.addAttribute("confession", confession);
        return "confessions/confessionDetails";
    }

}
