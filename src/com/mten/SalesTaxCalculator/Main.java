package com.mten.SalesTaxCalculator;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	// Fixing "the Error: Could not find or load main class" in Eclipse configuration.
	System.out.println("This is a test");

	
	// Using this as my "scratch pad"
	InputMatcher im = new InputMatcher("Test");
	
	String stuff = im.priceFinder("1 stuff 5.00");
	
	System.out.println(stuff);
	}

}
