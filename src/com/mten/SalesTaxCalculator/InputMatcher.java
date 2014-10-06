package com.mten.SalesTaxCalculator;

import java.util.ArrayList;

public class InputMatcher {
	//Fields package private
	String name;
	ArrayList<Integer> quantity;
	ArrayList<Float> price;
	ArrayList<String> item;
	
	//Constructor
		//InputMatcher is a concrete class in case different versions of the matcher need to exist. (Annually updated, change of business, etc)
	public InputMatcher(String name) {
		this.name = name;
		quantity = new ArrayList<Integer>();
		price = new ArrayList<Float>();
		item = new ArrayList<String>();
		
	}
	
	
	
	
	
}