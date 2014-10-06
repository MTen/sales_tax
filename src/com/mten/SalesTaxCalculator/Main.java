package com.mten.SalesTaxCalculator;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	// Fixing "the Error: Could not find or load main class" in Eclipse configuration.
	System.out.println("This is a test");
	
	
	
	// Using this as my "scratch pad"
	InputMatcher im = new InputMatcher("Test");
	im.matcherEngine("\\d*\\.+\\d*", "10.00;5.00;2000;6;8;500.00;");
	
	ArrayList<String> myArray = new ArrayList<String>();
	myArray.add("2.00"); myArray.add("5.00");
	ArrayList<String> userInput = im.matcherEngine("\\d*\\.+\\d*", "10.00");
	
	System.out.println(myArray);
	}

}
