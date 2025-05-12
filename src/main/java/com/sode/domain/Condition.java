package com.sode.domain;

import java.io.Serializable;

import com.sode.domain.enums.Exteriors;
import com.sode.domain.enums.Qualities;

public class Condition implements Serializable{

	private static final long serialVersionUID = 1L;

	private Exteriors exterior;
	private String skin;
	private Double nFloat;
	private Qualities quality;
	
	
	public Condition() {}


	public Condition(Exteriors exterior, Double nFloat, Qualities quality, String skin) {
		this.exterior = exterior;
		this.nFloat = nFloat;
		this.quality = quality;
		this.skin = skin;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}


	public Exteriors getExterior() {
		return exterior;
	}


	public void setExterior(Exteriors exterior) {
		this.exterior = exterior;
	}


	public Double getnFloat() {
		return nFloat;
	}


	public void setnFloat(Double nFloat) {
		this.nFloat = nFloat;
	}


	public Qualities getQuality() {
		return quality;
	}


	public void setQuality(Qualities quality) {
		this.quality = quality;
	}
	
}
