package br.com.myrecipemanager.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.myrecipemanager.models.Ingredient;
import br.com.myrecipemanager.models.dto.IngredientDTO;
import br.com.myrecipemanager.models.dto.IngredientNewDTO;
import br.com.myrecipemanager.repositories.IngredientRepository;
import br.com.myrecipemanager.services.exceptions.DataIntegrityException;
import br.com.myrecipemanager.services.exceptions.ObjectNotFoundException;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository repo;
	
	public List<Ingredient> findAll () {
		return repo.findAll();
	}
	
	public Ingredient find (Integer id) {
		Optional<Ingredient> ingredient = repo.findById(id);
		return ingredient.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", Tipo: " + Ingredient.class.getName()));
	}
	
	
	@Transactional
	public Ingredient insert (Ingredient ingredient) {
		Ingredient newIngredient = repo.findByName(ingredient.getName());
		if(newIngredient != null) {
			return newIngredient;
		}
		ingredient.setCode(null);
		return repo.save(ingredient);
	}
	
	@Transactional
	public List<Ingredient> insertAll (List<Ingredient> ingredients) {
		for (Ingredient ingredient : ingredients) {
			insert(ingredient);
		}
		return ingredients;
	}
	
	@Transactional
	public Ingredient update (Ingredient ingredient) {
		Ingredient newIngredient = repo.findByName(ingredient.getName());
		if(newIngredient != null) {
			return newIngredient;
		}
		Ingredient newIngredient2 = find(ingredient.getCode());
		updateData(newIngredient2, ingredient);
		return repo.save(ingredient);
	}

	private void updateData(Ingredient newIngredient, Ingredient ingredient) {
		newIngredient.setName(ingredient.getName());
	}
	
	public Ingredient fromDTO(IngredientDTO ingredientDto) {
		return new Ingredient(null, ingredientDto.getName());
	}
	
	public Ingredient fromDTO(IngredientNewDTO ingredientDto) {
		Ingredient ingredient = new Ingredient(null, ingredientDto.getName());
		return ingredient;
	}
	
	public void delete (Integer code) {
	try {
		repo.deleteById(code);
	} catch (DataIntegrityViolationException e) {
		throw new DataIntegrityException("Não é possível excluir por que há receitas relacionadas");
	}
}
	
}
