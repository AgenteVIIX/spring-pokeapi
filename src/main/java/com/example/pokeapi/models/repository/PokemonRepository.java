package com.example.pokeapi.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.pokeapi.models.entity.Pokemon;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer>{
    @Query(value="SELECT * FROM pokemons INNER JOIN pokemontype ON pokemontype.pokemon_id = pokemons.id AND pokemontype.type_id = :typeid",
			nativeQuery=true)
	List<Pokemon> findByTypeId(@Param("typeid") int typeid);
}
