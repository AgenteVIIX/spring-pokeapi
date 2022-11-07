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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Float weight;
    private Float height;
    private String hp;
    private String sp_attack;
    private String sp_defense;
    private String attack;
    private String defense;
    private String speed;

    @ManyToMany
    @JoinTable(name = "pokemontype", joinColumns = @JoinColumn(name = "pokemon_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
    private List<Type> types;

    @ManyToMany
    @JoinTable(name = "pokemonskill", joinColumns = @JoinColumn(name = "pokemon_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;

    @ManyToMany
    @JoinTable(name = "pokemonweakness", joinColumns = @JoinColumn(name = "pokemon_id"), inverseJoinColumns = @JoinColumn(name = "weakness_id"))
    private List<Weakness> weaknesses;
    
}
