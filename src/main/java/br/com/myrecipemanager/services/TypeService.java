package br.com.myrecipemanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myrecipemanager.models.Type;
import br.com.myrecipemanager.repositories.TypeRepository;
import br.com.myrecipemanager.services.exceptions.ObjectNotFoundException;

@Service
public class TypeService {
	
	@Autowired
	private TypeRepository repo;
	
	public List<Type> findAll () {
		return repo.findAll();
	}
	
	public Type find (Integer id) {
		Optional<Type> type = repo.findById(id);
		return type.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", Tipo: " + Type.class.getName()));
	}
	
}
