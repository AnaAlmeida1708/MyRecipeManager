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
public class Type implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;
	private String type;
	
	@JsonIgnore
	@OneToMany(mappedBy="type")
	private List<Recipe> recipes = new ArrayList<Recipe>();
	
	public Type () {
	}

	public Type(Integer code, String type) {
		super();
		this.code = code;
		this.type = type;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	@Override
//	public String toString() {
//		return "Tipo [" + (code != null ? "code=" + code + ", " : "") + (type != null ? "type=" + type : "") + "]";
//	}

}
