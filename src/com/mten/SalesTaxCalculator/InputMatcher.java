package com.mten.SalesTaxCalculator;

import java.util.ArrayList;
import java.util.Arrays;
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

	//If matcherEngine finds only one price and only one unit quantity entry
	//and both are in the correct location. (following syntax) then I don't 
	//need to create a separate method to check for price being a INT and unit being a float explictly.
	
	//Invokes matcher engine to find prices listed as floats.
	public String priceFinder(String userInput) {
		//
		String float_regex = "\\d*\\.+\\d*";
		ArrayList<String> me = matcherEngine(float_regex, userInput);
		
		String[] inputSplitUp = userInput.split("\\s+");
		int lastInput = inputSplitUp.length - 1;
		Boolean price_location_check = me.get(0).equals(inputSplitUp[lastInput]);
		//Checks to make sure only one price is listed in the userInput
		if (me.size() == 1 && price_location_check) {
			System.out.println("TRUE");
			return me.get(0);
		} else {
			System.out.println("Please enter units as whole numbers and price with exact change. (i.e. 1 box of stuff 5.50)");
			return "Please enter units as whole numbers and price with exact change. (i.e. 1 box of stuff 5.50)";
		}
	}
	
	public String unitFinder(String userInput) {
		
		// Splitting the userInput on the spaces to capture first value
		String[] inputSplitUp = userInput.split("\\s+");
		int lastInput = inputSplitUp.length;
		Boolean unit_float_check = me.get(0).equals(inputSplitUp[0]);
		return "Error Message";
	}
		
}