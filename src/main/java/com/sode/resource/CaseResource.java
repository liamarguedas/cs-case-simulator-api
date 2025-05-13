package com.sode.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sode.domain.Case;
import com.sode.domain.Item;
import com.sode.service.CaseService;

@RestController
@RequestMapping(value = "/cases")
public class CaseResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CaseService service;
	
	@GetMapping
	public ResponseEntity<List<Case>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Case> findById(@PathVariable String id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping(value = "/{id}/open")
	public ResponseEntity<Item> openCase(@PathVariable String id){
		
		Item found = service.openCase(id);
		
		return ResponseEntity.ok().body(found);
			
	}
	
}
