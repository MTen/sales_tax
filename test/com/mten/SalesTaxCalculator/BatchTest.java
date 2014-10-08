package com.mten.SalesTaxCalculator;

import org.junit.Assert;
import org.hamcrest.CoreMatchers;

import junit.framework.TestCase;

public class BatchTest extends TestCase {
	// Fields
	Batch b;
	Transaction t_1;
	Transaction t_2;
	
	public void setup(){
		b = new Batch();
		t_1 = new Transaction("Box of Chocolate", "1", "5.00");
		t_2 = new Transaction("Box of Books", "2", "10.00");
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
		for (int i = 0; i < b.transactions.size(); i++) {
			System.out.println(b.transactions.get(i).name);
		}
	}

}
