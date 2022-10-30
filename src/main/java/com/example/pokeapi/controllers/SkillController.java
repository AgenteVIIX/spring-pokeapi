package com.example.pokeapi.controllers;

import java.util.Optional;

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
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody SkillDTO skillDTO) {
        Optional<Skill> skillExist = skillRepository.findById(id);

        if(!skillExist.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill não encontrada");
        }

        Skill skill = skillExist.get();
        BeanUtils.copyProperties(skillDTO, skill);
        return ResponseEntity.status(HttpStatus.OK).body(skillRepository.save(skill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        Optional<Skill> skillExist = skillRepository.findById(id);

        if(!skillExist.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill não encontrada");
        }

        Skill skill = skillExist.get();
        skillRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Skill " + skill.getName() + " deletada com sucesso");
    }
}
