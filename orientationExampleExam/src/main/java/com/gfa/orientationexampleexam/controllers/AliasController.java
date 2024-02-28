package com.gfa.orientationexampleexam.controllers;

import com.gfa.orientationexampleexam.models.Alias;
import com.gfa.orientationexampleexam.models.DTOs.AliasDTO;
import com.gfa.orientationexampleexam.services.AliasService;
import com.gfa.orientationexampleexam.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @DeleteMapping("/api/aliases/{id}")
    public ResponseEntity<?> deleteAlias(@PathVariable Integer id, @RequestBody Map<String, String> requestBody) throws Exception {
        String secretCode = requestBody.get("secretCode");
        Map<String, String> error = new HashMap<>();
        if (!aliasService.existsById(id)) {
            error.put("error", "Alias doesn't exist.");
            return ResponseEntity.status(404).body(error);
        }

        Alias alias = aliasService.findById(id);

        if (alias != null && !Objects.equals(secretCode, alias.getSecretCode())) {
            error.put("error", "Secret code is not correct.");
            return ResponseEntity.status(403).body(error);
        } else {
            aliasService.deleteById(id);
            return ResponseEntity.status(204).body("Alias deleted.");
        }
    }
}
