package br.com.myrecipemanager.models.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.myrecipemanager.models.Ingredient;

public class IngredientDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	@NotEmpty(message="Preenchimento obrigatório")
	private String name;
	
	public IngredientDTO () {
	}

	public IngredientDTO(Ingredient ingredient) {
		code = ingredient.getCode();
		name = ingredient.getName();
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
	

}
