package br.com.myrecipemanager.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.myrecipemanager.models.Recipe;
import br.com.myrecipemanager.services.RecipeService;

@RestController
@RequestMapping(value = "/receitas")
public class RecipeController {
	
	@Autowired
	private RecipeService service;
	
	@RequestMapping(value="{code}",method=RequestMethod.GET)
	public ResponseEntity<Recipe> find(@PathVariable Integer code) {
		Recipe obj = service.find(code);
		return ResponseEntity.ok().body(obj);

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Recipe>> findAll() {
		List<Recipe> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@Valid @RequestBody Recipe recipe){
		recipe = service.insert(recipe);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{code}").buildAndExpand(recipe.getCode()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
