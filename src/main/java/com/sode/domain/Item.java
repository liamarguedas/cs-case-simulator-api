package com.sode.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private Boolean create;

	private Price price;

	private Weapon weapon;

	private List<Weapon> itens = new ArrayList<>();

	public Item() {}

	public Item(String id, String name, Price price, Boolean create) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.create = create;
	}

	public Weapon getWeapon() {
		if (!create) {
			return weapon;
		}
		return null;
	}

	public void setWeapon(Weapon weapon) {
		if (!create) {
			this.weapon = weapon;
		}
	}

	public List<Weapon> getItens() {
		if (create) {
			return itens;
		}
		return null;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Price getPrice() {
		return price;
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
		Item other = (Item) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + "]";
	}

}
