package com.sode.domain;

import java.io.Serializable;

public class Price implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double price;
	private Double marketFee;
	
	public Price() {}

	public Price(Double price, Double marketFee) {
		this.price = price;
		this.marketFee = marketFee;
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
