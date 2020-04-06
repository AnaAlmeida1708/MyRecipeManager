package br.com.myrecipemanager.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myrecipemanager.models.Category;
import br.com.myrecipemanager.models.PrepareType;
import br.com.myrecipemanager.models.Type;
import br.com.myrecipemanager.repositories.CategoryRepository;
import br.com.myrecipemanager.repositories.PrepareTypeRepository;
import br.com.myrecipemanager.repositories.TypeRepository;

@Service
public class DBService {
	
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private PrepareTypeRepository prepareTypeRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public void instantiateTestDataBase() throws ParseException {
		
		Type typeS = new Type(null, "Salgada");
		Type typeD = new Type(null, "Doce");
		typeRepository.saveAll(Arrays.asList(typeS, typeD));
		
		PrepareType prep1 = new PrepareType(null, "Fogão");
		PrepareType prep2 = new PrepareType(null, "Forno");
		PrepareType prep3 = new PrepareType(null, "Fogão e Forno");
		PrepareType prep4 = new PrepareType(null, "Geladeira");
		PrepareType prep5 = new PrepareType(null, "Freezer");
		PrepareType prep6 = new PrepareType(null, "Outro");
		prepareTypeRepository.saveAll(Arrays.asList(prep1, prep2, prep3, prep4, prep5, prep6));
		
		Category cat1 = new Category(null, "Bebidas");
		Category cat2 = new Category(null, "Doces e Sobremesas");
		Category cat3 = new Category(null, "Pães, Bolos, Tortas e Lanches diversos");
		Category cat4 = new Category(null, "Acompanhamentos, Saladas e Molhos");
		Category cat5 = new Category(null, "Carnes, Aves, Peixes, Etc");
		Category cat6 = new Category(null, "Pratos únicos ou Principal");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		
	}

}
