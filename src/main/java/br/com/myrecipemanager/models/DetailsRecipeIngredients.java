package br.com.myrecipemanager.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DetailsRecipeIngredients implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private DetailsRecipeIngredientsPK id = new DetailsRecipeIngredientsPK();
	private String quantidade;
	
	@ManyToOne
	@JoinColumn(name="recipe_code")
	private Recipe recipe;
	
	@ManyToOne
	@JoinColumn(name="ingredient_code")
	private Ingredient ingredient;
	 
	public DetailsRecipeIngredients () {
	}

	public DetailsRecipeIngredients(String quantidade, Recipe recipe, Ingredient ingredient) {
		id.setRecipe(recipe);
		id.setIngredient(ingredient);
		this.quantidade = quantidade;
		this.recipe = recipe;
		this.ingredient = ingredient;
	}
	

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	@JsonIgnore
	public Recipe getRecipe() {
		return id.getRecipe();
	}

	public void setRecipe(Recipe recipe) {
		id.setRecipe(recipe);
	}

	public Ingredient getIngredient() {
		return id.getIngredient();
	}

	public void setIngredient(Ingredient ingredient) {
		id.setIngredient(ingredient);
	}

	public DetailsRecipeIngredientsPK getId() {
		return id;
	}

	public void setId(DetailsRecipeIngredientsPK id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DetailsRecipeIngredients [" + (quantidade != null ? "quantidade=" + quantidade + ", " : "")
				+ (recipe != null ? "recipe=" + recipe + ", " : "")
				+ (ingredient != null ? "ingredient=" + ingredient : "") + "]";
	}
	
	
}
