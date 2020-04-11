package br.com.myrecipemanager.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myrecipemanager.models.DetailsRecipeIngredients;
import br.com.myrecipemanager.models.Recipe;
import br.com.myrecipemanager.repositories.DetailsRecipeIngredientsRepository;
import br.com.myrecipemanager.repositories.RecipeRepository;
import br.com.myrecipemanager.services.exceptions.ObjectNotFoundException;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository repo;
	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private DetailsRecipeIngredientsRepository detailsRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TypeService typeService;
	
	@Autowired
	private PrepareTypeService prepareTypeService;

	public Recipe find (Integer id) {
		Optional<Recipe> recipe = repo.findById(id);
		return recipe.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", Tipo: " + Recipe.class.getName()));
	}

	public List<Recipe> findAll() {
		return repo.findAll();
	}
	
	@Transactional
	public Recipe insert(Recipe recipe) {
		recipe.setCode(null);
		recipe.setCategory(categoryService.find(recipe.getCategory().getCode()));
		recipe.setType(typeService.find(recipe.getType().getCode()));
		recipe.setPrepareType(prepareTypeService.find(recipe.getPrepareType().getCode()));
		recipe = repo.save(recipe);
		for(DetailsRecipeIngredients detailsRecipeIngredient : recipe.getDetailsRecipeIngredients()) {
			detailsRecipeIngredient.setQuantity(detailsRecipeIngredient.getQuantity());
			detailsRecipeIngredient.setIngredient(ingredientService.find(detailsRecipeIngredient.getIngredient().getCode()));
			detailsRecipeIngredient.setRecipe(recipe);
		}
		detailsRepository.saveAll(recipe.getDetailsRecipeIngredients());
		System.out.println(recipe);
		return recipe;
		
	}
	

//	@Transactional
//	public Recipe update(Recipe recipe) {
//		Recipe newRecipe = find(recipe.getCode());
//		updateData(newRecipe, recipe);
//		return repo.save(newRecipe);
//	}
//
//	private void updateData(Recipe newRecipe, Recipe recipe) {
//		newRecipe.setName(recipe.getName());
//		newRecipe.setTested(recipe.getTested());
//		newRecipe.setMethodOfPreparation(recipe.getMethodOfPreparation());
//		newRecipe.setPreparationTime(recipe.getPreparationTime());
//		newRecipe.setComments(recipe.getComments());
//		newRecipe.setFavorite(recipe.getFavorite());
//	}
//
//	public Recipe fromDTO (RecipeDTO recipeDto) {
//		return new Recipe(recipeDto.getCode(), recipeDto.getName(), recipeDto.getTested(), recipeDto.getMethodOfPreparation(), 
//				recipeDto.getPreparationTime(), recipeDto.getComments(), null, null, null, recipeDto.getFavorite());
//	}
//
//	public Recipe fromDTO (RecipeNewDTO recipeDto) {
//		Type type = new Type(recipeDto.getTypeCode(), null);
//		Category category = new Category(recipeDto.getCategoryCode(), null);
//		PrepareType prepareType = new PrepareType(recipeDto.getPrepareTypeCode(), null);
//		Recipe recipe = new Recipe (null, recipeDto.getName(), recipeDto.getTested(), recipeDto.getMethodOfPreparation(), 
//				recipeDto.getPreparationTime(), recipeDto.getComments(), category, type, prepareType, recipeDto.getFavorite());
//		return recipe;
//	}

}
