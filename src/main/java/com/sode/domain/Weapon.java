package com.sode.domain;

import java.io.Serializable;
import java.util.Objects;

public class Weapon implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	private Category category;
	private Condition condition;

	public Weapon() {
	}

	public Weapon(String id, String name, Category category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapon other = (Weapon) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Weapon [id=" + id + ", name=" + name + "]";
	}

}
