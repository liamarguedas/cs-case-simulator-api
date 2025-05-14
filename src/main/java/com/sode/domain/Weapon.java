package com.sode.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sode.domain.enums.Categories;
import com.sode.domain.enums.Weapons;

@Document
public class Weapon extends Item implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Weapons weaponType;

	private Categories category;
	private Condition condition;

	public Weapon() {
	}

	public Weapon(String id, Weapons weaponType, Condition condition, Categories category, Boolean tradable) {
		
		super(null, tradable);
		
		this.id = id;
		this.weaponType = weaponType;
		this.condition = condition;
		this.category = category;
		
	}

	public String getName() {
		return category.generatePrintable() + " " + weaponType.getDisplayName() + " | " + condition.getSkin();
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

	public Weapons getWeaponType() {
		return weaponType;
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
		return "Weapon [id=" + id + ", name=" + weaponType.getDisplayName() + "]";
	}


}
