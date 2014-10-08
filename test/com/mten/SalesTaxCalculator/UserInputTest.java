package com.mten.SalesTaxCalculator;

import java.util.ArrayList;
import java.util.Arrays;

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
	ArrayList<String> split_input_1;
	
	////////////////////////
	//	Setup
	////////////////////////
	public void setup(){
		input_1 = "1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85";
		input_2 = "1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50";
		input_3 = "1 imported bottle of perfume at 27.99\n1 bottle of perfume at 18.99\n1 packet of headache pills at 9.75\n1 box of imported chocolates at 11.25";
		split_input_1 = new ArrayList<String>(Arrays.asList( "1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85"));
		null_input = null;
		empty_input = "";
		ERROR_MESSAGE = "Can not be null or empty value, please try again";
		ui = new UserInput();
		result = "";
	}
	
	////////////////////////
	//	Constructor
	////////////////////////
	public void testUserInput() {
		setup();
		assertTrue( ui instanceof UserInput);
		assertEquals(0, ui.starting.length());
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
	
	public void testSetInput() {
		setup();
		ui.setInput(input_1);
		assertEquals(input_1, ui.starting);
	}
	
	public void testInputParser() {
		setup();
		ui.setInput(input_1);
		ArrayList<String> result = ui.inputParser(ui.starting);
		assertEquals(result, split_input_1);
	}
	
	public void testSetInputArray() {
		setup();
		ui.setInputArray(input_1);
		ArrayList<String> result = split_input_1;
		assertEquals(result, ui.inputArray);
	}

}
