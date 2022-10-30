package com.example.pokeapi.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pokeapi.models.entity.Skill;

public interface SkillRepository extends CrudRepository<Skill, Integer>{
    
}
