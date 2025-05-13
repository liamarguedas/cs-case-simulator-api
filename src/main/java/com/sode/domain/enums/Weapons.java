package com.sode.domain.enums;

public enum Weapons {

	CZ75_AUTO(1), DESERT_EAGLE(2), DUAL_BERETTAS(3), FIVE_SEVEN(4), GLOCK_18(5), P2000(6), P250(7), R8_REVOLVER(8),
	TEC_9(9), USP_S(10), AK_47(11), AUG(12), AWP(13), FAMAS(14), G3SG1(15), GALIL_AR(16), M4A1_S(17), M4A4(18),
	SCAR_20(19), SG_553(20), SSG_08(21), MAC_10(22), MP5_SD(23), MP7(24), MP9(25), PP_BIZON(26), P90(27), UMP_45(28),
	MAG_7(29), NOVA(30), SAWED_OFF(31), XM1014(32), M249(33), NEGEV(34), BAYONET(35), BOWIE_KNIFE(36),
	BUTTERFLY_KNIFE(37), CLASSIC_KNIFE(38), FALCHION_KNIFE(39), FLIP_KNIFE(40), GUT_KNIFE(41), HUNTSMAN_KNIFE(42),
	KARAMBIT(43), KUKRI_KNIFE(44), M9_BAYONET(45), NAVAJA_KNIFE(46), NOMAD_KNIFE(47), PARACORD_KNIFE(48),
	SHADOW_DAGGERS(49), SKELETON_KNIFE(50), STILETTO_KNIFE(51), SURVIVAL_KNIFE(52), TALON_KNIFE(53), URSUS_KNIFE(54),
	ZEUS_X27(55);

	private final Integer value;

	private Weapons(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static Weapons fromValue(Integer value) {
		for (Weapons status : Weapons.values()) {
			if (status.getValue() == value) {
				return status;
			}
		}
		return null;
	}

	public String getDisplayName() {
		String[] parts = this.name().split("_");
		StringBuilder display = new StringBuilder();
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			if (part.matches("^[A-Z0-9]+$")) {
				display.append(part.charAt(0)).append(part.substring(1).toLowerCase());
			} else {
				display.append(part.substring(0, 1).toUpperCase()).append(part.substring(1).toLowerCase());
			}
			if (i < parts.length - 1) {
				display.append(" ");
			}
		}
		return display.toString();
	}
}
