package com.mten.SalesTaxCalculator;

import java.math.BigDecimal;
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
	public void checkForImported(InputMatcher im){
		ArrayList<Transaction> stuff = this.getTransactions();
		for(int i = 0, end = stuff.size(); i < end; i++){
			String p = stuff.get(i).getProduct();
			verifyImported(im, p);
		}
	}
	
	public Boolean verifyImported(InputMatcher im,String s) {
		String string = s.toLowerCase();
		if (im.matcherEngine("imported", string).contains("imported")) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}
	
	public String showOutput(){
		for(int i = 0; i < this.transactions.size(); i++){
			Transaction s = this.transactions.get(i);
			System.out.println(s.product + ": " + s.price);
			System.out.println(s.salesTaxActual);
			
			
		}
		return null;
	}
//	public Boolean checkExempt(InputMatcher im,String s) {
//		String string = s.toLowerCase();
//		//case statement
//		switch(im.matcherEngine("\""+ statement +"\"", string).contains(statement)){
//		when(statement)
//		case:
//		
//		}
//		//TODO need to write Exempt case logic 
//		return false;
//	}
	

}
