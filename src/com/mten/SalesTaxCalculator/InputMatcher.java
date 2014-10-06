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
	
	// Takes Regular Expression and string pattern and returns an array of results.
	public ArrayList<String> matcherEngine(String regex, String user_input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user_input);
		ArrayList<String> matchesArray = new ArrayList<String>();
		
		while(matcher.find()) {
			matchesArray.add(matcher.group());
			//TODO	System.out.println(matchesArray);(Remove) Just a test aspect of the program to make sure everything is alright
		}
		return matchesArray;
	}

	public ArrayList<String> priceFinder(String userInput) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Need to figure out how to cast a "matcher" object to a float 
	// or extract whatever is in the matcher object.

//	public float priceFinder(String user_input) {
//		// regex to find float numbers ();
//		String float_finder = "\\d*\\.+\\d*";
//		matcherEngine(float_finder, user_input);
//		return 10.00f; // forced return result to make the test pass and stop eclipse from complaining.
//	}
		
}