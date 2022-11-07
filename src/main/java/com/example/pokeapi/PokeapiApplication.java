package com.example.pokeapi;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pokeapi.models.dto.PokemonDTO;
import com.example.pokeapi.models.dto.SkillDTO;
import com.example.pokeapi.models.dto.TrainerDTO;
import com.example.pokeapi.models.dto.TypeDTO;
import com.example.pokeapi.models.dto.WeaknessDTO;
import com.example.pokeapi.models.entity.Pokemon;
import com.example.pokeapi.models.entity.Skill;
import com.example.pokeapi.models.entity.Type;
import com.example.pokeapi.models.entity.Weakness;

@SpringBootApplication
public class PokeapiApplication {
	public static void main(String[] args) throws IOException, URISyntaxException {
		//PokeapiApplication main = new PokeapiApplication();
		SpringApplication.run(PokeapiApplication.class, args);
		
		Scanner sc= new Scanner(System.in);
		int escolha; 
		
		while(true) {

			PokeapiApplication.drawMenu();
			escolha = Integer.parseInt(sc.nextLine());
			switch(escolha) {

			//CRUD POKEMON
			case 1:
				PokemonDTO pokemonDTO = PokeapiApplication.insertValeusPokemon();

				try {
					Utils.sendJSONRequest("http://localhost:8080/pokemons", "POST", pokemonDTO);
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
					
			case 2:
				try {
					System.out.println(Utils.sendJSONRequest("http://localhost:8080/pokemons", "GET"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
				

			case 3:
				System.out.print("\nInforme o ID do Pokemon: ");
				int idPokemonUpdate = Integer.parseInt(sc.nextLine());
				
				System.out.print("\nInforme os novos valores");
				PokemonDTO pokemonDTO2 = insertValeusPokemon();
				
				try {
					Utils.sendJSONRequest("http://localhost:8080/pokemons/"+idPokemonUpdate, "PUT", pokemonDTO2);
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
				
			
			case 4:
				System.out.print("\nInforme o ID do Pokemon: ");
				int idPokemonDelete = Integer.parseInt(sc.nextLine());
				
				try {
					Utils.sendJSONRequest("http://localhost:8080/pokemons/"+idPokemonDelete, "DELETE");
					System.out.println("Deletado com sucesso!");
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
				

			//CRUD TIPO
			case 5:
				System.out.print("\nInforme o nome do Tipo: ");
				String typeName = sc.nextLine();
				TypeDTO typeDTO = new TypeDTO();
				typeDTO.setName(typeName);
				Utils.sendJSONRequest("http://localhost:8080/types", "POST", typeDTO);
				
				break;
				

			case 6:
				try {
					System.out.println(Utils.sendJSONRequest("http://localhost:8080/types", "GET"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
				

			case 7:
				System.out.print("\nInforme o ID do Tipo: ");
				int idTypeUpdate = Integer.parseInt(sc.nextLine());
				TypeDTO typeDto2 = new TypeDTO();

				System.out.print("\nInforme o nome do tipo");
				typeDto2.setName(sc.nextLine());
				
				try {
					Utils.sendJSONRequest("http://localhost:8080/types/"+idTypeUpdate, "PUT", typeDto2);
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
			
				break;
				

			case 8:
				String routeURL = "http://localhost:8080/types";
				System.out.print("\nInforme o ID do Tipo: ");
				int idTypeDelete = Integer.parseInt(sc.nextLine());
				
				try {
					Utils.sendJSONRequest(routeURL+"/"+idTypeDelete, "DELETE");
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
				

			//CRUD SKILL
			case 9:
				System.out.print("\nInforme o nome da Skill: ");
				String skillName = sc.nextLine();

				System.out.print("\nInforme a descrição da Skill: ");
				String skillDesc = sc.nextLine();

				SkillDTO skillDTO = new SkillDTO();
				skillDTO.setName(skillName);
				skillDTO.setDesc(skillDesc);
				Utils.sendJSONRequest("http://localhost:8080/skills", "POST", skillDTO);
				
				break;
				

			case 10:
				try {
					System.out.println(Utils.sendJSONRequest("http://localhost:8080/skills", "GET"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
				

			case 11:
				System.out.print("\nInforme o ID da Skill: ");
				int idSkillUpdate = Integer.parseInt(sc.nextLine());
				SkillDTO skillDto2 = new SkillDTO();

				System.out.print("\nInforme o nome da Skill");
				skillDto2.setName(sc.nextLine());
				
				try {
					Utils.sendJSONRequest("http://localhost:8080/skills/"+idSkillUpdate, "PUT", skillDto2);
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
			
				break;
				

			case 12:
				System.out.print("\nInforme o ID da Skill: ");
				int idSkillDelete = Integer.parseInt(sc.nextLine());
				
				try {
					Utils.sendJSONRequest("http://localhost:8080/skills/"+idSkillDelete, "DELETE");
					System.out.println("Deletado com sucesso!");
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
				

			//CRUD TRAINER
			case 13:
				TrainerDTO trainerDTO = PokeapiApplication.insertValueTrainer();

				Utils.sendJSONRequest("http://localhost:8080/trainers", "POST", trainerDTO);
				
				break;
				

			case 14:
				try {
					System.out.println(Utils.sendJSONRequest("http://localhost:8080/trainers", "GET"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
				

			case 15:
				System.out.print("\nInforme o ID do Treinador: ");
				int idTrainerUpdate = Integer.parseInt(sc.nextLine());
				
				System.out.print("\nInforme os novos valores");
				TrainerDTO trainerDTO2 = PokeapiApplication.insertValueTrainer();
				
				try {
					Utils.sendJSONRequest("http://localhost:8080/trainers/"+idTrainerUpdate, "PUT", trainerDTO2);
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
				

			case 16:
				System.out.print("\nInforme o ID do Treinador: ");
				int idTrainerDelete = Integer.parseInt(sc.nextLine());
				
				try {
					Utils.sendJSONRequest("http://localhost:8080/trainers/"+idTrainerDelete, "DELETE");
					System.out.println("Deletado com sucesso!");
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
				

			//CRUD WEAKNESS
			case 17:
				System.out.print("\nInforme o nome da Fraqueza: ");
				String weaknessName = sc.nextLine();
				WeaknessDTO weaknessDTO = new WeaknessDTO();
				weaknessDTO.setName(weaknessName);
				Utils.sendJSONRequest("http://localhost:8080/weaknesses", "POST", weaknessDTO);
				
				break;

			case 18:
				try {
					System.out.println(Utils.sendJSONRequest("http://localhost:8080/weaknesses", "GET"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
				

			case 19:
				System.out.print("\nInforme o ID da Fraqueza: ");
				int idWeaknessUpdate = Integer.parseInt(sc.nextLine());
				WeaknessDTO weaknessDto2 = new WeaknessDTO();

				System.out.print("\nInforme o nome da Fraqueza");
				weaknessDto2.setName(sc.nextLine());
				
				try {
					Utils.sendJSONRequest("http://localhost:8080/weaknesses/"+idWeaknessUpdate, "PUT", weaknessDto2);
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;
				

			case 20:
				System.out.print("\nInforme o ID da Fraqueza: ");
				int idWeaknessDelete = Integer.parseInt(sc.nextLine());
				
				try {
					Utils.sendJSONRequest("http://localhost:8080/weaknesses/"+idWeaknessDelete, "DELETE");
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				break;

			}
		}

	}

	public static PokemonDTO insertValeusPokemon() {
		PokemonDTO pokemonDTO = new PokemonDTO();	
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("\nInforme o nome do Pokemon: ");
			pokemonDTO.setName(sc.nextLine());

			System.out.println("\nInforme o peso do Pokemon: ");
			pokemonDTO.setWeight(Float.parseFloat(sc.nextLine()));

			System.out.println("\nInforme a altura do Pokemon: ");
			pokemonDTO.setHeight(Float.parseFloat(sc.nextLine()));

			System.out.println("\nInforme o HP: ");
			pokemonDTO.setHp(sc.nextLine());

			System.out.println("\nInforme o Sp. Attack ");
			pokemonDTO.setSp_attack(sc.nextLine());

			System.out.println("\nInforme o Sp. Defense: ");
			pokemonDTO.setSp_defense(sc.nextLine());

			System.out.println("\nInforme o Attack: ");
			pokemonDTO.setAttack(sc.nextLine());

			System.out.println("\nInforme o Defense: ");
			pokemonDTO.setDefense(sc.nextLine());

			System.out.println("\nInforme o Speed: ");
			pokemonDTO.setSpeed(sc.nextLine());

			System.out.println("\nInforme os tipos do pokemon (separado por vírgula)");
			String[] typesSplit = sc.nextLine().split(",");
			List<Type> types = Arrays.stream(typesSplit).map(str -> new Type(Integer.parseInt(str.trim()), null)).toList();
			pokemonDTO.setTypes(types);

			System.out.println("\nInforme as fraquezas do pokemon (separado por vírgula)");
			String[] weaknessSplit = sc.nextLine().split(",");
			List<Weakness> weaknesses = Arrays.stream(weaknessSplit).map(str -> new Weakness(Integer.parseInt(str.trim()), null)).toList();
			pokemonDTO.setWeaknesses(weaknesses);
			
			System.out.println("\nInforme a skill do pokemon");
			String[] skillSplit = sc.nextLine().split(",");
			List<Skill> skills = Arrays.stream(skillSplit).map(str -> new Skill(Integer.parseInt(str.trim()), null, null)).toList();
			pokemonDTO.setSkills(skills);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(pokemonDTO);
		return pokemonDTO;
	}

	public static TrainerDTO insertValueTrainer() { 
		TrainerDTO trainerDTO = new TrainerDTO();
		Scanner sc = new Scanner(System.in);

		System.out.println("\nInforme o nome do Treinador: ");
		trainerDTO.setName(sc.nextLine());

		System.out.println("\nInforme o XP do Trainador");
		trainerDTO.setXp(sc.nextInt());
		sc.nextLine();
		System.out.println("\nInforme os Pokemon's do Treinador (separado por vírgula)");
		String[] pokemonSplit = sc.nextLine().split(",");
		List<Pokemon> pokemonList = Arrays.stream(pokemonSplit).map(str -> new Pokemon(Integer.parseInt(str.trim()), null, null, null, null, null, null, null, null, null, null, null, null)).toList();
		trainerDTO.setPokemons(pokemonList);

		return trainerDTO;
	}

	public static void drawMenu() {
		System.out.println(" ==== POKEAPI ====");
		System.out.println("[1] - Criar Pokemon");
		System.out.println("[2] - Listar Pokemons");
		System.out.println("[3] - Editar Pokemon");
		System.out.println("[4] - Deletar Pokemon");

		System.out.println("[5] - Criar Tipo de Pokemon");
		System.out.println("[6] - Listar Tipos de Pokemon");
		System.out.println("[7] - Editar Tipo de Pokemon");
		System.out.println("[8] - Deletar Tipo de Pokemon");

		System.out.println("[9] - Criar Skill");
		System.out.println("[10] - Listar Skills");
		System.out.println("[11] - Editar Skill");
		System.out.println("[12] - Deletar Skill");

		System.out.println("[13] - Criar Treinador");
		System.out.println("[14] - Listar Treinadores");
		System.out.println("[15] - Editar Treinador");
		System.out.println("[16] - Deletar Treinador");

		System.out.println("[17] - Criar Fraqueza");
		System.out.println("[18] - Listar Fraquezas");
		System.out.println("[19] - Editar Fraqueza");
		System.out.println("[20] - Deletar Fraqueza");
		System.out.println("==================");
	}

}
