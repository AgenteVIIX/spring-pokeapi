package com.example.pokeapi.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pokeapi.models.dto.SkillDTO;
import com.example.pokeapi.models.entity.Skill;
import com.example.pokeapi.models.repository.SkillRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("skills")
public class SkillController {

    @Autowired
    SkillRepository skillRepository;

    @GetMapping
    public ResponseEntity<Object> show() {
        return ResponseEntity.status(HttpStatus.OK).body(skillRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody SkillDTO skillDTO) {
        Skill skill = new Skill();
        BeanUtils.copyProperties(skillDTO, skill);

        return ResponseEntity.status(HttpStatus.OK).body(skillRepository.save(skill));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update() {
        return ResponseEntity.status(HttpStatus.OK).body("Acessando rota PUT");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete() {
        return ResponseEntity.status(HttpStatus.OK).body("Acessando rota DELTE");
    }
}
