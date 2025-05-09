package com.sode.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sode.domain.Category;
import com.sode.service.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
}
