package br.com.myrecipemanager.models.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class IngredientNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String name;
	
	public IngredientNewDTO () {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
