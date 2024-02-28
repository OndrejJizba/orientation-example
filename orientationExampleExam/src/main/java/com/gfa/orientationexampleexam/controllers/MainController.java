package com.gfa.orientationexampleexam.controllers;

import com.gfa.orientationexampleexam.services.AliasService;
import com.gfa.orientationexampleexam.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final AliasService aliasService;
    private final LinkService linkService;

    @Autowired
    public MainController(AliasService aliasService, LinkService linkService) {
        this.aliasService = aliasService;
        this.linkService = linkService;
    }

    @GetMapping("")
    public String mainPage(Model model){
        model.addAttribute("aliases", aliasService.getAllAliases());
        model.addAttribute("links", linkService.getAllLinks());
        return "mainpage";
    }
}
