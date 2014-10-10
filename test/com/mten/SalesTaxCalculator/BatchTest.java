package com.mten.SalesTaxCalculator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.hamcrest.CoreMatchers;

import junit.framework.TestCase;

public class BatchTest extends TestCase {
	// Fields
	Batch b;
	Transaction t_1;
	Transaction t_2;
	String i_1;
	String input_1;
	String input_2;
	String input_3;
	UserInput ui;
	
	public void setup(){
		b = new Batch();
		t_1 = new Transaction("Box of Chocolate", "1", "5.00");
		t_2 = new Transaction("Box of Books", "2", "10.00");
		i_1 = "Input 1:\n1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85";
		ui = new UserInput();
		input_1 = "\nInput 1:\n1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85\n";
		input_2 = "\nInput 2:\n1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50\n";
		input_3 = "\nInput 3:\n1 imported bottle of perfume at 27.99\n1 bottle of perfume at 18.99\n1 packet of headache pills at 9.75\n1 box of imported chocolates at 11.25\n";

	}
	public void helperSetup(String input, Batch b){
		//UserInput OBJECT accepts input and adds it to the UI object
		//Abstract Input Matcher examines UserIput and creates a batch object with baby transactions.
		//Transaction class comes in and is all like dood I R GUNNA calculates stuff using the Abstract Calculator thingy.
		ui.initiate(input);
		b = AbsInputMatcher.evaluate(ui.inputArray);
		b.setTaxes();
	}
	
	public void testBatch() {
		setup();
		Assert.assertThat(b.name, CoreMatchers.containsString("Batch"));
		assertTrue( b instanceof Batch);
	}
	
	public void testAdd(){
		setup();
		b.add(t_1);
		assertEquals(1, b.transactions.size());
		b.add(t_2);
		System.out.println(b.name);
		assertEquals(2, b.transactions.size());
	}
	
//	public void testOutput(){
//		String result = b.output();
//		
//		assertEquals(
//				"1 book : 12.49 \n 1 music CD: 16.49\n1 chocolate bar: 0.85\nSales Taxes: 1.50\nTotal: 29.83",
//				result
//				);
//	}
	
	public void testTotalCost() {
		setup();
		helperSetup(input_1, b);
		System.out.println(b.transactions);
		b.totalCost();
		assertEquals(new BigDecimal("0.00"), b.totalCost);
	}

}
