package com.sode.resource;

import java.io.Serializable;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sode.domain.Item;
import com.sode.service.ItemService;

@RestController
@RequestMapping(value = "/items")
public class ItemResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ItemService service;
	
	@GetMapping
	public ResponseEntity<List<Item>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Item> findById(@PathVariable String id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping(value = "/cases")
	public ResponseEntity<List<Item>> findCases(){
		return ResponseEntity.ok().body(service.findCases());
	}
	
}
