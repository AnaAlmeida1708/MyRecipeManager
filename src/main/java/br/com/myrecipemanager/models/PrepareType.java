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
public class PrepareType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;
	private String prepareType;
	
	@JsonIgnore
	@OneToMany(mappedBy="prepareType")
	private List<Recipe> recipes = new ArrayList<Recipe>();
	
	public PrepareType () {
	}

	public PrepareType(Integer code, String prepareType) {
		super();
		this.code = code;
		this.prepareType = prepareType;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getPrepareType() {
		return prepareType;
	}

	public void setPrepareType(String prepareType) {
		this.prepareType = prepareType;
	}

	@Override
	public String toString() {
		return "TipoPreparo [" + (code != null ? "code=" + code + ", " : "")
				+ (prepareType != null ? "prepareType=" + prepareType : "") + "]";
	}
	
}
