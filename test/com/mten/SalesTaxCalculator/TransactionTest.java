package com.mten.SalesTaxCalculator;

import java.math.BigDecimal;

import junit.framework.TestCase;

public class TransactionTest extends TestCase {
	////////////////////////
	//	Fields
	////////////////////////
	

	private String chocolates;
	private String units_1;
	private String price_10;
	private String price_1013;
	Transaction t;
	Integer unit_test;
	BigDecimal price_test;
	BigDecimal tax_rate;
	BigDecimal test_100;
	BigDecimal test_10130;

	
	public void setup() {
		chocolates = "box of chocolates";
		units_1 = "1";
		price_10 = "10.00";
		price_1013 = "10.13";
		unit_test = 1;
		price_test = new BigDecimal(10.00).setScale(2);
		test_100 = new BigDecimal(100.00).setScale(2);
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
	
	////////////////////////
	//	Calculator Methods
	////////////////////////
	
	//helper method
	public BigDecimal bd(String string){
		return new BigDecimal(string);
	}
	
	public void testUnitsToInteger(){
		setup();
		assertEquals(unit_test, MyCalculator.unitsToInteger(units_1));
	}
	
	public void testPriceToDouble(){
		setup();
		BigDecimal price_result = MyCalculator.priceToBigDecimal(price_10);
		assertEquals(price_test, price_result);
	}
	
	public void testMyCalculatorMultiplyDouble() {
		setup();
		BigDecimal float_result = MyCalculator.multiplyPrice(price_10, price_10);
		System.out.println(float_result);
		assertEquals(bd("100.00"), float_result);
		
		setup();
		BigDecimal by_ten_result = MyCalculator.multiplyPrice(price_1013, price_10);
		System.out.println(by_ten_result);
		assertEquals(bd("101.30"), by_ten_result);
		
		setup();
		BigDecimal by_1013_result = MyCalculator.multiplyPrice(price_1013, price_1013);
		System.out.println(test_10130);
		assertEquals(bd("102.65"), by_1013_result);
		
	}
	
}
