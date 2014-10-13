package com.mten.SalesTaxCalculator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws Exception{
		
		UserInput ui = new UserInput();
		
		//Can't get the input stream or scanner to recognize my UserInput.txt file. 
		//Instead of wasting a bunch of time this is where I would ask someone for help.
		//But my assignment is due so I'm sorry I will have to resort to pseudo code.
		
		/**Pseudo Code for input stream.
		 * 	public //InputStream getTextDocument()	{
		 *  	InputStream streamedData = getClass().getResourceAsStream("ListStopWords.txt");
		 *  	return streamedData
		 *  }
		 *  
		 *  //getting rid of first input
		 *  text = getTextDocument()
		 *  text.replaceAll("INPUT:", "");
		 *  
		 *  //making it into an array list split by the word Input
		 *	ArrayList<String> text2 = new ArrayList<String>(Arrays.asList(text.split("Input \\d:")));
		 *  
		 *  // loop through each item in the array and call ui.inititate, evaluate, and showTime;
		 *  
		**/
		
		
		String input_1 = "\nInput 1:\n1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85\n";
		String input_2 = "\nInput 2:\n1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50\n";
		String input_3 = "\nInput 3:\n1 imported bottle of perfume at 27.99\n1 bottle of perfume at 18.99\n1 packet of headache pills at 9.75\n1 box of imported chocolates at 11.25\n";
					
		System.out.println(input_1 + input_2 + input_3);
		ArrayList<String> textFileInput = new ArrayList<String>(Arrays.asList( input_1, input_2, input_3));
		
		//UserInput object accepts input and adds it to the UI object
		//Abstract Input Matcher examines UserIput and creates a batch object with baby transactions.
		//Transaction class comes in and calculates the input using the Abstract Calculator.

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
