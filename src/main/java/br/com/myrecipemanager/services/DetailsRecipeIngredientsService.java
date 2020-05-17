package br.com.myrecipemanager.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myrecipemanager.models.DetailsRecipeIngredients;
import br.com.myrecipemanager.models.Ingredient;
import br.com.myrecipemanager.models.Recipe;
import br.com.myrecipemanager.models.dto.DetailsRecipeIngredientsDTO;
import br.com.myrecipemanager.repositories.DetailsRecipeIngredientsDAO;
import br.com.myrecipemanager.repositories.DetailsRecipeIngredientsRepository;
import br.com.myrecipemanager.services.exceptions.ObjectNotFoundException;

@Service
public class DetailsRecipeIngredientsService {
	
	@Autowired
	private DetailsRecipeIngredientsRepository repo;
	
	@Autowired
	private DetailsRecipeIngredientsDAO dao;
	
	@Autowired 
	private IngredientService ingredientService;
	
	@Autowired
	private RecipeService recipeService;
	
	public List<DetailsRecipeIngredients> findDetailsByRecipe(Integer recipeCode) {
		List<DetailsRecipeIngredients> details = dao.findDetailsByRecipeCode(recipeCode);
		if (details != null) {
			return details;
		}else {
			throw new ObjectNotFoundException("Objeto não encontrado Code: " + recipeCode + ", Tipo: " + DetailsRecipeIngredients.class.getName());
		}
		
	}
	
	public void deleteDetailsIngredients(Integer recipeCode) {
		dao.deleteDetailsIngredients(recipeCode);
	}
	
	@Transactional
	public List<DetailsRecipeIngredients> insertAll(List<DetailsRecipeIngredients> details){
		for (DetailsRecipeIngredients detailsRecipeIngredients : details) {
			repo.save(detailsRecipeIngredients);
		}
		return details;
	}
	@Transactional
	public void update(Integer recipeCode, List<DetailsRecipeIngredients> details) {
		deleteDetailsIngredients(recipeCode);
		insertAll(details);
	}
	
	public List<DetailsRecipeIngredients> listFromDTO(List<DetailsRecipeIngredientsDTO> listDto){
		List<DetailsRecipeIngredients> listDetails = new ArrayList<>();
		for (DetailsRecipeIngredientsDTO detailsDto : listDto) {
			DetailsRecipeIngredients details = new DetailsRecipeIngredients();
			Recipe recipe = recipeService.find(detailsDto.getRecipeCode());
			Ingredient ingredient = ingredientService.find(detailsDto.getIngredientCode());
			details.setQuantity(detailsDto.getQuantity());
			details.setIngredient(ingredient);
			details.setRecipe(recipe);
			listDetails.add(details);
		}
		return listDetails;
	}
	

}
