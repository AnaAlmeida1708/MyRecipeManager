package br.com.myrecipemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.myrecipemanager.models.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
	
}
