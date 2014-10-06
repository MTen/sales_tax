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
	
	//Takes Regular Expression and string pattern and returns an array of results.
	public ArrayList<String> matcherEngine(String regex, String user_input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user_input);
		ArrayList<String> matchesArray = new ArrayList<String>();
		
		while(matcher.find()) {
			matchesArray.add(matcher.group());
		}
		return matchesArray;
	}

	//Invokes matcher engine to find prices listed as floats.
	public String priceFinder(String userInput) {
		String float_regex = "\\d*\\.+\\d*";
		ArrayList<String> me = matcherEngine(float_regex, userInput);
		if (me.size() == 1 ) {
			return me.get(0);
		} else {
			return "ERROR_MESSAGE";
		}
	}
		
}