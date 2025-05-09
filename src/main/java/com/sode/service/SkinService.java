package com.sode.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sode.domain.Skin;
import com.sode.repository.SkinRepository;


@Service
public class SkinService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SkinRepository repository;

	public List<Skin> findAll(){
		return repository.findAll();
	}

}
