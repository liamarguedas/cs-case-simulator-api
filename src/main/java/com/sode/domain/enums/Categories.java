package com.sode.domain.enums;

public enum Categories {
	NORMAL(1),
	STATTRAK(2),
	KNIFE(3),
	KNIFE_STATTRAK(4),
	GLOVES(5);
	
	private final Integer value;
	
	private Categories(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public static Categories fromValue(Integer value) {
		 for (Categories status : Categories.values()) {
	            if (status.getValue() == value) {
	                return status;
	            }
	        }
		 return null;
	}

	public String generatePrintable() {

		String prefix = switch (getValue()) {
		case 2 -> "StatTrak™";
		case 3, 4 -> "★";
		default -> "";
		};

		return prefix;
	}


}
