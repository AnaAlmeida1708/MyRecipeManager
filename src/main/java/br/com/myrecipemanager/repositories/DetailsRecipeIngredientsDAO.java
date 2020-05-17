package br.com.myrecipemanager.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.myrecipemanager.models.DetailsRecipeIngredients;
import br.com.myrecipemanager.rowmappers.DetailsRecipeIngredientRowMapper;

@Repository
public class DetailsRecipeIngredientsDAO {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<DetailsRecipeIngredients> findDetailsByRecipeCode(Integer recipeCode){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DRI.RECIPE_CODE, DRI.INGREDIENT_CODE, DRI.QUANTITY, I.NAME as name ")
		.append(" FROM DETAILS_RECIPE_INGREDIENTS DRI ")
		.append(" LEFT JOIN INGREDIENT I ON I.CODE = DRI.INGREDIENT_CODE WHERE 1=1 ");
		sql.append(" AND DRI.RECIPE_CODE = :recipeCode ");
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("recipeCode", recipeCode);
		
		List<DetailsRecipeIngredients> query = jdbcTemplate.query(sql.toString(), param, new DetailsRecipeIngredientRowMapper(DetailsRecipeIngredients.class));
		
		return query;
	}
	
	
	public void deleteDetailsIngredients(Integer recipeCode) {
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM DETAILS_RECIPE_INGREDIENTS WHERE 1=1 ");
		sql.append(" AND RECIPE_CODE= :recipeCode ");
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("recipeCode", recipeCode);
		
		jdbcTemplate.update(sql.toString(), param);
	}
	
}
