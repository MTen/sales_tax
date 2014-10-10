package com.mten.SalesTaxCalculator;

import java.math.BigDecimal;

public class Transaction {
	////////////////////////
	//	Fields
	////////////////////////
	
	String name;
	String product;
	BigDecimal price;
	BigDecimal taxRate;
	String units;
	BigDecimal salesTaxActual;
	BigDecimal modifiedPrice;
	boolean imported;
	boolean exempt;
	

	////////////////////////
	//	Constructor
	////////////////////////
	
	public Transaction(String product, String units, String price) {
		this.name = product;
		this.product = product;
		this.units = units;
		this.price = new BigDecimal(price).setScale(2);
		this.imported = false;
		this.exempt = false;
		this.taxRate = new BigDecimal("0.00").setScale(2);
	}

	////////////////////////
	//	Getter & Setter
	////////////////////////

	public String getName() {
		return name;
	}


	public String getProduct() {
		return product;
	}


	public  BigDecimal getPrice() {
		return price;
	}


	public String getUnits() {
		return units;
	}

	////////////////////////
	//	Methods
	////////////////////////

	public void setExemptAndImported(){
		String p = this.product;
		if (AbsInputMatcher.checkExempt(p) == true) {
			this.exempt = true;
		}
		if (AbsInputMatcher.checkImported(p) == true){
			this.imported = true;
		}
	}
		
	public void setTaxRate() {
		if (this.exempt == false) {
			this.taxRate = this.taxRate.add(new BigDecimal("0.10"));
		}
		if (this.imported == true) {
			this.taxRate = this.taxRate.add(new BigDecimal("0.05"));
		}
	}

	//MAIN METHOD
	public void calculateTaxes() {
		this.setExemptAndImported();
		this.setTaxRate();
		BigDecimal t = this.taxRate;
		BigDecimal p = this.price;
		this.salesTaxActual = MyCalculator.multiplyTax(t, p);
		this.addTaxToPrice(); 
	}


	public void addTaxToPrice() {
		BigDecimal t = this.salesTaxActual;
		BigDecimal p = this.price;
		this.modifiedPrice = p.add(t);
	}

 
	
}
