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

import com.example.pokeapi.models.dto.PokemonDTO;
import com.example.pokeapi.models.entity.Pokemon;
import com.example.pokeapi.models.repository.PokemonRepository;



/**
 * PokemonController
 */

 @RestController
 @RequestMapping("pokemons")
public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;

    @GetMapping
    public ResponseEntity<Object> showAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> showById(@PathVariable Integer id) {
        
        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody PokemonDTO pokemonDTO) {
        Pokemon pokemon = new Pokemon();
        BeanUtils.copyProperties(pokemonDTO, pokemon);

        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.save(pokemon));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody PokemonDTO pokemonDTO) {
        Optional<Pokemon> pokemonExist = pokemonRepository.findById(id);

        if(!pokemonExist.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon não encontrado");
        }

        Pokemon pokemon = pokemonExist.get();
        BeanUtils.copyProperties(pokemonDTO, pokemon);
        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.save(pokemon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        Optional<Pokemon> pokemonExist = pokemonRepository.findById(id);

        if(!pokemonExist.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon não encontrado");
        }

        Pokemon pokemon = pokemonExist.get();
        pokemonRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Pokemon " + pokemon.getName() + " deletado com sucesso");
    }

    
}