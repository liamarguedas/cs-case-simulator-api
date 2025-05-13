package com.sode.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sode.domain.enums.Exteriors;
import com.sode.domain.enums.Qualities;
import com.sode.domain.interfaces.ItemType;

@Document
public class Case implements ItemType, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private static Map<Qualities, Double> probabilities = new HashMap<>();
	private List<Weapon> items = new ArrayList<>();

	public Case() {
	}

	public Case(String id, String name) {
		this.name = name;
		updateProbabilities();
	}

	public Map<Qualities, Double> getProbabilities() {
		return probabilities;
	}

	public List<Weapon> getItens() {
		return items;
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

	private void updateProbabilities() {

		probabilities.put(Qualities.MIL_SPEC, 79.92);
		probabilities.put(Qualities.RESTRICTED, 15.98);
		probabilities.put(Qualities.CLASSIFIED, 3.2);
		probabilities.put(Qualities.COVERT, 0.64);
		probabilities.put(Qualities.RARE_SPECIAL_ITEM, 0.26);

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
		Case other = (Case) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String generateName() {
		return name;
	}

	public Weapon open() {

		Qualities selectedQuality = getRandomQuality();

		List<Weapon> possibleItems = items.stream()
				.filter(w -> w.getCondition().getQuality().getValue() == selectedQuality.getValue()).toList();
		
		Random ran = new Random();
		int randomIndex = ran.nextInt(possibleItems.size());
		
		Weapon w = possibleItems.get(randomIndex);
		
		double nFloat = getRandomFloat();
		
		Condition c = new Condition(getExterior(nFloat), nFloat, selectedQuality,w.getCondition().getSkin());	
		
		w.setCondition(c);
		
		return w;

	}
	
	private static Exteriors getExterior(double nFloat) {
		
		if (nFloat <= 0.07) return Exteriors.FACTORY_NEW;
		if (nFloat <= 0.15) return Exteriors.MINIMAL_WEAR;
		if (nFloat <= 0.38) return Exteriors.FIELD_TESTED;
		if (nFloat <= 0.45) return Exteriors.WELL_WORN;
		return Exteriors.BATTLE_SCARRE;
	
	}
	
	private static double getRandomFloat() {
		
		Random ran = new Random();
		return Math.round(ran.nextDouble() * 100000d) / 100000d;
		
	}

	private static Qualities getRandomQuality() {

		Random ran = new Random();

		double roll = ran.nextDouble() * 100;
		double cumulative = 0;

		for (Map.Entry<Qualities, Double> entry : probabilities.entrySet()) {
			cumulative += entry.getValue();
			if (roll < cumulative) {
				return entry.getKey();
			}
		}
		return Qualities.MIL_SPEC;
	}

}
