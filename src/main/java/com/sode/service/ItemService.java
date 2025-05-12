package com.sode.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sode.domain.Item;
import com.sode.repository.ItemRepository;

@Service
public class ItemService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ItemRepository repository;

	public List<Item> findAll(){
		return repository.findAll();
	}

	public Item findById(String id) {
		return repository.findById(id).get();
	}
}
