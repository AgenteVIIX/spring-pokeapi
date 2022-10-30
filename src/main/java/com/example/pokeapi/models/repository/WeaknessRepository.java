package com.example.pokeapi.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pokeapi.models.entity.Weakness;

public interface WeaknessRepository extends CrudRepository<Weakness, Integer>{
    
}
