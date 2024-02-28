package com.gfa.orientationexampleexam.services;

import com.gfa.orientationexampleexam.models.Alias;

import java.util.List;

public interface AliasService {
    List<Alias> getAllAliases();
    Alias saveAlias(Alias alias);
}
