package br.com.myrecipemanager.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myrecipemanager.models.Category;
import br.com.myrecipemanager.models.DetailsRecipeIngredients;
import br.com.myrecipemanager.models.Recipe;
import br.com.myrecipemanager.models.dto.RecipeDTO;
import br.com.myrecipemanager.repositories.DetailsRecipeIngredientsRepository;
import br.com.myrecipemanager.repositories.RecipeDAO;
import br.com.myrecipemanager.repositories.RecipeRepository;
import br.com.myrecipemanager.services.exceptions.ObjectNotFoundException;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository repo;
	
	@Autowired
	private RecipeDAO dao;
	
	@Autowired
	private DetailsRecipeIngredientsService detailsService;
	
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

	public Recipe find (Integer code) {
		Optional<Recipe> recipe = repo.findById(code);
		return recipe.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado Code: " + code + ", Tipo: " + Recipe.class.getName()));
	}

	public List<Recipe> findAll() {
		return repo.findAll();
	}
	
	public List<Recipe> findRecipesFavorite() {
		return repo.findRecipesFavorite();
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
		return recipe;
		
	}
	
	public List<Recipe> findRecipesByFilters(Integer typeCode, Integer categoryCode, Integer prepareTypeCode,
			String preparationTime, String name, Boolean tested, Boolean favorite, String comments, String ingredient){
		
		return dao.findRecipesByFilters(typeCode, categoryCode, prepareTypeCode, preparationTime, name, 
				tested, favorite, comments, ingredient);
	}
	
	@Transactional
	public void delete (Integer code) {
		detailsService.deleteDetailsIngredients(code);
		dao.deleteRecipe(code);
	}
	

	@Transactional
	public Recipe update(Recipe recipe) {
		Recipe newRecipe = find(recipe.getCode());
		updateData(newRecipe, recipe);
		return repo.save(newRecipe);
	}

	private void updateData(Recipe newRecipe, Recipe recipe) {
		newRecipe.setName(recipe.getName());
		newRecipe.setTested(recipe.getTested());
		newRecipe.setMethodOfPreparation(recipe.getMethodOfPreparation());
		newRecipe.setPreparationTime(recipe.getPreparationTime());
		newRecipe.setComments(recipe.getComments());
		newRecipe.setFavorite(recipe.getFavorite());
		newRecipe.setCategory(recipe.getCategory());
		newRecipe.setType(recipe.getType());
		newRecipe.setPrepareType(recipe.getPrepareType());
	}

	public Recipe fromDTOupdate (RecipeDTO recipeDto) {
		Recipe recipe = new Recipe();
		recipe.setCategory(categoryService.find(recipeDto.getCodeCategory()));
		recipe.setType(typeService.find(recipeDto.getCodeType()));
		recipe.setPrepareType(prepareTypeService.find(recipeDto.getCodePrepareType()));
		return new Recipe(recipeDto.getCode(), recipeDto.getName(), recipeDto.getTested(), recipeDto.getMethodOfPreparation(), 
				recipeDto.getPreparationTime(), recipeDto.getComments(), recipe.getCategory(), 
				recipe.getType(), recipe.getPrepareType(), recipeDto.getFavorite());
	}
	
	public Integer randomSearch(List<Integer> codeList) {
		Collections.shuffle(codeList);
		return codeList.get(0);
	}
	
	public Recipe randomSearchRecipe(Integer categoryCode) {
		List<Integer> codeList = dao.findCodeRecipesByCategory(categoryCode);
		Integer code = null;
		if(codeList != null) {
			code = randomSearch(codeList);
		Recipe recipe = find(code);
		return recipe;
		} else {
			throw new ObjectNotFoundException("Categoria não encontrada :" + categoryCode + Category.class.getName());
		}
	}
	
	
//	NOVO OBJETO
//	public Recipe fromDTO (RecipeNewDTO recipeDto) {
//		Type type = new Type(recipeDto.getTypeCode(), null);
//		Category category = new Category(recipeDto.getCategoryCode(), null);
//		PrepareType prepareType = new PrepareType(recipeDto.getPrepareTypeCode(), null);
//		Recipe recipe = new Recipe (null, recipeDto.getName(), recipeDto.getTested(), recipeDto.getMethodOfPreparation(), 
//				recipeDto.getPreparationTime(), recipeDto.getComments(), category, type, prepareType, recipeDto.getFavorite());
//		return recipe;
//	}

}
