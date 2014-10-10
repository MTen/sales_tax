package com.mten.SalesTaxCalculator;

import org.junit.Assert;
import org.hamcrest.CoreMatchers;

import junit.framework.TestCase;

public class BatchTest extends TestCase {
	// Fields
	Batch b;
	Transaction t_1;
	Transaction t_2;
	String i_1;
	
	public void setup(){
		b = new Batch();
		t_1 = new Transaction("Box of Chocolate", "1", "5.00");
		t_2 = new Transaction("Box of Books", "2", "10.00");
		i_1 = "Input 1:\n1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85";
		
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
	
	public void testOutput(){
		String result = b.output();
		
		assertEquals(
				"1 book : 12.49 \n 1 music CD: 16.49\n1 chocolate bar: 0.85\nSales Taxes: 1.50\nTotal: 29.83",
				result
				);
	}

}
