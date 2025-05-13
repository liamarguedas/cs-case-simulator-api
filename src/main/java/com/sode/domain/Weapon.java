package com.sode.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sode.domain.enums.Categories;
import com.sode.domain.enums.Weapons;
import com.sode.domain.interfaces.ItemType;

@Document
public class Weapon implements Serializable, ItemType {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Weapons type;

	private Categories category;
	private Condition condition;

	public Weapon() {
	}

	public Weapon(String id, Weapons type, Condition condition, Categories category) {

		
		this.id = id;
		this.type = type;
		this.condition = condition;
		this.category = category;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Categories getSkinCategory() {
		return category;
	}

	public void setSkinCategory(Categories category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Weapons getType() {
		return type;
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
		Weapon other = (Weapon) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Weapon [id=" + id + ", name=" + type.getDisplayName() + "]";
	}

	public String generateName() {
		return category.generatePrintable() + " " + type.getDisplayName() + " | " + condition.getSkin();
	}


}
