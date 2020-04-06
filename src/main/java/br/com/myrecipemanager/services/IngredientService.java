package br.com.myrecipemanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myrecipemanager.models.Ingredient;
import br.com.myrecipemanager.repositories.IngredientRepository;
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
	
	public Ingredient insert (Ingredient ingredient) {
		ingredient.setCode(null);
		return repo.save(ingredient);
	}
	
	public Ingredient update (Ingredient ingredient) {
		Ingredient newIngredient = find(ingredient.getCode());
		updateData(newIngredient, ingredient);
		return repo.save(ingredient);
	}

	private void updateData(Ingredient newIngredient, Ingredient ingredient) {
		newIngredient.setName(ingredient.getName());
	}

}
