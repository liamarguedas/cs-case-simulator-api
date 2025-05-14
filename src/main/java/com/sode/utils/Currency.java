package com.sode.utils;

import java.util.Random;

public class Currency {
	
	public static double generateRandomPrice(double min, double max) {
		Random ran = new Random();
		return min + (max - min) * ran.nextDouble();
	}

}
