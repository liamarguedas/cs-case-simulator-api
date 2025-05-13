package com.sode.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sode.domain.Case;
import com.sode.domain.Item;
import com.sode.domain.Price;
import com.sode.domain.Weapon;
import com.sode.repository.CaseRepository;
import com.sode.repository.ItemRepository;

@Service
public class CaseService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CaseRepository repository;
	
	@Autowired
	private ItemRepository itemRepository;

	public List<Case> findAll(){
		return repository.findAll();
	}

	public Case findById(String id) {
		return repository.findById(id).get();
	}
	
	public Item openCase(String id) {
		
		Case c = findById(id);

		Weapon w = c.open();
		
		// add logic to retrieve current trading price
		Price p = new Price(10.0, 3.0);
		// -------------------------------------------
		
		Item i = new Item(null, w, p, false);
		itemRepository.save(i);
		
		return i;

	}
}
