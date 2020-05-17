package br.com.myrecipemanager.repositories;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.myrecipemanager.models.Recipe;
import br.com.myrecipemanager.rowmappers.RecipeRowMapper;

@Repository
public class RecipeDAO {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Recipe> findRecipesByFilters(Integer typeCode, Integer categoryCode, Integer prepareTypeCode,
			String preparationTime, String name, Boolean tested, Boolean favorite, String comments, String ingredient) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT R.CODE, R.COMMENTS, R.FAVORITE, R.NAME, R.TESTED, R.METHOD_OF_PREPARATION, R.PREPARATION_TIME, ")
			.append(" R.CATEGORY_CODE, R.PREPARE_TYPE_CODE, R.TYPE_CODE FROM RECIPE as R ")
			.append(" LEFT JOIN TYPE AS T ON R.TYPE_CODE = T.CODE ")
			.append(" LEFT JOIN CATEGORY AS C ON R.CATEGORY_CODE = C.CODE ")
			.append(" LEFT JOIN PREPARE_TYPE AS PT ON R.PREPARE_TYPE_CODE = PT.CODE ")
			.append(" LEFT JOIN DETAILS_RECIPE_INGREDIENTS AS DRI ON R.CODE = DRI.RECIPE_CODE ")
			.append(" LEFT JOIN INGREDIENT AS I ON I.CODE = DRI.INGREDIENT_CODE ")
			.append(" WHERE 1 = 1 ");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		if (typeCode != null) { 
			sql.append(" AND T.CODE= :typeCode "); 
			params.addValue("typeCode", typeCode);
			} 
		if (categoryCode != null) { 
			sql.append(" AND C.CODE= :categoryCode "); 
			params.addValue("categoryCode", categoryCode);
			} 
		if (prepareTypeCode != null) { 
			sql.append(" AND PT.CODE= :prepareTypeCode "); 
			params.addValue("prepareTypeCode", prepareTypeCode);
			} 
		if (StringUtils.isNoneBlank(preparationTime)) { 
			sql.append(" AND R.PREPARATION_TIME= :preparationTime "); 
			params.addValue("preparationTime", "%" + preparationTime + "%"); 
			}
		if (StringUtils.isNoneBlank(name)) { 
			sql.append(" AND R.NAME LIKE :name "); 
			params.addValue("name", "%" + name + "%"); 
			} 
		if (tested != null) { 
			sql.append(" AND R.TESTED= :tested "); 
			params.addValue("tested", tested);
			} 
		if (favorite != null) { 
			sql.append(" AND R.FAVORITE= :favorite "); 
			params.addValue("favorite", favorite);
			} 
		if (StringUtils.isNoneBlank(comments)) { 
			sql.append(" AND R.COMMENTS LIKE :comments "); 
			params.addValue("comments", "%" + comments + "%"); 
			} 
		if (StringUtils.isNoneBlank(ingredient)) { 
			sql.append(" and I.NAME LIKE :ingredient "); 
			params.addValue("ingredient", "%" + ingredient + "%"); 
			} 

		List<Recipe> query = jdbcTemplate.query(sql.toString(), params, new RecipeRowMapper(Recipe.class));
		
		return query;
		
	}
	
	public void deleteRecipe(Integer code) {
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM RECIPE WHERE 1=1 ");
		sql.append(" AND CODE= :code ");
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("code", code);
		
		jdbcTemplate.update(sql.toString(), param);
	}
	

}
