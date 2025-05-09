package com.sode.domain.enums;

public enum Quality {
	BASE_GRADE(1), 
	CLASSIFIED(2),
	CONSUMER_GRADE(3),  
	COVERT(4),
	EXTRAORDINARY(5), 
	HIGH_GRADE(6),  
	INDUSTRIAL_GRADE(7),  
	MIL_SPEC_GRADE(8),  
	REMARKABLE(9),
	RESTRICTED(10);
	
private final Integer value;
	
	private Quality(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public static Quality fromValue(Integer value) {
		 for (Quality status : Quality.values()) {
	            if (status.getValue() == value) {
	                return status;
	            }
	        }
		 return null;
	}
	
}
