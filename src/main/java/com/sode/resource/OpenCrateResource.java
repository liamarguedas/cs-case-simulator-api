package com.sode.resource;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sode.domain.Item;
import com.sode.service.ItemService;

@RestController
@RequestMapping("/open")
public class OpenCrateResource {

	@Autowired
	private ItemService service;
	
	@GetMapping
	public ResponseEntity<Item> openRandom(){
		
		List<Item> allItems = service.findAll();
		
		Random rand = new Random();
		
		int randomIndex = rand.nextInt(allItems.size());
		return ResponseEntity.ok().body(allItems.get(randomIndex));
		
	}
	
}
