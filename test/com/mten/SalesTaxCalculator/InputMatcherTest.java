package com.mten.SalesTaxCalculator;

import java.util.ArrayList;

import junit.framework.TestCase;

public class InputMatcherTest extends TestCase {
	@SuppressWarnings("unused")
	private String input_1;
	@SuppressWarnings("unused")
	private String input_2;
	@SuppressWarnings("unused")
	private String broken_floater;
	@SuppressWarnings("unused")
	private String broken_integer;
	@SuppressWarnings("unused")
	private String reverso_input;
	@SuppressWarnings("unused")
	private InputMatcher im = new InputMatcher("Test");
	
	public void setup() {
		input_1 = "1 Imported Box of stuff 10.00";
		input_2 = "2 Things that smell 5.50";
		broken_floater = "2.00 that 5.50 smell";
		broken_integer = "2 imported 5 smell";
		reverso_input = "1.00 box of books 5";
	}

	//Constructor Test
	public void testInputMatcher() {
		InputMatcher im = new InputMatcher("Test");
		assertEquals( "Test", im.name);
		assertTrue( im instanceof InputMatcher);
		assertTrue( im.quantity instanceof ArrayList);
		assertTrue( im.price instanceof ArrayList);
		assertTrue( im.item instanceof ArrayList );
	}
	
	//Regular Expression input verification method
	public void testPriceFinder() {
		setup();
		assertEquals((float)10.00, im.priceFinder(input_1));
	}


}