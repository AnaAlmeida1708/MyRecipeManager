package br.com.myrecipemanager.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.myrecipemanager.models.Ingredient;
import br.com.myrecipemanager.models.dto.IngredientDTO;
import br.com.myrecipemanager.models.dto.IngredientNewDTO;
import br.com.myrecipemanager.services.IngredientService;

@RestController
@RequestMapping(value="/ingredientes")
public class IngredientController {
	
	@Autowired
	private IngredientService service;
	
	@RequestMapping(value="{code}",method=RequestMethod.GET)
	public ResponseEntity<Ingredient> find(@PathVariable Integer code) {
		Ingredient ingredient = service.find(code);
		return ResponseEntity.ok().body(ingredient);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<IngredientDTO>> findAll(){
		List<Ingredient> list = service.findAll();
		List<IngredientDTO> listDto = list.stream().map(obj -> new IngredientDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@Valid @RequestBody IngredientNewDTO objDto){
		Ingredient ingredient = service.fromDTO(objDto);
		ingredient = service.insert(ingredient);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{code}").buildAndExpand(ingredient.getCode()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/list",method = RequestMethod.POST)
	public ResponseEntity<Void> insertAll (@Valid @RequestBody List<IngredientNewDTO> objDtos){
		List<Ingredient>listIngred = new ArrayList<>();
		for (IngredientNewDTO ingredient : objDtos) {
			Ingredient ingred = service.fromDTO(ingredient);
			listIngred.add(ingred);
		}
		service.insertAll(listIngred);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="{code}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody IngredientDTO objDto, @PathVariable Integer code){
		Ingredient ingredient = service.fromDTO(objDto);
		ingredient.setCode(code);
		ingredient = service.update(ingredient);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "{code}")
	public ResponseEntity<Void> delete(@PathVariable Integer code){
		service.delete(code);
		return ResponseEntity.noContent().build();
	}
	
	

}
