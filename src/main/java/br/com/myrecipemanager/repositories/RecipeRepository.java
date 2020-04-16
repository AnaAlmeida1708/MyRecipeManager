package br.com.myrecipemanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.myrecipemanager.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	
//	@Query("
//	SELECT * FROM RECIPE  as R
//	LEFT JOIN TYPE AS T
//	ON R.TYPE_CODE = T.CODE
//	LEFT JOIN CATEGORY AS C
//	ON R.CATEGORY_CODE = C.CODE
//	LEFT JOIN PREPARE_TYPE AS PT
//	ON R.PREPARE_TYPE_CODE = PT.CODE
//	WHERE T.CODE=1 AND C.CODE=3 AND PT.CODE=6 
//	AND R.COMMENTS LIKE '%?%'
//	AND R.FAVORITE=?
//	AND R.PREPARATION_TIME='?'
//	AND R.TESTED=?
//	AND R.NAME LIKE '%?%'
//	public List<Recipe> generalFilters(Integer typeCode, Integer prepareTypeCode, 
//			String ingredient, String preparationTime, Integer categoryCode, String name, 
//			Boolean tested, Boolean favorite, String comment);
}


