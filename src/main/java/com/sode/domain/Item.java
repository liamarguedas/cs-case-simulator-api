package com.sode.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sode.domain.interfaces.ItemType;

@Document
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private Boolean create;

	private Price price;

	private ItemType item;

	private List<ItemType> itens = new ArrayList<>();

	public Item() {}

	public Item(String id, ItemType item, Price price, Boolean create) {
		this.id = id;
		this.item = item;
		this.price = price;
		this.create = create;
		this.name = item.generateName();
	}

	public Boolean isCreate() {
		return create;
	}

	public ItemType getItem() {
		return item;
	}

	public void setItem(ItemType item) {
		this.item = item;
	}

	public List<ItemType> getItens() {
		return itens;
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
