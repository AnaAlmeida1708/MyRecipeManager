package br.com.myrecipemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.myrecipemanager.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	
}
