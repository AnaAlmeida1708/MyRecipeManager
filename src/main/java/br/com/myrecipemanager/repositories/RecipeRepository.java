package br.com.myrecipemanager.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.myrecipemanager.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	
	@Transactional
	@Query(" SELECT r FROM Recipe r WHERE r.favorite = true ORDER BY r.name")
	public List<Recipe> findRecipesFavorite();
}


