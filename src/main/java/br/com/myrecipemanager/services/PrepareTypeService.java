package br.com.myrecipemanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myrecipemanager.models.PrepareType;
import br.com.myrecipemanager.repositories.PrepareTypeRepository;
import br.com.myrecipemanager.services.exceptions.ObjectNotFoundException;

@Service
public class PrepareTypeService {
	
	@Autowired
	private PrepareTypeRepository repo;
	
	public List<PrepareType> findAll () {
		return repo.findAll();
	}
	
	public PrepareType find (Integer id) {
		Optional<PrepareType> prepareType = repo.findById(id);
		return prepareType.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", Tipo: " + PrepareType.class.getName()));
	}
	
}
