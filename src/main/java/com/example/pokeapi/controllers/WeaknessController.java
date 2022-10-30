package com.example.pokeapi.controllers;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pokeapi.models.dto.WeaknessDTO;
import com.example.pokeapi.models.entity.Weakness;
import com.example.pokeapi.models.repository.WeaknessRepository;


@RestController
@RequestMapping("weaknesses")
public class WeaknessController {

    @Autowired
    WeaknessRepository weaknessRepository;

    @GetMapping
    public ResponseEntity<Object> show() {
        return ResponseEntity.status(HttpStatus.OK).body(weaknessRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody WeaknessDTO weaknessDTO) {
        Weakness weakness = new Weakness();
        BeanUtils.copyProperties(weaknessDTO, weakness);

        return ResponseEntity.status(HttpStatus.OK).body(weaknessRepository.save(weakness));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody WeaknessDTO weaknessDTO) {
        Optional<Weakness> weaknessExist = weaknessRepository.findById(id);

        if(!weaknessExist.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fraqueza não encontrada");
        }

        Weakness weakness = weaknessExist.get();
        BeanUtils.copyProperties(weaknessDTO, weakness);

        return ResponseEntity.status(HttpStatus.OK).body(weaknessRepository.save(weakness));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        Optional<Weakness> weaknessExist = weaknessRepository.findById(id);

        if(!weaknessExist.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fraqueza não encontrada");
        }

        Weakness weakness = weaknessExist.get();
        weaknessRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Fraqueza " + weakness.getName() + " Deletada com sucesso");
    }
}
