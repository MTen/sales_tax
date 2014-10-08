package com.mten.SalesTaxCalculator;

import java.util.ArrayList;
import java.util.Arrays;

import javax.lang.model.type.NullType;


//Constructor
public class UserInput {
	////////////////////////
	//	Fields
	////////////////////////
	String starting;
	ArrayList<String> inputArray;
	
	////////////////////////
	//	Constructor
	////////////////////////
	
	public UserInput() {
		this.starting = "";;
	}
	
	
	////////////////////////
	//	Methods
	////////////////////////
	
	//examine method to check user input for null and ""
	public String examine(String input) {
		if (input.length() == 0) {
			return "Can not be null or empty value, please try again";
		} else {
			System.out.println("ok");
			return "ok";
		}
	}
	
	//Not sure how I can make the examine method parameters amorphous this is to prevent null input
	public String examine(NullType null_input) {
		return "Can not be null or empty value, please try again";
	}

	//Setter method
	public void setInput(String input) {
		if (examine(input) == "ok") {
			this.starting = input;
		}
	}
	
	//splits user input on new line and returns as ArrayList
	public ArrayList<String> inputParser(String string) {
		return new ArrayList<String>(Arrays.asList(string.split("\\n")));
	}


	public void setInputArray(String string) {
		System.out.println(string);
		this.inputArray = inputParser(string);
	}
	
	
	
}
