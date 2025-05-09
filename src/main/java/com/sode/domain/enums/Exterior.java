package com.sode.domain.enums;

public enum Exterior {
	
	FACTORY_NEW(0),
	MINIMAL_WEAR(1),
	FIELD_TESTED(2),
	WELL_WORN(3),
	BATTLE_SCARRE(4);
	
	private final Integer value;
	
	private Exterior(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public static Exterior fromValue(Integer value) {
		 for (Exterior status : Exterior.values()) {
	            if (status.getValue() == value) {
	                return status;
	            }
	        }
		 return null;
	}
}
