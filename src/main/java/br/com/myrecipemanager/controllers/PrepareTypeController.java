package br.com.myrecipemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.myrecipemanager.models.PrepareType;
import br.com.myrecipemanager.services.PrepareTypeService;

@RestController
@RequestMapping(value = "/tipos-preparo")
public class PrepareTypeController {
	
	@Autowired
	private PrepareTypeService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PrepareType>> findAll(){
		List<PrepareType> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
