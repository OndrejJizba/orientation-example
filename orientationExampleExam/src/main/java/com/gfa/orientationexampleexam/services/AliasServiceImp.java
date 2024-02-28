package com.gfa.orientationexampleexam.services;

import com.gfa.orientationexampleexam.models.Alias;
import com.gfa.orientationexampleexam.models.DTOs.AliasDTO;
import com.gfa.orientationexampleexam.repositories.AliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class AliasServiceImp implements AliasService{

    private final AliasRepository aliasRepository;

    @Autowired
    public AliasServiceImp(AliasRepository aliasRepository) {
        this.aliasRepository = aliasRepository;
    }

    @Override
    public List<Alias> getAllAliases() {
        return aliasRepository.findAll();
    }

    @Override
    public Alias saveAlias(Alias alias) {
        alias.setSecretCode(generateSecretCode());
        return aliasRepository.save(alias);
    }

    @Override
    public String generateSecretCode() {
        Random random = new Random();
        Integer randomValue = random.nextInt(9999);
        return String.format("%04d", randomValue);
    }

    @Override
    public boolean aliasAvailable(String alias) {
        List<Alias> reducedList = aliasRepository.findAll().stream().filter(a -> Objects.equals(a.getAlias(), alias)).toList();
        return reducedList.size() == 0;
    }

    @Override
    public boolean updateAlias(String url) {
        List<Alias> reducedList = aliasRepository.findAll().stream().filter(a -> Objects.equals(a.getLink().getUrl(), url)).toList();
        return reducedList.size() == 1;
    }

    @Override
    public Alias findByAlias(String alias) {
        return aliasRepository.findByAlias(alias);
    }

    @Override
    public List<AliasDTO> getAllAliasDTO() {
        List<AliasDTO> aliasDTOList = new ArrayList<>();
        List<Alias> aliasList = aliasRepository.findAll();
        for (Alias alias : aliasList){
            AliasDTO aliasDTO = new AliasDTO();
            aliasDTO.setId(alias.getId());
            aliasDTO.setUrl(alias.getLink().getUrl());
            aliasDTO.setAlias(alias.getAlias());
            aliasDTO.setHitCount(alias.getHitCount());
            aliasDTOList.add(aliasDTO);
        }
        return aliasDTOList;
    }

    @Override
    public Alias deleteById(Integer id) throws Exception {
        Alias alias = aliasRepository.findById(id).orElseThrow(() -> new Exception("Alias not found."));
        aliasRepository.delete(alias);
        return alias;
    }

    @Override
    public Alias findBySecretCode(String secretCode) {
        return aliasRepository.findBySecretCode(secretCode);
    }

    @Override
    public Alias findById(Integer id) throws Exception {
        return aliasRepository.findById(id).orElseThrow(() -> new Exception("Alias not found"));
    }

    @Override
    public boolean existsById(Integer id) {
        return aliasRepository.existsById(id);
    }
}
