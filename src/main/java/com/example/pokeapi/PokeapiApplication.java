package com.example.pokeapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokeapiApplication {
	public static void main(String[] args) {
		//PokeapiApplication main = new PokeapiApplication();
		SpringApplication.run(PokeapiApplication.class, args);
		
		/*Scanner sc= new Scanner(System.in);
		System.out.println(" ==== POKEAPI ====");
		System.out.println("[1] - Pokemons");
		System.out.println("[2] - Treinadores");
		System.out.println("[3] - Tipos de Pokemon");
		System.out.println("[4] - Habilidades de Pokemon");
		System.out.println("==================");
		int escolha = sc.nextInt();
		sc.nextLine();
		switch(escolha) {
			case 1:
				System.out.println("Informe o nome do Pokemon: ");
				String pokeName = sc.nextLine();
				System.out.println("Informe o tipo do Pokemon: ");
				int idType = sc.nextInt();
				sc.nextLine();
				System.out.println("Informe a altura do Pokemon: ");
				float height = sc.nextFloat();
				sc.nextLine();
				System.out.println("Informe o peso do Pokemon: ");
				float wegith = sc.nextFloat();
				sc.nextLine();
				System.out.println("Informe as fraquezas do Pokemon: ");
				int weaknessOne = sc.nextInt();
				sc.nextLine();
				List<Integer> weaknesses = new ArrayList<>();
				weaknesses.add(weaknessOne);
				System.out.println("Adicione mais uma fraqueza ou digite 'N': ");
			case 2:


			case 3:
				System.out.println("Informe o nome do Tipo: ");
				String name = sc.nextLine();
				TypeDTO typeDto = new TypeDTO();
				typeDto.setName(name);
				TypeController tc = new TypeController();
				TypeRepository tr = Reposito
				tc.typeRepository = typeRepository;
				tc.save(typeDto);

		}*/

	}

}
