package com.gfa.orientationexampleexam.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "aliases")
public class Alias {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String alias;
    private Integer hitCount;
    private String secretCode;
    @ManyToOne
    private Link link;

    public Alias(String alias) {
        this.alias = alias;
        this.hitCount = 0;
    }
}
