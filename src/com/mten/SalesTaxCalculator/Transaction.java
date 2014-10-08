package com.mten.SalesTaxCalculator;

public class Transaction {
	////////////////////////
	//	Fields
	////////////////////////
	
	String name;
	String product;
	String price;
	String salesTaxPercentage;
	String units;
	String salesTaxActual;
	String modifiedPrice;
	public Double taxRate;
	

	////////////////////////
	//	Constructor
	////////////////////////
	
	public Transaction(String product, String units, String price) {
		this.name = this.product = product;
		this.units = units;
		this.price = price;
		this.taxRate = 0.00;
	}


	public String getName() {
		return name;
	}


	public String getProduct() {
		return product;
	}


	public String getPrice() {
		return price;
	}


	public String getUnits() {
		return units;
	}



 
	
}
