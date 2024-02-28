package com.gfa.orientationexampleexam.controllers;

import com.gfa.orientationexampleexam.models.Alias;
import com.gfa.orientationexampleexam.models.Link;
import com.gfa.orientationexampleexam.services.AliasService;
import com.gfa.orientationexampleexam.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/save-link")
    public String saveLink(@RequestParam String url, @RequestParam String alias){
        Link link = new Link(url);
        Alias alias1 = new Alias(alias);
        alias1.setLink(link);
        linkService.saveLink(link);
        aliasService.saveAlias(alias1);
        return "redirect:/";
    }
}
