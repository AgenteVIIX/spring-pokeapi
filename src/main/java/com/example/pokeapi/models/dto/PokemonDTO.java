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
    private List<Type> types;
    private List<Skill> skills;
    private List<Weakness> weaknesses;
}
