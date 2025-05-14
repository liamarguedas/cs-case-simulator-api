package com.sode.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sode.domain.Weapon;
import com.sode.service.WeaponService;

@RestController
@RequestMapping(value = "/weapons")
public class WeaponResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private WeaponService service;
	
	@GetMapping
	public ResponseEntity<List<Weapon>> findAll(){

		return ResponseEntity.ok().body(service.findAll());

	}
	
	@GetMapping(value = "/catalog")
	public ResponseEntity<List<Weapon>> findAllCatalog(){
		return ResponseEntity.ok().body(service.findAllCatalog());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Weapon> findById(@PathVariable String id){

		return ResponseEntity.ok().body(service.findById(id));

	}

}
