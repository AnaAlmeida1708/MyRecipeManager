package br.com.myrecipemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.myrecipemanager.models.DetailsRecipeIngredients;

@Repository
public interface DetailsRecipeIngredientsRepository extends JpaRepository<DetailsRecipeIngredients, Integer> {
	
//	@Modifying
//	@Query("DELETE FROM DETAILS_RECIPE_INGREDIENTS D WHERE D.RECIPE_CODE = :recipeCode ")
//	void deleteByRecipeCode(@Param("recipeCode")Integer recipeCode);

	//	public Integer deleteByRecipeCode(Integer recipeCode);
	
}
