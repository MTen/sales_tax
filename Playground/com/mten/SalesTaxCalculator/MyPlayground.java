package com.mten.SalesTaxCalculator;

import java.util.ArrayList;
import java.util.Arrays;

	public class MyPlayground {
		@SuppressWarnings("unused")
		public static void main(String[] args) throws Exception{
			
			// Using this as my "scratch pad"
			UserInput ui = new UserInput();
			
//			String stuff = im.priceFinder("1 stuff 5.00");
			String userInput = "";
//			im.unitFinder(userInput);
			
			System.out.println("");


			ArrayList<String> split_input_1 = new ArrayList<String>(Arrays.asList( "1 Imported book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85"));
			String input_1 = "\nInput 1:\n1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85\n";
			String input_2 = "\nInput 2:\n1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50\n";
			String input_3 = "\nInput 3:\n1 imported bottle of perfume at 27.99\n1 bottle of perfume at 18.99\n1 packet of headache pills at 9.75\n1 box of imported chocolates at 11.25\n";
						
			System.out.println(input_1 + input_2 + input_3);
			// UserInput OBJECT accepts input and adds it to the UI object
			ui.initiate(input_2);
			//Abstract Input Matcher examines UserIput and creates a batch object with baby transactions.
			AbsInputMatcher.evaluate(ui.inputArray);
			//transaction comes in and is all like dood I R GUNNA calculates stuff.
			//AbsInputMatcher.evaluate(ui.inputArray);
			
			
//			String productName = null;
//			for(int i = 0, end = ui.inputArray.size(); i < end; i++ ) {
//				String word;
//				word = ui.inputArray.get(i);
//				System.out.println(productName += " " + word);
//			}

			//			Transaction t = new Transaction( AbsInputMatcher.productFinder(AbsInputMatcher.productArray(item)), "1", "5.50");
			
			
/**			Batch thing = im.evaluate(split_input_1);
			ArrayList<Transaction> stuff = thing.getTransactions();
			for (int i = 0; i < stuff.size(); i++) {
				Transaction item = stuff.get(i);
				item.setExemptAndImported();
				item.setTaxRate();
				System.out.println(item.name + " exempt: " + item.exempt + " imported: " + item.imported + " Tax rate: " + item.taxRate);
			}
**/		} 
	}
