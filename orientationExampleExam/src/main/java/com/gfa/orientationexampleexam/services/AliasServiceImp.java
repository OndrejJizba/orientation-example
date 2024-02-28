package com.gfa.orientationexampleexam.services;

import com.gfa.orientationexampleexam.models.Alias;
import com.gfa.orientationexampleexam.repositories.AliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
