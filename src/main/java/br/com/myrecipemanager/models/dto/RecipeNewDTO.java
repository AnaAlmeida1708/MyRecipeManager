package br.com.myrecipemanager.models.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class RecipeNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String name;
	private String tested;
	@NotEmpty(message="Preenchimento obrigatório")
	private String methodOfPreparation;
	private String preparationTime;
	private String comments;
	private Boolean favorite;
	private Integer categoryCode;
	private Integer typeCode;
	private Integer prepareTypeCode;
	
	public RecipeNewDTO () {
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

	public Integer getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(Integer categoryCode) {
		this.categoryCode = categoryCode;
	}

	public Integer getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(Integer typeCode) {
		this.typeCode = typeCode;
	}

	public Integer getPrepareTypeCode() {
		return prepareTypeCode;
	}

	public void setPrepareTypeCode(Integer prepareTypeCode) {
		this.prepareTypeCode = prepareTypeCode;
	}
	
}
