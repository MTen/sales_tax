package com.mten.SalesTaxCalculator;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
	// Fixing "the Error: Could not find or load main class" in Eclipse configuration.

	
	// Using this as my "scratch pad"
	InputMatcher im = new InputMatcher("Test");
	UserInput ui = new UserInput();
	
//	String stuff = im.priceFinder("1 stuff 5.00");
	String userInput = "";
//	im.unitFinder(userInput);
	
	System.out.println("Input 1");
	userInput = "1 book at 12.49";
	im.productFinder(userInput);
	im.unitFinder(userInput);
	im.priceFinder(userInput);
	userInput = "1 music CD at 14.99";
	im.productFinder(userInput);
	im.unitFinder(userInput);
	im.priceFinder(userInput);
	userInput = "1 chocolate bar at 0.85";
	im.productFinder(userInput);
	im.unitFinder(userInput);
	im.priceFinder(userInput);
	System.out.println("");
	
	System.out.println("Input 2");
	userInput = "1 imported box of chocolates at 10.00";
	im.productFinder(userInput);
	im.unitFinder(userInput);
	im.priceFinder(userInput);
	userInput = "1 imported bottle of perfume at 47.50";
	im.productFinder(userInput);
	im.unitFinder(userInput);
	im.priceFinder(userInput);
	System.out.println("");
	
	System.out.println("Input 3");
	userInput = "1 imported bottle of perfume at 27.99";
	im.productFinder(userInput);
	im.unitFinder(userInput);
	im.priceFinder(userInput);
	userInput = "1 bottle of perfume at 18.99";
	im.productFinder(userInput);
	im.unitFinder(userInput);
	im.priceFinder(userInput);
	userInput = "1 packet of headache pills at 9.75";
	im.productFinder(userInput);
	im.unitFinder(userInput);
	im.priceFinder(userInput);
	userInput = "1 box of imported chocolates at 11.25";
	im.productFinder(userInput);
	im.unitFinder(userInput);
	im.priceFinder(userInput);
	
	System.out.println("");

	String input_1 = "1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85";
	ArrayList<String> split_input_1 = new ArrayList<String>(Arrays.asList( "1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85"));
	String input_3 = "1 imported bottle of perfume at 27.99" + "1 bottle of perfume at 18.99" + "1 packet of headache pills at 9.75" + "1 box of imported chocolates at 11.25";
	
	System.out.println(input_1);
	im.evaluate(split_input_1);
	ui.setInput(input_1);
	System.out.println(ui.starting);
	}

}
