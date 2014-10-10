package com.mten.SalesTaxCalculator;

import java.math.BigDecimal;

import junit.framework.TestCase;

public class TransactionTest extends TestCase {
	////////////////////////
	//	Fields
	////////////////////////
	

	String units_1;
	String price_10;
	String price_1013;
	Transaction t;
	Transaction t2;
	Transaction t3;
	Transaction t4;
	Integer unit_test;
	BigDecimal price_test;
	BigDecimal tax_rate;
	BigDecimal test_100;
	BigDecimal test_10130;
	Transaction t1;
	String chocolates;
	


	
	public void setup() {
		chocolates = "box of chocolates";
		units_1 = "1";
		price_10 = "10.00";
		price_1013 = "10.13";
		unit_test = 1;
		price_test = new BigDecimal(10.00).setScale(2);
		test_100 = new BigDecimal(100.00).setScale(2);
		t = new Transaction( chocolates, "1", price_10);
		t1 = new Transaction( "Box of chocolate", "1", "14.00"); // 0.00 tax
		t2 = new Transaction( "Imported chocolates", "1", "14.00"); // 0.05 tax
		t3 = new Transaction( "Normal stuff", "1", "14.00"); // 0.10 tax
		t4 = new Transaction( "Imported stuff", "1", "14.00"); // 0.15 tax
	}
	
	
	////////////////////////
	//	Constructor
	////////////////////////
	
	public void testTransaction() {
		setup();
		assertEquals( chocolates, t.product);
		assertEquals( t.product, t.name);
		assertEquals( units_1, t.units);
		assertEquals( bd("10.00"), t.price);
		assertTrue( t instanceof Transaction);
	}
	
////////////////////////
//	Helper Methods
////////////////////////

	public BigDecimal bd(String string){
			return new BigDecimal(string);
		}
	
	public void addTaxRates(Transaction t){
		t.setExemptAndImported();
		t.setTaxRate();
	}
		
	
	////////////////////////
	//	Calculator Methods
	////////////////////////
	
	
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
		BigDecimal float_result = MyCalculator.multiplyTax(bd("10.00"), bd("10.00"));
		assertEquals(bd("100.00"), float_result);
		
		setup();
		BigDecimal by_ten_result = MyCalculator.multiplyTax(bd("10.13"), bd("10.00"));
		assertEquals(bd("101.30"), by_ten_result);
		
		setup();
		BigDecimal by_1013_result = MyCalculator.multiplyTax(bd("10.13"), bd("10.13"));
		assertEquals(bd("102.65"), by_1013_result);
		
	}
	
	public void testTransactionInspection() {
		setup();
		t1.setExemptAndImported();
		t1.setTaxRate();
		
		assertEquals(true, t1.exempt);
		assertEquals(false, t1.imported);
		assertEquals(bd("0.00"), t.taxRate);
		
		setup();
		t2.setExemptAndImported();
		t2.setTaxRate();
		
		assertEquals(true, t2.exempt);
		assertEquals(true, t2.imported);
		assertEquals(bd("0.05"), t2.taxRate);
		
		setup();
		t3.setExemptAndImported();
		t3.setTaxRate();
		
		assertEquals(false, t3.exempt);
		assertEquals(false, t3.imported);
		assertEquals(bd("0.10"), t3.taxRate);
		
		setup();
		
		t4.setExemptAndImported();
		t4.setTaxRate();

		assertEquals(false, t4.exempt);
		assertEquals(true, t4.imported);
		assertEquals(bd("0.15"), t4.taxRate);
	}
	
	public void testTransactionCalculateTaxRate() {
		setup();
		addTaxRates(t1);
		t1.calculateTaxes();
		assertEquals(bd("0.00"), t1.salesTaxActual);
	
		setup();
		addTaxRates(t2);
		t2.calculateTaxes(); // 14.00 * 0.05
		assertEquals(bd("0.70"), t2.salesTaxActual);
		
		setup();
		addTaxRates(t3);
		t3.calculateTaxes(); // 14.00 * 0.10
		assertEquals(bd("1.40"), t3.salesTaxActual);
		
		setup();
		addTaxRates(t4);
		t4.calculateTaxes(); // 14.00 * 0.10
		assertEquals(bd("2.10"), t4.salesTaxActual);	
	}
	
	public void testAddTaxToPrice() {
		setup();
		addTaxRates(t1);
		t1.calculateTaxes();
		t1.addTaxToPrice();
		assertEquals(bd("14.00"), t1.modifiedPrice);

		addTaxRates(t2);
		t2.calculateTaxes();
		t2.addTaxToPrice();
		assertEquals(bd("14.70"), t2.modifiedPrice);

		addTaxRates(t3);
		t3.calculateTaxes();
		t3.addTaxToPrice();		
		assertEquals(bd("15.40"), t3.modifiedPrice);
		
		addTaxRates(t4);
		t4.calculateTaxes();
		t4.addTaxToPrice();
		assertEquals(bd("16.10"), t4.modifiedPrice);
		
	}
	
}
