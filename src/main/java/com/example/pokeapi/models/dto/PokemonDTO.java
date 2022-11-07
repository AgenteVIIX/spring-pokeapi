package com.example.pokeapi.models.dto;

import java.util.List;

import com.example.pokeapi.models.entity.Skill;
import com.example.pokeapi.models.entity.Type;
import com.example.pokeapi.models.entity.Weakness;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PokemonDTO {

    private String name;
    private Float weight;
    private Float height;
    private String hp;
    private String sp_attack;
    private String sp_defense;
    private String attack;
    private String defense;
    private String speed;
    private List<Type> types;
    private List<Skill> skills;
    private List<Weakness> weaknesses;
}
