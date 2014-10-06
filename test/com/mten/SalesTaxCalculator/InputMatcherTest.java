package com.mten.SalesTaxCalculator;

import java.util.ArrayList;
import junit.framework.TestCase;

public class InputMatcherTest extends TestCase {
	private String input_1;
	private String input_2;
	private String broken_floater;
	private String broken_integer;
	private String reverso_input;

	private String float_regex;
	private ArrayList<String> myArray;
	private ArrayList<String> userInput;
	private Boolean result;
	private String price;
	private String price_1;
	private String price_2;
	
	private InputMatcher im = new InputMatcher("Test");
	
	public void setup() {
		price_1 = "10.00";
		input_1 = "1 Imported Box of stuff 10.00";
		input_2 = "2 Things that smell 5.55";
		broken_floater  = "2.00 that 5.50 smell";
		broken_integer = "2 imported 5 smell";
		reverso_input = "1.00 box of books 5";
		float_regex= "\\d*\\.+\\d*";
		myArray = new ArrayList<String>();
		userInput = new ArrayList<String>();
		result = null;
		price = null;
	}

	public void log(ArrayList<String> myArray2 ){
		System.out.println(myArray2);
	}

	//Constructor Test
	public void testInputMatcher() {
		setup();
		assertEquals( "Test", im.name);
		assertTrue( im instanceof InputMatcher);
		assertTrue( im.quantity instanceof ArrayList);
		assertTrue( im.price instanceof ArrayList);
		assertTrue( im.item instanceof ArrayList );
	}
	
	//Regular Expression input verification method
	
	//Floats
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
		myArray.add("5.55");
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
		myArray.add("2.00"); myArray.add("5.50");
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
	
	public void testPriceFinder() {
		setup();
		myArray.add(price_1);
		price = im.priceFinder(input_1);
		
		result = price.equals(myArray.get(0));
		assertTrue(result);
		
		
	}
	
	public void testMatcherEngine_Ints(){
		setup();
		myArray.add("1");
		//userInput = im.matcherEngine(int_regex, input_1);
		
	
		result = userInput.equals(myArray);
		//assertTrue(result);
		
//Single Float Test with numbers after decimal
		setup();
		myArray.add("2");
		//userInput = im.matcherEngine(int_regex, input_2);
	}
	



}