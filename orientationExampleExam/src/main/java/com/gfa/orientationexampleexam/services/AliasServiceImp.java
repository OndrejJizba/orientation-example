package com.gfa.orientationexampleexam.services;

import com.gfa.orientationexampleexam.models.Alias;
import com.gfa.orientationexampleexam.repositories.AliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

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
}
