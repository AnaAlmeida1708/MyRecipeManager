package br.com.myrecipemanager.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.myrecipemanager.models.DetailsRecipeIngredients;
import br.com.myrecipemanager.models.dto.DetailsRecipeIngredientsDTO;
import br.com.myrecipemanager.services.DetailsRecipeIngredientsService;

@RestController
@RequestMapping(value = "/detalhes-ingredientes-receita")
public class DetailsRecipeIngredientsController {
	
	@Autowired
	private DetailsRecipeIngredientsService service;
	
	@GetMapping(value = "{code}")
	public ResponseEntity<List<DetailsRecipeIngredients>> findDetailsByRecipeCode(@PathVariable Integer code){
		List<DetailsRecipeIngredients> list = service.findDetailsByRecipe(code);
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping(value = "{recipeCode}")
	public ResponseEntity<Void> update(@Valid @RequestBody List<DetailsRecipeIngredientsDTO> listDto, @PathVariable Integer recipeCode) {
		List<DetailsRecipeIngredients> listDetails = service.listFromDTO(listDto);
		service.update(recipeCode, listDetails);
		return ResponseEntity.noContent().build();
	}
}
