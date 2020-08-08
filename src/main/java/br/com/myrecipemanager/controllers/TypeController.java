package br.com.myrecipemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.myrecipemanager.models.Type;
import br.com.myrecipemanager.services.TypeService;

@RestController
@RequestMapping(value = "/tipos")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Type>> findAllTypes() {
		List<Type> list = typeService.findAll();
		return ResponseEntity.ok().body(list);
	}
}
