package com.sode.domain.enums;

public enum Qualities {
	BASE(1), CLASSIFIED(2), CONSUMER(3), COVERT(4), EXTRAORDINARY(5), GRADE(6), INDUSTRIAL(7), MIL_SPEC(8),
	REMARKABLE(9), RESTRICTED(10), CONTRABAND(11), RARE_SPECIAL_ITEM(12);

	private final Integer value;

	private Qualities(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static Qualities fromValue(Integer value) {
		for (Qualities status : Qualities.values()) {
			if (status.getValue() == value) {
				return status;
			}
		}
		return null;
	}
}
