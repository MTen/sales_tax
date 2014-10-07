package com.mten.SalesTaxCalculator;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class TransactionTest extends TestCase {
	////////////////////////
	//	Fields
	////////////////////////
	

	private String chocolates;
	private String units_1;
	private String price_10;
	private Transaction t;

	
	public void setup() {
		chocolates = "box of chocolates";
		units_1 = "1";
		price_10 = "10.00";
		t = new Transaction( chocolates, "1", price_10);
	}
	
	
	////////////////////////
	//	Constructor
	////////////////////////
	
	public void testTransaction() {
		setup();
		assertEquals( chocolates, t.product);
		assertEquals( t.product, t.name);
		assertEquals( units_1, t.units);
		assertEquals( price_10, t.price);
		assertTrue( t instanceof Transaction);
	}
	


}
