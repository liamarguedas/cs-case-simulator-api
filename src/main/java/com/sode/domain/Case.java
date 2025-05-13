package com.sode.domain;

import java.util.Objects;

import com.sode.domain.interfaces.ItemType;

public class Case implements ItemType{
	
	private String id;
	private String name;
	
	public Case() {}

	public Case(String id, String name ) {
		this.name = name;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Case other = (Case) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String generateName() {
		return name;
	}

}
