package com.gfa.orientationexampleexam.repositories;

import com.gfa.orientationexampleexam.models.Alias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AliasRepository extends JpaRepository<Alias, Integer> {
    Alias findByAlias(String alias);
    Alias findBySecretCode(String secretCode);
    boolean existsById(Integer id);
}
