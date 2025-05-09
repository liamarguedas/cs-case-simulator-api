package com.sode.domain;

import java.io.Serializable;

public class Price implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Item item;
	private Double price;
	private Double marketFee;
	
	public Price() {}

	public Price(Item item , Double price, Double marketFee) {
		this.item = item;
		this.price = price;
		this.marketFee = marketFee;
	}

	public Item getItem() {
		return item;
	}

	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Double getMarketFee() {
		return marketFee;
	}


	public void setMarketFee(Double marketFee) {
		this.marketFee = marketFee;
	}
	
	public Double buyerPrice() {
		return price;
		
	}
	
	public Double sellerPrice() {
		return price - marketFee;
	}
	
	
	
	

}
