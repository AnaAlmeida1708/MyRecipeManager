package br.com.myrecipemanager.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Recipe implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;
	private String name;
	private Boolean tested;
	private String methodOfPreparation;
	private String preparationTime;
	private String comments;
	private Boolean favorite;
	
	@ManyToOne
	@JoinColumn(name="category_code")//pode ser que aqui seja id ao invés de code, ver e se for o caso trocar
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="type_code")
	private Type type;
	
	@ManyToOne
	@JoinColumn(name="prepareType_code")
	private PrepareType prepareType;
	
	@OneToMany(mappedBy = "code.recipe")
	private Set<DetailsRecipeIngredients> detailsRecipeIngredients = new HashSet<>();
	
	public Recipe() {
	}

	public Recipe(Integer code, String name, Boolean tested, String methodOfPreparation, String preparationTime,
			String comments, Category category, Type type, PrepareType prepareType, Boolean favorite) {
		this.code = code;
		this.name = name;
		this.tested = tested;
		this.methodOfPreparation = methodOfPreparation;
		this.preparationTime = preparationTime;
		this.comments = comments;
		this.category = category;
		this.type = type;
		this.prepareType = prepareType;
		this.favorite = favorite;
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

	public Boolean getTested() {
		return tested;
	}

	public void setTested(Boolean tested) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public PrepareType getPrepareType() {
		return prepareType;
	}

	public void setPrepareType(PrepareType prepareType) {
		this.prepareType = prepareType;
	}

	public Set<DetailsRecipeIngredients> getDetailsRecipeIngredients() {
		return detailsRecipeIngredients;
	}

	public void setDetailsRecipeIngredients(Set<DetailsRecipeIngredients> detailsRecipeIngredients) {
		this.detailsRecipeIngredients = detailsRecipeIngredients;
	}
	
	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	@Override
	public String toString() {
		return "Recipe [" + (code != null ? "code=" + code + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (tested != null ? "tested=" + tested + ", " : "")
				+ (methodOfPreparation != null ? "methodOfPreparation=" + methodOfPreparation + ", " : "")
				+ (preparationTime != null ? "preparationTime=" + preparationTime + ", " : "")
				+ (comments != null ? "comments=" + comments + ", " : "")
				+ (favorite != null ? "favorite=" + favorite + ", " : "")
				+ (category != null ? "category=" + category + ", " : "") + (type != null ? "type=" + type + ", " : "")
				+ (prepareType != null ? "prepareType=" + prepareType + ", " : "")
				+ (detailsRecipeIngredients != null ? "detailsRecipeIngredients=" + detailsRecipeIngredients : "")
				+ "]";
	}

	
}
