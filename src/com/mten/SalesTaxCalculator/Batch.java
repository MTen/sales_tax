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
	BigDecimal totalCost;
	BigDecimal totalTax;
	BigDecimal totalTaxes;
	
	////////////////////////
	//	Constructor
	////////////////////////
	
	public Batch() {
		name = "Batch: ";
		transactions = new ArrayList<Transaction>();
		totalCost = new BigDecimal("0").setScale(2);
		totalTax = new BigDecimal("0").setScale(2);
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
	
	public void setTaxes(){
		ArrayList<Transaction> stuff = this.getTransactions();
		for (int i = 0; i < stuff.size(); i++) {
			Transaction item = stuff.get(i);
			item.calculateTaxes();
		}
	}
	
	////////////////////////
	//	Total Cost
	////////////////////////
	
	public void totalCost(){
		totalCost = getTotalCost();
		for(int i = 0, end = this.transactions.size(); i < end; i++) {
			BigDecimal s = this.transactions.get(i).modifiedPrice;
			totalCost = totalCost.add(s);
		}
		setTotalCost(totalCost);
	}
	
	public BigDecimal getTotalCost() {
	return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	////////////////////////
	//	Total Taxes
	////////////////////////

	public void totalTaxes(){
		totalTaxes = getTotalTax();
		
		for(int i = 0, end = this.transactions.size(); i < end; i++) {
			BigDecimal s = this.transactions.get(i).salesTaxActual;
			totalTaxes = totalTaxes.add(s);
		}
		setTotalTax(totalTaxes);
	}
	
	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}
	
	

	public String getBatchName() {
		return name;
	}
	
	public void showOutput(){
		String outputName = getBatchName().replaceAll("\\bInput\\b | \\binput\\b", "Output ");
		System.out.println(outputName);
		for(int i = 0; i < this.transactions.size(); i++){
			Transaction s = this.transactions.get(i);
			System.out.println(s.units + s.product + ": " + s.modifiedPrice);
		}
		System.out.println("Sales Taxes: " + getTotalTax());
		System.out.println("Total Cost: " + getTotalCost());
	}
	
	
	////////////////////////
	//	Output & Helpers
	////////////////////////

	public void batchTaxesandShowOutput(Batch b){	
			b.setTaxes();
			//Now the batch wants to show off all its spiffy info
			b.totalCost();
			b.totalTaxes();
			b.showOutput();
	}
	
}
