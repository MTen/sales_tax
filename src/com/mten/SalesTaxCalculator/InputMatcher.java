package com.mten.SalesTaxCalculator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@SuppressWarnings("unused")
public class InputMatcher {
	
	
	
	
	
	
	//// FILE IS DEPRECITATED  -- STRICTLY FOR REFERENCE.
	
	
	
	
	
	////////////////////////
	//	Fields package private
	////////////////////////
	String name;
	
	////////////////////////
	//	Constructor
	////////////////////////
		//InputMatcher is a concrete class in case different versions of 
		//the matcher need to exist. (Annually updated, change of business, etc)
	public InputMatcher(String name) {
		this.name = name;
	}
	
	////////////////////////
	//	Methods
	////////////////////////
	
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
			return me.get(0);
		} else {
			return "Please enter units as whole numbers and price with exact change. (i.e. 1 box of stuff 5.50)";
		}
	}
	
	public String unitFinder(String userInput) {
		
		//Splitting the userInput on the spaces to capture first value
		
		//Match less than 1 or equal to white space characters or beginning of line. 1 or more digit characters. 
		//Match one or more whitespace character or end of line character 
		String integer_regex = "(?<=\\s|^)\\d+(?=\\s|$)";
		ArrayList<String> me = matcherEngine(integer_regex, userInput);
		String[] inputSplitUp = userInput.split("\\s+");
		Boolean unit_location_check = me.get(0).equals(inputSplitUp[0]);

		if (me.size() == 1 && unit_location_check) {
			return me.get(0);
		} else {
			return "Please enter units as whole numbers and price with exact change. (i.e. 1 box of stuff 5.50)";
		}	
		
	}
	
	//Searches user input for only words comprised of letters
	public ArrayList<String> productArray(String userInput) {
		String word_regex = "[a-zA-Z]+";
		ArrayList<String> me = matcherEngine(word_regex, userInput);
		return me;
	}
	
	//Getting rid of the word at
	public String productFinder(ArrayList<String> productArray ){
		String productName = productArray.get(0);
		String word = "";
		for(int i = 1, end = productArray.size() - 1; i < end; i++ ) {
			word = productArray.get(i);
			productName += " " + word;
		}
		return productName;
	}
	
	
	// Evaluates the 
	public Batch evaluate(ArrayList<String> inputArray){
		//TODO create Batch object
		Batch b = new Batch();
		for(int i = 0, end = inputArray.size(); i < end; i++ ) {
			String item = inputArray.get(i);
			Transaction t = new Transaction( productFinder(productArray(item)), unitFinder(item), priceFinder(item));
			b.add(t);
		}
		return b;
	}
	
	// uses matcher engine w string to imported
	public Boolean verifyImported(String s) {
		String string = s.toLowerCase();
		if (matcherEngine("imported", string).contains("imported")) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}
	
	public ArrayList<String> exemptItems(){
		ArrayList<String> exemptItems = new ArrayList<String>(Arrays.asList("book", "pills", "chocolate", "chocolates")); 
		return exemptItems;
	}
	
	public Boolean checkExempt(String s) {
		String string = s.toLowerCase();
		ArrayList<String> exemptItems = exemptItems();
		ArrayList<String> productArray = productArray(string);
		Boolean result = false;
		for(int i = 0, end = productArray.size(); i < end; i++){
			String thisProduct = productArray.get(i);
			for (String x: exemptItems) {
				if (thisProduct.equals(x)) {
					System.out.println("Item is exempt");
					return true;
				}else{
					result = false;
				}
			}
		
		}
		System.out.println("Item is not exempt");
		return result;
	}
}