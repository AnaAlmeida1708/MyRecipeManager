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
	
		
		Recipe recipe = new Recipe(null, "Pãozinho", "sim", 
				"buscar na Padaria", "10 minutos", "", 
				cat3, typeS, prep6, true);
		
		recipeRepository.saveAll(Arrays.asList(recipe));
		
		DetailsRecipeIngredients details = new DetailsRecipeIngredients("2", recipe, ing1);
		DetailsRecipeIngredients details2 = new DetailsRecipeIngredients("2 xic", recipe, ing6);
		DetailsRecipeIngredients details3 = new DetailsRecipeIngredients("1", recipe, ing4);
		
		recipe.getDetailsRecipeIngredients().addAll(Arrays.asList(details, details2, details3));
		
		ing1.getDetailsRecipeIngredients().addAll(Arrays.asList(details));
		ing6.getDetailsRecipeIngredients().addAll(Arrays.asList(details2));
		ing4.getDetailsRecipeIngredients().addAll(Arrays.asList(details3));
		
		detailsRepository.saveAll(Arrays.asList(details, details2, details3));

		
	}

}
