package br.com.myrecipemanager.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myrecipemanager.models.Category;
import br.com.myrecipemanager.models.DetailsRecipeIngredients;
import br.com.myrecipemanager.models.Ingredient;
import br.com.myrecipemanager.models.PrepareType;
import br.com.myrecipemanager.models.Recipe;
import br.com.myrecipemanager.models.Type;
import br.com.myrecipemanager.repositories.CategoryRepository;
import br.com.myrecipemanager.repositories.DetailsRecipeIngredientsRepository;
import br.com.myrecipemanager.repositories.IngredientRepository;
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
	private IngredientRepository ingredientRepository;
	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private DetailsRecipeIngredientsRepository detailsRepository;
	
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
		
		Ingredient ing1 = new Ingredient(null, "ovos");
		Ingredient ing2 = new Ingredient(null, "couve");
		Ingredient ing3 = new Ingredient(null, "tomate cereja");
		Ingredient ing4 = new Ingredient(null, "pimentão verde");
		Ingredient ing5 = new Ingredient(null, "sal");
		Ingredient ing6 = new Ingredient(null, "queijo ralado");
		Ingredient ing7 = new Ingredient(null, "azeite");
		Ingredient ing8 = new Ingredient(null, "manjericão");
		Ingredient ing9 = new Ingredient(null, "pimenta do reino");
		ingredientRepository.saveAll(Arrays.asList(ing1, ing2, ing3, ing4, ing5, ing6,
				ing7, ing8, ing9));
	
		
		Recipe recipe = new Recipe(null, "Pãozinho", true, 
				"buscar na Padaria", "10 minutos", "", 
				cat3, typeS, prep6, true);
		
		Recipe recipe2 = new Recipe(null, "Pão", true, 
				"buscar na Padaria", "20 minutos", "", 
				cat5, typeS, prep6, true);
		
		Recipe recipe3 = new Recipe(null, "Bolo", true, 
				"buscar na Padaria", "30 minutos", "", 
				cat4, typeD, prep6, false);
		
		Recipe recipe4 = new Recipe(null, "Pizza", true, 
				"buscar na Padaria", "10 minutos", "", 
				cat6, typeS, prep6, true);
		
		Recipe recipe5 = new Recipe(null, "Torta", true, 
				"buscar na Padaria", "10 minutos", "", 
				cat2, typeD, prep6, true);
		
		recipeRepository.saveAll(Arrays.asList(recipe, recipe2, recipe3, recipe4, recipe5));
		
		DetailsRecipeIngredients details = new DetailsRecipeIngredients("2", recipe, ing1);
		DetailsRecipeIngredients details2 = new DetailsRecipeIngredients("2 xic", recipe, ing6);
		DetailsRecipeIngredients details3 = new DetailsRecipeIngredients("1", recipe, ing4);
		
		DetailsRecipeIngredients details4 = new DetailsRecipeIngredients("2", recipe2, ing1);
		DetailsRecipeIngredients details5= new DetailsRecipeIngredients("2 xic", recipe2, ing6);
		DetailsRecipeIngredients details6= new DetailsRecipeIngredients("1", recipe2, ing4);
		
		DetailsRecipeIngredients details7= new DetailsRecipeIngredients("2", recipe3, ing1);
		DetailsRecipeIngredients details8 = new DetailsRecipeIngredients("2 xic", recipe3, ing6);
		DetailsRecipeIngredients details9 = new DetailsRecipeIngredients("1", recipe3, ing4);
		
		DetailsRecipeIngredients details10 = new DetailsRecipeIngredients("2", recipe4, ing1);
		DetailsRecipeIngredients details11 = new DetailsRecipeIngredients("2 xic", recipe4, ing6);
		DetailsRecipeIngredients details12 = new DetailsRecipeIngredients("1", recipe4, ing4);

		DetailsRecipeIngredients details13 = new DetailsRecipeIngredients("2", recipe5, ing1);
		DetailsRecipeIngredients details14 = new DetailsRecipeIngredients("2 xic", recipe5, ing6);
		DetailsRecipeIngredients details15 = new DetailsRecipeIngredients("1", recipe5, ing4);
		
		recipe.getDetailsRecipeIngredients().addAll(Arrays.asList(details, details2, details3, details4, details5, details6, details7
				, details8, details9, details10, details11, details12, details13, details14, details15));
		
		ing1.getDetailsRecipeIngredients().addAll(Arrays.asList(details, details4, details7, details10, details13));
		ing6.getDetailsRecipeIngredients().addAll(Arrays.asList(details2, details5, details8, details11, details14));
		ing4.getDetailsRecipeIngredients().addAll(Arrays.asList(details3, details6, details9, details12, details15));
		
		detailsRepository.saveAll(Arrays.asList(details, details2, details3, details4, details5, details6, details7
				, details8, details9, details10, details11, details12, details13, details14, details15));

		
	}

}
