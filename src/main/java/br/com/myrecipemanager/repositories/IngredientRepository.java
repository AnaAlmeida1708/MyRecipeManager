package br.com.myrecipemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.myrecipemanager.models.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
	
	@Transactional(readOnly=true)
//	@Query("SELECT * FROM INGREDIENT WHERE NAME= :name ")
	Ingredient findByName(String name);
	
	
}
