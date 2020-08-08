package br.com.myrecipemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.myrecipemanager.models.Category;
import br.com.myrecipemanager.services.CategoryService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}	
