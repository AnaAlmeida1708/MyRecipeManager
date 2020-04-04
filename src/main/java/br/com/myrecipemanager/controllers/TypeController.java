package br.com.myrecipemanager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.myrecipemanager.models.Type;

@RestController
@RequestMapping(value = "/receitas")
public class TypeController {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Type> listarTipos() {
		Type tipo1 = new Type(1, "Salgada");
		Type tipo2 = new Type(2, "Doce");
		
		List<Type> tipos = new ArrayList<Type>();
		tipos.add(tipo1);
		tipos.add(tipo2);
		
	return tipos;
	}
}
