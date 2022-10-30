package com.example.pokeapi.models.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pokemons")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Float weight;
    private Float height;

    @OneToMany
    @JoinColumn(name = "type_id")
    private List<Type> types;

    @OneToMany
    @JoinColumn(name = "skill_id")
    private List<Skill> skills;

    @OneToMany
    @JoinColumn(name = "weakness_id")
    private List<Weakness> weaknesses;
    
}
