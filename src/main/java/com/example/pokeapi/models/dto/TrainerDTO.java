package com.example.pokeapi.models.dto;

import java.util.List;

import com.example.pokeapi.models.entity.Pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TrainerDTO {
    private String name;
    private Integer xp;
    private List<Pokemon> pokemons;
}
