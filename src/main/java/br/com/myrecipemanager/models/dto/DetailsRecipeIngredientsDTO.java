package br.com.myrecipemanager.models.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.myrecipemanager.models.DetailsRecipeIngredients;

public class DetailsRecipeIngredientsDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private Integer recipeCode;
	@NotEmpty
	private Integer ingredientCode;
	@NotEmpty(message="Preenchimento obrigatório")
	private String quantity;
	
	public DetailsRecipeIngredientsDTO() {
	}
	
	public DetailsRecipeIngredientsDTO(DetailsRecipeIngredients details) {
		recipeCode = details.getRecipe().getCode();
		ingredientCode = details.getIngredient().getCode();
		quantity = details.getQuantity();
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Integer getRecipeCode() {
		return recipeCode;
	}

	public void setRecipeCode(Integer recipeCode) {
		this.recipeCode = recipeCode;
	}

	public Integer getIngredientCode() {
		return ingredientCode;
	}

	public void setIngredientCode(Integer ingredientCode) {
		this.ingredientCode = ingredientCode;
	}
	

}
