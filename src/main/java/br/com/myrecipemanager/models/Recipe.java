package br.com.myrecipemanager.models;

import java.io.Serializable;

public class Recipe implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String name;
	private String tested;
	private String methodOfPreparation;
	private String preparationTime;
	private String comments;
	
	//código categoria
	//código tipo
	//código tipo preparo
	
	public Recipe() {
	}
	
	
}
