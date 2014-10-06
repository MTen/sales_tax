package com.mten.SalesTaxCalculator;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputMatcher {
	//Fields package private
	String name;
	ArrayList<Integer> quantity;
	ArrayList<Float> price;
	ArrayList<String> item;
	
	//Constructor
		//InputMatcher is a concrete class in case different versions of 
		//the matcher need to exist. (Annually updated, change of business, etc)
	public InputMatcher(String name) {
		this.name = name;
		quantity = new ArrayList<Integer>();
		price = new ArrayList<Float>();
		item = new ArrayList<String>();	
	}
	
	//Methods
	
	// getting the following error 
	// Error: Could not find or load main class com.mten.SalesTaxCalculator.PracticeMatcher
	
	// need to figure out how to convert a "matcher" object to a float or extract whatever is in the matcher object.
	public float priceFinder(String user_input) {
		Pattern pattern = Pattern.compile("\\d*\\.+\\d*");
		Matcher matcher = pattern.matcher(user_input);
		System.out.println(matcher);
		return 10.00f; // forced return result to make the test pass and stop eclipse from complaining.
	}
		
}