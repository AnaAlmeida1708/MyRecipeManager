package br.com.myrecipemanager.models.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.myrecipemanager.models.Recipe;

public class RecipeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	@NotEmpty(message="Preenchimento obrigatório")
	private String name;
	private String tested;
	@NotEmpty(message="Preenchimento obrigatório")
	private String methodOfPreparation;
	private String preparationTime;
	private String comments;
	private Boolean favorite;
	
	public RecipeDTO () {
	}

	public RecipeDTO(Recipe recipe) {
		code = recipe.getCode();
		name = recipe.getName();
		tested = recipe.getTested();
		methodOfPreparation = recipe.getMethodOfPreparation();
		preparationTime = recipe.getPreparationTime();
		comments = recipe.getComments();
		favorite = recipe.getFavorite();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTested() {
		return tested;
	}

	public void setTested(String tested) {
		this.tested = tested;
	}

	public String getMethodOfPreparation() {
		return methodOfPreparation;
	}

	public void setMethodOfPreparation(String methodOfPreparation) {
		this.methodOfPreparation = methodOfPreparation;
	}

	public String getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(String preparationTime) {
		this.preparationTime = preparationTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}
	

}