package com.example.pokeapi.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pokeapi.models.entity.Pokemon;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer>{
    
}
