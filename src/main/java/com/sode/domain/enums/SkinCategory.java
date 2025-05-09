package com.sode.domain.enums;

public enum SkinCategory {
	NORMAL(1),
	STATTRAK(2),
	KNIFE(3),
	GLOVES(4);
	
	private final Integer value;
	
	private SkinCategory(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public static SkinCategory fromValue(Integer value) {
		 for (SkinCategory status : SkinCategory.values()) {
	            if (status.getValue() == value) {
	                return status;
	            }
	        }
		 return null;
	}
}
