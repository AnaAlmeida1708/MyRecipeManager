package br.com.myrecipemanager.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import br.com.myrecipemanager.models.DetailsRecipeIngredients;
import br.com.myrecipemanager.models.Ingredient;
import br.com.myrecipemanager.models.Recipe;

public class DetailsRecipeIngredientRowMapper extends BeanPropertyRowMapper<DetailsRecipeIngredients>{

	public DetailsRecipeIngredientRowMapper(Class<DetailsRecipeIngredients> clazz) {
		super(clazz);
	}

	@Override
	public DetailsRecipeIngredients mapRow(ResultSet rs, int rowNum) throws SQLException {
		DetailsRecipeIngredients details = super.mapRow(rs, rowNum);
		
		Recipe recipe = new Recipe();
		recipe.setCode(rs.getInt("recipe_code"));
		details.setRecipe(recipe);
		
		Ingredient ingredient = new Ingredient();
		ingredient.setCode(rs.getInt("ingredient_code"));
		ingredient.setName(rs.getString("name"));
		details.setIngredient(ingredient);
		
		return details;
	}

}
