package com.mten.SalesTaxCalculator;

import javax.lang.model.type.NullType;

import junit.framework.TestCase;

public class UserInputTest extends TestCase {
	
	////////////////////////
	//	Fields
	////////////////////////
	String input_1;
	String input_2;
	String input_3;
	UserInput ui;
	NullType null_input;
	String empty_input;
	String ERROR_MESSAGE;
	String result;
	
	////////////////////////
	//	Setup
	////////////////////////
	public void setup(){
		input_1 = "1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85";
		input_2 = "1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50";
		input_3 = "1 imported bottle of perfume at 27.99\n1 bottle of perfume at 18.99\n1 packet of headache pills at 9.75\n1 box of imported chocolates at 11.25";
		null_input = null;
		empty_input = "";
		ERROR_MESSAGE = "Cannot be null or empty value, please try again";
		ui = new UserInput();
		result = "";
	}
	
	////////////////////////
	//	Constructor
	////////////////////////
	public void testUserInput() {
		setup();
		assertTrue( ui instanceof UserInput);
	}
	
	////////////////////////
	//	Methods
	////////////////////////
	
	public void testNullInput() { 
		setup();
		result = ui.examine(null_input);
		assertEquals(ERROR_MESSAGE, result);
	}
	
	public void testEmptyInput() {
		setup();
		result = ui.examine(empty_input);
		assertEquals(ERROR_MESSAGE, result);
	}
	
	public void testNormalInput() {
		setup();
		result = ui.examine(input_1);
		assertEquals("ok", result);
	}
	
	
}
