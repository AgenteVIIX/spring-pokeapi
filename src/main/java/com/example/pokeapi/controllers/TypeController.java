package com.example.pokeapi.controllers;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pokeapi.models.dto.TypeDTO;
import com.example.pokeapi.models.entity.Type;
import com.example.pokeapi.models.repository.TypeRepository;

@RestController
@RequestMapping("types")
public class TypeController {

    @Autowired
    TypeRepository typeRepository;

    @GetMapping
    public ResponseEntity<Object> show() {
        return ResponseEntity.status(HttpStatus.OK).body(typeRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody TypeDTO typeDTO) {
        Type type = new Type();
        BeanUtils.copyProperties(typeDTO, type);

        return ResponseEntity.status(HttpStatus.OK).body(typeRepository.save(type));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody TypeDTO typeDTO, @PathVariable Integer id) {
        Optional<Type> typeExist = typeRepository.findById(id);

        if(!typeExist.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo não encontrado");
        }

        Type type = typeExist.get();
        BeanUtils.copyProperties(typeDTO, type);

        return ResponseEntity.status(HttpStatus.OK).body(typeRepository.save(type));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {

        Optional<Type> typeExist = typeRepository.findById(id);

        if(!typeExist.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo não encontrado");
        }

        Type type = typeExist.get();
        typeRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Tipo " + type.getName() + " deletado com sucesso");
    }
}
