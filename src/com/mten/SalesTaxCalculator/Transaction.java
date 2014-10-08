package com.mten.SalesTaxCalculator;

public class Transaction {
	////////////////////////
	//	Fields
	////////////////////////
	
	String name;
	String product;
	String quantity;
	String price;
	String salesTaxPercentage;
	String units;
	String salesTaxActual;
	String modifiedPrice;
	

	////////////////////////
	//	Constructor
	////////////////////////
	
	public Transaction(String product, String units, String price) {
		this.name = this.product = product;
		this.units = units;
		this.price = price;
	}


	public void setProduct(String product) {
		// TODO Auto-generated method stub
	}


 
	
}
