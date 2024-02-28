package com.gfa.orientationexampleexam.services;

import com.gfa.orientationexampleexam.models.Alias;
import com.gfa.orientationexampleexam.models.DTOs.AliasDTO;

import java.util.List;

public interface AliasService {
    List<Alias> getAllAliases();
    Alias saveAlias(Alias alias);
    String generateSecretCode();
    boolean aliasAvailable(String alias);
    boolean updateAlias(String url);
    Alias findByAlias(String alias);
    List<AliasDTO> getAllAliasDTO();
    Alias deleteById(Integer id) throws Exception;
    Alias findBySecretCode(String secretCode);
    Alias findById(Integer id) throws Exception;
    boolean existsById(Integer id);
}
