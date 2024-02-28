package com.gfa.orientationexampleexam.models.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AliasDTO {
    private Integer id;
    private String url;
    private String alias;
    private Integer hitCount;

    public AliasDTO(Integer id, String url, String alias, Integer hitCount) {
        this.id = id;
        this.url = url;
        this.alias = alias;
        this.hitCount = hitCount;
    }
}
