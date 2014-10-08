package com.mten.SalesTaxCalculator;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class InputMatcherTest extends TestCase {
	////////////////////////
	//	Fields
	////////////////////////
	
	private String input_1;
	private String input_2;
	private String broken_floater;
	private String broken_integer;
	private String reverso_input;

	private ArrayList<String> myArray;
	private ArrayList<String> userInput;
	private Boolean result;
	private String price;
	private String units;
	private String price_1;
	private String price_2;
	private String ERROR_MESSAGE;
	private String float_regex;
	private String integer_regex;
	private String word_regex;
	private ArrayList<String> split_input_1;
	private InputMatcher im = new InputMatcher("Test");
	
	
	//////////////
	//Test Setup//
	//////////////
	
	public void setup() {
		price_1 = "10.00";
		price_2 = "5.55";
		input_1 = "1 Imported Box of stuff at 10.00";
		input_2 = "2 Things that smell at 5.55";
		broken_floater  = "2.00 that smell at 5.55 ";
		broken_integer = "2 imported smell at 5 ";
		reverso_input = "1.00 box of books at 5";
		split_input_1 = new ArrayList<String>(Arrays.asList( "1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85"));
		float_regex= "\\d*\\.+\\d*";
		integer_regex= "(?<=\\s|^)\\d+(?=\\s|$)";
		word_regex="[a-zA-Z]+";
		myArray = new ArrayList<String>();
		userInput = new ArrayList<String>();
		result = null;
		price = null;
		units = null;
		ERROR_MESSAGE = "Please enter units as whole numbers and price with exact change. (i.e. 1 box of stuff 5.50)";
	}

	////////////////////////
	//	Constructor Test
	////////////////////////
	
	public void testInputMatcher() {
		setup();
		assertEquals( "Test", im.name);
		assertTrue( im instanceof InputMatcher);
	}
	
	//Regular Expression input verification method
	
	////////////////////////
	//	Floats
	////////////////////////
	
	public void testMatcherEngine_Floats() {
	// Was getting stuck on testing arrays so this is my hack solution.
		
	//Single Float Test with zeros after decimal
		setup();
		myArray.add(price_1);
		userInput = im.matcherEngine(float_regex, input_1);
		
		result = userInput.equals(myArray);
		assertTrue(result);
		
	//Single Float Test with numbers after decimal
		setup();
		myArray.add(price_2);
		userInput = im.matcherEngine(float_regex, input_2);
		
		result = userInput.equals(myArray);
		assertTrue(result);
		
	//Test out of order input
		setup();
		myArray.add("1.00");
		userInput = im.matcherEngine(float_regex, reverso_input);
		
		result = userInput.equals(myArray);
		assertTrue(result);
		
	//Double Float Test
		setup();
		myArray.add("2.00"); myArray.add(price_2);
		userInput = im.matcherEngine(float_regex, broken_floater);
		
		result = userInput.equals(myArray);
		assertTrue(result);
		
	//Double Integer Test
		setup();
		//Nothing added to myArray
		userInput = im.matcherEngine(float_regex, broken_integer);
		
		result = userInput.equals(myArray);
		assertTrue(result);
	}
	
	////////////////////////
	//	priceFinder
	////////////////////////
	
	public void testPriceFinder() {
	
		//Single Float Test with zeros after decimal
		setup();
		myArray.add(price_1);
		price = im.priceFinder(input_1);
		
		result = price.equals(myArray.get(0));
		assertTrue(result);
		
		//Double float test
		setup(); 
		myArray.add("2.00"); myArray.add("5.50");
		price = im.priceFinder(broken_floater);
		assertEquals(ERROR_MESSAGE, price);
		
		//Reversed input
		setup();
		price = im.priceFinder(reverso_input);
		assertEquals(ERROR_MESSAGE, price);
	}
	
	
	////////////////////////
	//	Integers
	////////////////////////
	
	public void testMatcherEngine_Ints(){

	//Single Float Test with numbers after decimal
		setup();
		myArray.add("1");
		userInput = im.matcherEngine(integer_regex, input_1);
		result = userInput.equals(myArray);
		assertTrue(result);
		
	//Single Float Test with numbers after decimal
		setup();
		myArray.add("2");
		userInput = im.matcherEngine(integer_regex, input_2);
	
		result = userInput.equals(myArray);
		assertTrue(result);
		
	////////////////////////
	//	unitFinder
	////////////////////////
	
	//Single Float Test with zeros after decimal
		setup();
		myArray.add("1");
		units = im.unitFinder(input_1);
		
		result = units.equals(myArray.get(0));
		assertTrue(result);
	
	//Double integer test
		setup(); 
		myArray.add("2"); myArray.add("5");
		price = im.unitFinder(broken_integer);
		assertEquals(ERROR_MESSAGE, price);
		
	//Reversed input
		setup();
		price = im.unitFinder(reverso_input);
		assertEquals(ERROR_MESSAGE, price);
	}
	
	
	public void testProductArray(){
		setup();
		String[] inputSplit = "Imported Box of stuff at".split("\\s+");
		myArray = new ArrayList<String>(Arrays.asList(inputSplit));
		userInput = (im.productArray(input_1));
		result = userInput.equals(myArray);
		assertTrue(result);
	}

	public void testEvaluate(){
		setup();
		
	}

}