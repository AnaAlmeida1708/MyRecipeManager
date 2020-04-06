package br.com.myrecipemanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myrecipemanager.models.Category;
import br.com.myrecipemanager.repositories.CategoryRepository;
import br.com.myrecipemanager.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> findAll(){
		return repo.findAll();
	}
	
	public Category find (Integer id) {
		Optional<Category> category = repo.findById(id);
		return category.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", Tipo: " + Category.class.getName()));
	}
	
}
 