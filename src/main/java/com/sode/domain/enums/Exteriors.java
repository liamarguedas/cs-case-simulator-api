package com.sode.domain.enums;

public enum Exteriors {
	
	FACTORY_NEW(0),
	MINIMAL_WEAR(1),
	FIELD_TESTED(2),
	WELL_WORN(3),
	BATTLE_SCARRE(4);
	
	private final Integer value;
	
	private Exteriors(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public static Exteriors fromValue(Integer value) {
		 for (Exteriors status : Exteriors.values()) {
	            if (status.getValue() == value) {
	                return status;
	            }
	        }
		 return null;
	}
}
