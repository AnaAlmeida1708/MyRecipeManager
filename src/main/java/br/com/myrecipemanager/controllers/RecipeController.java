package br.com.myrecipemanager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/receitas")
public class RecipeController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
	return "Testando o REST";
	}
}
