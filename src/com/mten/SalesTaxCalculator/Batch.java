package com.mten.SalesTaxCalculator;

import java.util.Date;
import java.util.ArrayList;

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
	public void checkForStuff(){
		ArrayList<Transaction> stuff = this.getTransactions();
		for(int i = 0, end = stuff.size(); i < end; i++){
			System.out.println(stuff.get(i).getPrice());
		}
	}

}
