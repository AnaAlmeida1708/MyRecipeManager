package br.com.myrecipemanager.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import br.com.myrecipemanager.models.Category;
import br.com.myrecipemanager.models.PrepareType;
import br.com.myrecipemanager.models.Recipe;
import br.com.myrecipemanager.models.Type;

public class RecipeRowMapper extends BeanPropertyRowMapper<Recipe>{

	public RecipeRowMapper(Class<Recipe> clazz) {
		super(clazz);
	}

	@Override
	public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
		Recipe recipe = super.mapRow(rs, rowNum);
		
		Type type = new Type();
		type.setCode(rs.getInt("type_code"));
		recipe.setType(type);
		
		Category category = new Category();
		category.setCode(rs.getInt("category_code"));
		recipe.setCategory(category);
		
		PrepareType prepareType = new PrepareType();
		prepareType.setCode(rs.getInt("prepare_type_code"));
		recipe.setPrepareType(prepareType);
		
		return recipe;
	}

}
