package br.com.myrecipemanager.models;

import java.io.Serializable;

public class Ingredient implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String name;
	
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

	@Override
	public String toString() {
		return "Ingredient [" + (code != null ? "code=" + code + ", " : "") + (name != null ? "name=" + name : "")
				+ "]";
	}
	

}
