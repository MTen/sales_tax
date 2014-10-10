package com.mten.SalesTaxCalculator;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class AbsInputMatcher {


		////////////////////////
		//	Fields package private
		////////////////////////
		String name;
		
		////////////////////////
		//	Constructor
		////////////////////////
			//InputMatcher is a concrete class in case different versions of 
			//the matcher need to exist. (Annually updated, change of business, etc)
		public void InputMatcher(String name) {
			this.name = name;
		}
		
		////////////////////////
		//	Methods
		////////////////////////
		
		//Takes Regular Expression and string pattern and returns an array of results.
		public static ArrayList<String> matcherEngine(String regex, String user_input) {
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
		public static String priceFinder(String userInput) {
			//
			String float_regex = "\\d*\\.+\\d*";
			ArrayList<String> me = matcherEngine(float_regex, userInput);
			
			String[] inputSplitUp = userInput.split("\\s+");
			int lastInput = inputSplitUp.length - 1;
			Boolean price_location_check = me.get(0).equals(inputSplitUp[lastInput]);
			//Checks to make sure only one price is listed in the userInput
			if (me.size() == 1 && price_location_check) {
				System.out.println("price: " + me.get(0));
				return me.get(0);
			} else {
				return "Please enter units as whole numbers and price with exact change. (i.e. 1 box of stuff 5.50)";
			}
		}
		
		public static String unitFinder(String userInput) {
			
			//Splitting the userInput on the spaces to capture first value
			
			//Match less than 1 or equal to white space characters or beginning of line. 1 or more digit characters. 
			//Match one or more whitespace character or end of line character 
			String integer_regex = "(?<=\\s|^)\\d+(?=\\s|$)";
			ArrayList<String> me = matcherEngine(integer_regex, userInput);
			String[] inputSplitUp = userInput.split("\\s+");
			Boolean unit_location_check = me.get(0).equals(inputSplitUp[0]);

			if (me.size() == 1 && unit_location_check) {
				System.out.println("units: " + me.get(0));
				return me.get(0);
			} else {
				return "Please enter units as whole numbers and price with exact change. (i.e. 1 box of stuff 5.50)";
			}	
			
		}
		
		//Searches user input for only words comprised of letters
		public static ArrayList<String> productArray(String userInput) {
			String word_regex = "[a-zA-Z]+";
			ArrayList<String> me = matcherEngine(word_regex, userInput);
			return me;
		}
		
		//Getting rid of the word at and constructs a product name string from the productArray method
		public static String productFinder(ArrayList<String> productArray ){
			String productName = productArray.get(0);
			String word = "";
			for(int i = 1, end = productArray.size() - 1; i < end; i++ ) {
				word = productArray.get(i);
				productName += " " + word;
			}
			return productName;
		}
		
		
		// Evaluates the parsed input array and creates a batch of transactions.
		public static Batch evaluate(ArrayList<String> productArray){
			Batch b = new Batch();
			for(int i = 0, end = productArray.size(); i < end; i++ ) {
				String item = productArray.get(i);
				Transaction t = new Transaction( productFinder(productArray(item)), unitFinder(item), priceFinder(item));
				b.add(t);
			}
			return b;
		}
		
		public static Boolean checkImported(String s){
				String string = s.toLowerCase();
				ArrayList<String> exemptItems = new ArrayList<String>(Arrays.asList("imported"));
				ArrayList<String> productArray = productArray(string);
				Boolean result = false;
				for(int i = 0, end = productArray.size(); i < end; i++){
					String thisProduct = productArray.get(i);
					for (String x: exemptItems) {
						if (thisProduct.equals(x)) {
							result = true;
							return true;
						}
					}
				
				}
				return result;
			}

		//Array of known exempt items instead of interacting with a Nonrelational database to give this application some kind of persistence.
		public static ArrayList<String> exemptItems(){
			ArrayList<String> exemptItems = new ArrayList<String>(Arrays.asList("book", "pills", "chocolate", "chocolates")); 
			return exemptItems;
		}

		// I would want to optimize this in the future - right now it takes the product name converts it to an array, compares the smaller
		// array of product name to the potentially much larger array of known items. If I was to re-factor this I would test this against a
		// super long string of known items and use regex to search that string. 
		
		// Or if I was to continue with the arrays I could split the prodcut word and get the first letter from the string and use that as 
		// a key for arrays that only hold words starting with 
		
		// Another optimization would be to delete any words from the product array that are less than two or three characters before comparing.
		// or if there was an exempt item with only three letters (which would be a very short list) compare those before deleting.
		
		// Another optimization in Ruby I believe there is a method where you can "pluck" items out of an array that meet specific criteria and is
		// supposed to be very fast. I would call length on the string use that as the pluck comparison which would provide an array of only x number 
		// of letters ( i.e. the word item_length = "cheese".length(); Array.pluck(//words that are item_length_long); then do compare.

		public static Boolean checkExempt(String s) {
			String string = s.toLowerCase();
			ArrayList<String> exemptItems = exemptItems();
			ArrayList<String> productArray = productArray(string);
			Boolean result = false;
			for(int i = 0, end = productArray.size(); i < end; i++){
				String thisProduct = productArray.get(i);
				for (String x: exemptItems) {
					if (thisProduct.equals(x)) {
						result = true;
						return true;
					}
				}
			
			}
			return result;
		}
	}


