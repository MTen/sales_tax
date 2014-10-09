package com.mten.SalesTaxCalculator;

import java.util.ArrayList;
import java.util.Arrays;

	public class MyPlayground {
		@SuppressWarnings("unused")
		public static void main(String[] args) throws Exception{
			
			// Using this as my "scratch pad"
			InputMatcher im = new InputMatcher("Test");
			UserInput ui = new UserInput();
			
//			String stuff = im.priceFinder("1 stuff 5.00");
			String userInput = "";
//			im.unitFinder(userInput);
			
			System.out.println("");

			String input_1 = "1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85";
			ArrayList<String> split_input_1 = new ArrayList<String>(Arrays.asList( "1 Imported book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85"));
			String input_3 = "1 imported bottle of perfume at 27.99" + "1 bottle of perfume at 18.99" + "1 packet of headache pills at 9.75" + "1 box of imported chocolates at 11.25";
			
			MyCalculator.priceToBigDecimal("1.00");
			//System.out.println(MyCalculator.multiplyPrice("10.13", "10.13"));
			
			Batch thing = im.evaluate(split_input_1);
			thing.getTransactions();
			thing.checkForImported(im); //need to pass the InputMatcher object for method to work.
			thing.showOutput();
		} 
	}