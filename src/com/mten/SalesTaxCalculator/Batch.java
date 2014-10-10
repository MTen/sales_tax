package com.mten.SalesTaxCalculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Batch {
	////////////////////////
	//	Fields
	////////////////////////
	
	String name;
	ArrayList<Transaction> transactions;
	
	////////////////////////
	//	Constructor
	////////////////////////
	
	public Batch() {
		Date d = new Date();
		name = "Batch: " + d;
		transactions = new ArrayList<Transaction>();
	}
	
	////////////////////////
	//	Methods
	////////////////////////
	
	//Helper method for the Inputmatcher.evaluate method
	public void add(Transaction t) {
		this.transactions.add(t);
	}
	
	public ArrayList<Transaction> getTransactions() {
		return this.transactions;
	}

	

	
	public String showOutput(){
		for(int i = 0; i < this.transactions.size(); i++){
			Transaction s = this.transactions.get(i);
			System.out.println(s.product + ": " + s.price);
			System.out.println(s.salesTaxActual);	
		}
		return null;
	}

}
