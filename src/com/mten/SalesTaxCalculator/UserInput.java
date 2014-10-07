package com.mten.SalesTaxCalculator;

import javax.lang.model.type.NullType;

public class UserInput {
	
	public String examine(String input) {
		if (input.length() == 0) {
			return "Can not be null or empty value, please try again";
		} else {
			return "ok";
		}
	}
	
	//Not sure how I can make the examine method parameters amorphous this is to prevent null input
	public String examine(NullType null_input) {
		return "Can not be null or empty value, please try again";
	}

}
