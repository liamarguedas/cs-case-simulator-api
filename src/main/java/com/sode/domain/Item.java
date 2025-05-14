package com.sode.domain;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private Price price;
	private Boolean tradable;

	public Item() {}

	public Item(Price price, Boolean tradable) {
		this.price = price;
		this.tradable = tradable;
	}

	public Boolean isTradable() {
		return tradable;
	}

	public void setTradable(Boolean tradable) {
		this.tradable = tradable;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Price getPrice() {
		return price;
	}
}
