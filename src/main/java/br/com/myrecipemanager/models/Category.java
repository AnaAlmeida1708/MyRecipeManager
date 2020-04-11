package br.com.myrecipemanager.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<Recipe> recipes = new ArrayList<Recipe>();
	
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

//	@Override
//	public String toString() {
//		return "Categoria [" + (code != null ? "code=" + code + ", " : "")
//				+ (description != null ? "description=" + description : "") + "]";
//	}
	
}
