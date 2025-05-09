package com.sode.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
