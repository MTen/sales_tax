package com.mten.SalesTaxCalculator;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws Exception{
		
		// Using this as my "scratch pad"
		UserInput ui = new UserInput();
		
//		String stuff = im.priceFinder("1 stuff 5.00");
		String userInput = "";
//		im.unitFinder(userInput);
		
		//System.out.println("");

		String input_1 = "\nInput 1:\n1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85\n";
		String input_2 = "\nInput 2:\n1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50\n";
		String input_3 = "\nInput 3:\n1 imported bottle of perfume at 27.99\n1 bottle of perfume at 18.99\n1 packet of headache pills at 9.75\n1 box of imported chocolates at 11.25\n";
					
		System.out.println(input_1 + input_2 + input_3);
		ArrayList<String> the_OC_yo_meaning_origonal_content = new ArrayList<String>(Arrays.asList( input_1, input_2, input_3));
		
		//UserInput OBJECT accepts input and adds it to the UI object
		//Abstract Input Matcher examines UserIput and creates a batch object with baby transactions.
		//Transaction class comes in and is all like dood I R GUNNA calculates stuff using the Abstract Calculator thingy.

		ui.initiate(input_1);			
		Batch a = AbsInputMatcher.evaluate(ui.inputArray);
		ReceiptRunner.showTime(a);
		
		ui.initiate(input_2);
		Batch b = AbsInputMatcher.evaluate(ui.inputArray);
		ReceiptRunner.showTime(b);
		
		ui.initiate(input_3);
		Batch c = AbsInputMatcher.evaluate(ui.inputArray);
		ReceiptRunner.showTime(c);
		
	} 
}
