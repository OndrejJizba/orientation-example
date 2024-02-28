package com.gfa.orientationexampleexam.controllers;

import com.gfa.orientationexampleexam.models.DTOs.AliasDTO;
import com.gfa.orientationexampleexam.services.AliasService;
import com.gfa.orientationexampleexam.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AliasController {

    private final AliasService aliasService;
    private final LinkService linkService;

    @Autowired
    public AliasController(AliasService aliasService, LinkService linkService) {
        this.aliasService = aliasService;
        this.linkService = linkService;
    }

    @GetMapping("/api/aliases")
    public ResponseEntity<List<AliasDTO>> getAllAliases(){
        return ResponseEntity.status(200).body(aliasService.getAllAliasDTO());
    }
}
