package br.com.myrecipemanager.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myrecipemanager.models.Category;
import br.com.myrecipemanager.models.PrepareType;
import br.com.myrecipemanager.models.Recipe;
import br.com.myrecipemanager.models.Type;
import br.com.myrecipemanager.repositories.CategoryRepository;
import br.com.myrecipemanager.repositories.PrepareTypeRepository;
import br.com.myrecipemanager.repositories.RecipeRepository;
import br.com.myrecipemanager.repositories.TypeRepository;

@Service
public class DBService {
	
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private PrepareTypeRepository prepareTypeRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private RecipeRepository recipeRepository;
	
	public void instantiateTestDataBase() throws ParseException {
		
		Type typeS = new Type(null, "Salgada");
		Type typeD = new Type(null, "Doce");
		typeRepository.saveAll(Arrays.asList(typeS, typeD));
		
		PrepareType prep1 = new PrepareType(null, "Fogão");
		PrepareType prep2 = new PrepareType(null, "Forno");
		PrepareType prep3 = new PrepareType(null, "Fogão e Forno");
		PrepareType prep4 = new PrepareType(null, "Geladeira");
		PrepareType prep5 = new PrepareType(null, "Freezer");
		PrepareType prep6 = new PrepareType(null, "Outro");
		prepareTypeRepository.saveAll(Arrays.asList(prep1, prep2, prep3, prep4, prep5, prep6));
		
		Category cat1 = new Category(null, "Bebidas");
		Category cat2 = new Category(null, "Doces e Sobremesas");
		Category cat3 = new Category(null, "Pães, Bolos, Tortas e Lanches diversos");
		Category cat4 = new Category(null, "Acompanhamentos, Saladas e Molhos");
		Category cat5 = new Category(null, "Carnes, Aves, Peixes, Etc");
		Category cat6 = new Category(null, "Pratos únicos ou Principal");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		
		String ingredientes = "1k de farinha de trigo, 1 litro de leite, 3 ovos, fermento";
		
		Recipe recipe = new Recipe(null, "Pãozinho", false, 
				"buscar na Padaria", "10 minutos",ingredientes, "", 
				cat3, typeS, prep1, true);
		
		Recipe recipe2 = new Recipe(null, "Pão", false, 
				"buscar na Padaria", "20 minutos",ingredientes, "", 
				cat5, typeS, prep2, false);
		
		Recipe recipe3 = new Recipe(null, "Bolo", false, 
				"buscar na Padaria", "30 minutos",ingredientes, "", 
				cat4, typeD, prep3, false);
		
		Recipe recipe4 = new Recipe(null, "Pizza", false, 
				"buscar na Padaria", "10 minutos",ingredientes, "", 
				cat6, typeS, prep5, true);
		
		Recipe recipe5 = new Recipe(null, "Torta", true, 
				"buscar na Padaria", "10 minutos",ingredientes, "", 
				cat2, typeD, prep6, true);
		
		recipeRepository.saveAll(Arrays.asList(recipe, recipe2, recipe3, recipe4, recipe5));

		
	}

}
