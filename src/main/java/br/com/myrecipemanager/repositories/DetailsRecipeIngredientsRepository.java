package br.com.myrecipemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.myrecipemanager.models.DetailsRecipeIngredients;

@Repository
public interface DetailsRecipeIngredientsRepository extends JpaRepository<DetailsRecipeIngredients, Integer> {
	
}
