package br.com.myrecipemanager.models.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.myrecipemanager.models.Recipe;

public class RecipeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	@NotEmpty(message="Preenchimento obrigatório")
	private String name;
	private Boolean tested;
	@NotEmpty(message="Preenchimento obrigatório")
	private String methodOfPreparation;
	private String preparationTime;
	private String ingredients;
	private String comments;
	private Boolean favorite;
	
	private Integer codeCategory;
	private Integer codeType;
	private Integer codePrepareType;
	
	public RecipeDTO () {
	}

	public RecipeDTO(Recipe recipe) {
		setCode (recipe.getCode());
		name = recipe.getName();
		tested = recipe.getTested();
		methodOfPreparation = recipe.getMethodOfPreparation();
		preparationTime = recipe.getPreparationTime();
		comments = recipe.getComments();
		favorite = recipe.getFavorite();
		ingredients = recipe.getIngredients();
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

	public Boolean getTested() {
		return tested;
	}

	public void setTested(Boolean tested) {
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

	public Integer getCodeCategory() {
		return codeCategory;
	}

	public void setCodeCategory(Integer codeCategory) {
		this.codeCategory = codeCategory;
	}

	public Integer getCodeType() {
		return codeType;
	}

	public void setCodeType(Integer codeType) {
		this.codeType = codeType;
	}

	public Integer getCodePrepareType() {
		return codePrepareType;
	}

	public void setCodePrepareType(Integer codePrepareType) {
		this.codePrepareType = codePrepareType;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

}
