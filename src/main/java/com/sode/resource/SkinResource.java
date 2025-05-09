package com.sode.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sode.domain.Skin;
import com.sode.service.SkinService;

@RestController
@RequestMapping(value = "/skins")
public class SkinResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SkinService service;
	
	@GetMapping
	public ResponseEntity<List<Skin>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
}
