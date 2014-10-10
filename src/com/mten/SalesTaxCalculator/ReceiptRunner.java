package com.mten.SalesTaxCalculator;


public abstract class ReceiptRunner {
	UserInput ui = new UserInput();
	
	public static void showTime(Batch b){
		b.setTaxes();
		b.totalCost();
		b.totalTaxes();
		//Now the batch wants to show off all its spiffy info
		b.showOutput();
		System.out.println("");
	}

}
	
	
	
	

	



