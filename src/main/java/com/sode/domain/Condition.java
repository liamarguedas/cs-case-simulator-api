package com.sode.domain;

import java.io.Serializable;

import com.sode.domain.enums.Exterior;
import com.sode.domain.enums.Quality;

public class Condition implements Serializable{

	private static final long serialVersionUID = 1L;

	private Exterior exterior;
	private Double nFloat;
	private Quality quality;
	
	
	public Condition() {}


	public Condition(Exterior exterior, Double nFloat, Quality quality) {
		this.exterior = exterior;
		this.nFloat = nFloat;
		this.quality = quality;
	}


	public Exterior getExterior() {
		return exterior;
	}


	public void setExterior(Exterior exterior) {
		this.exterior = exterior;
	}


	public Double getnFloat() {
		return nFloat;
	}


	public void setnFloat(Double nFloat) {
		this.nFloat = nFloat;
	}


	public Quality getQuality() {
		return quality;
	}


	public void setQuality(Quality quality) {
		this.quality = quality;
	}
	
}
