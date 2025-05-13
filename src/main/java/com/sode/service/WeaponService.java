package com.sode.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sode.domain.Weapon;
import com.sode.repository.WeaponRepository;

@Service
public class WeaponService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private WeaponRepository repository;

	public List<Weapon> findAll(){
		return repository.findAll();
	}

	public Weapon findById(String id) {
		return repository.findById(id).get();
	}
}
