package com.example.pokeapi.controllers;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokeapi.models.dto.TrainerDTO;
import com.example.pokeapi.models.entity.Trainer;
import com.example.pokeapi.models.repository.TrainerRepository;


@RestController
@RequestMapping("trainers")
public class TrainerController {
    
    @Autowired
    TrainerRepository trainerRepository;

    @GetMapping
    public ResponseEntity<Object> show() {
        return ResponseEntity.status(HttpStatus.OK).body(trainerRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody TrainerDTO trainerDTO) {
        Trainer trainer = new Trainer();
        BeanUtils.copyProperties(trainerDTO, trainer);

        return ResponseEntity.status(HttpStatus.OK).body(trainerRepository.save(trainer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody TrainerDTO trainerDTO) {
        Optional<Trainer> trainerExist = trainerRepository.findById(id);

        if(!trainerExist.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Treinador(a) não encontrado(a)");
        }

        Trainer trainer = trainerExist.get();
        BeanUtils.copyProperties(trainerDTO, trainer);
        return ResponseEntity.status(HttpStatus.OK).body(trainerRepository.save(trainer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        Optional<Trainer> trainerExist = trainerRepository.findById(id);

        if(!trainerExist.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Treinador não encontrado");
        }

        Trainer trainer = trainerExist.get();
        trainerRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Treinador " + trainer.getName() + " deletada com sucesso");
    }
}
