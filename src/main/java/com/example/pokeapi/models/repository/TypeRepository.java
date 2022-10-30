package com.example.pokeapi.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pokeapi.models.entity.Type;

public interface TypeRepository extends CrudRepository<Type, Integer>{
    
}
