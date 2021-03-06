package br.com.myrecipemanager.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DetailsRecipeIngredients implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private DetailsRecipeIngredientsPK code = new DetailsRecipeIngredientsPK();
	private String quantity;
	 
	public DetailsRecipeIngredients () {
	}

	public DetailsRecipeIngredients(String quantity, Recipe recipe, Ingredient ingredient) {
		code.setRecipe(recipe);
		code.setIngredient(ingredient);
		this.quantity = quantity;
	}
	

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	@JsonIgnore
	public Recipe getRecipe() {
		return code.getRecipe();
	}

	public void setRecipe(Recipe recipe) {
		code.setRecipe(recipe);
	}

	public Ingredient getIngredient() {
		return code.getIngredient();
	}

	public void setIngredient(Ingredient ingredient) {
		code.setIngredient(ingredient);
	}

	public DetailsRecipeIngredientsPK getCode() {
		return code;
	}

	public void setCode(DetailsRecipeIngredientsPK code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "DetailsRecipeIngredients [" + (code != null ? "code=" + code + ", " : "")
				+ (quantity != null ? "quantidade=" + quantity : "") + "]";
	}
	
	
}
