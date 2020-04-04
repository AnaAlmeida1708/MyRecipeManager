package br.com.myrecipemanager.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Ingredient implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="code_ingredient")
	private Set<DetailsRecipeIngredients> detailsRecipeIngredients = new HashSet<>();
	
	public Ingredient() {
	}

	public Ingredient(Integer code, String name) {
		super();
		this.code = code;
		this.name = name;
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

	public Set<DetailsRecipeIngredients> getDetailsRecipeIngredients() {
		return detailsRecipeIngredients;
	}

	public void setDetailsRecipeIngredients(Set<DetailsRecipeIngredients> detailsRecipeIngredients) {
		this.detailsRecipeIngredients = detailsRecipeIngredients;
	}

	@Override
	public String toString() {
		return "Ingredient [" + (code != null ? "code=" + code + ", " : "") + (name != null ? "name=" + name : "")
				+ "]";
	}
	

}
