package com.example.pokeapi.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pokeapi.models.entity.Trainer;

public interface TrainerRepository extends CrudRepository<Trainer, Integer>{
    
}
