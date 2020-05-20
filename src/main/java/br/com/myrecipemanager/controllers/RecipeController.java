package br.com.myrecipemanager.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.myrecipemanager.models.Recipe;
import br.com.myrecipemanager.models.dto.RecipeDTO;
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
	
	@GetMapping("/favoritas")
	public ResponseEntity<List<Recipe>> findRecipesFavorite() {
		List<Recipe> list = service.findRecipesFavorite();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@Valid @RequestBody Recipe recipe){
		recipe = service.insert(recipe);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{code}").buildAndExpand(recipe.getCode()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/filtros")
	public ResponseEntity<List<Recipe>> findByFilters(
			@RequestParam(value="typeCode", required=false)Integer typeCode,
			@RequestParam(value="categoryCode", required=false)Integer categoryCode,
			@RequestParam(value="prepareTypeCode", required=false)Integer prepareTypeCode,
			@RequestParam(value="preparationTime", required=false)String preparationTime,
			@RequestParam(value="name", required=false)String name,
			@RequestParam(value="tested", required=false)Boolean tested,
			@RequestParam(value="favorite", required=false)Boolean favorite,
			@RequestParam(value="comments", required=false)String comments,
			@RequestParam(value="ingredient", required=false)String ingredient
			) {
		List<Recipe> list = service.findRecipesByFilters(typeCode, categoryCode, prepareTypeCode, 
				preparationTime, name, tested, favorite, comments, ingredient);
		return ResponseEntity.ok().body(list);
	}
	
	@Transactional
	@DeleteMapping(value="{code}")
	public ResponseEntity<Void> delete(@PathVariable Integer code) {
		service.delete(code);
		return ResponseEntity.noContent().build();
	}
	
	@Transactional
	@PutMapping(value = "{code}")
	public ResponseEntity<Void> updateRecipe(@Valid @RequestBody RecipeDTO recipeDto, @PathVariable Integer code){
		Recipe recipe = service.fromDTOupdate(recipeDto);
		recipe.setCode(code);
		recipe = service.update(recipe);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/aleatoria")
	public ResponseEntity<Recipe> randomSearchRecipe(@RequestParam(value="categoryCode", required = false) Integer categoryCode){
		Recipe recipe = service.randomSearchRecipe(categoryCode);
		return ResponseEntity.ok().body(recipe);
	}
	
}
