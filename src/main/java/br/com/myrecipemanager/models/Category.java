package br.com.myrecipemanager.models;

import java.io.Serializable;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String description;
	
	public Category () {
	}

	public Category(Integer code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Categoria [" + (code != null ? "code=" + code + ", " : "")
				+ (description != null ? "description=" + description : "") + "]";
	}
	
}
