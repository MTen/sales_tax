package com.mten.SalesTaxCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class MyCalculator {

	
	public static Integer unitsToInteger(String string) {
		int units = Integer.parseInt(string);
		return units;
	}
	
	//Depreciated by usage of BigDecimal and round method.
	//Using BigDecimal because Java docs said that currency should never be cast in float or double.
	public static BigDecimal priceToBigDecimal(String string) {
		double d = Double.parseDouble(string);
		BigDecimal price = BigDecimal.valueOf(d).setScale(2);
		return price;
	}
	
	
	//Pulled from StackOverflow because I thought it as a more extendible and simpler solution than what I was writing
	//Takes a string for value, round takes actual input, increment determines .05,
	//mode determines if it needs to be used for UP or down or what not.
	public static BigDecimal round(BigDecimal value, BigDecimal increment,
            RoundingMode roundingMode) {
		
		// Signum checks to see if the number is greater than zero. Returns +1 if greater -1 for less than.
		if (increment.signum() == 0) {
			// 0 increment does not make much sense, but prevent division by 0
			return value;
		} else {
			BigDecimal divided = value.divide(increment, 0, roundingMode);
			BigDecimal result = divided.multiply(increment);
			return result;
    	}
	}

	public static BigDecimal multiplyPrice(String string1, String string2) {
		BigDecimal arg_1 = new BigDecimal(string1).setScale(2);
		System.out.println(arg_1);
		BigDecimal arg_2 = new BigDecimal(string2).setScale(2);
		System.out.println(arg_2);
		BigDecimal arg_3 = arg_1.multiply(arg_2);
		System.out.println(arg_3);
		BigDecimal result = round(arg_3, new BigDecimal("0.05"), RoundingMode.UP);
		System.out.println(result);
		return result;
	}
}
