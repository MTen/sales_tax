package com.mten.SalesTaxCalculator;

import java.util.ArrayList;
import java.util.Arrays;

import javax.lang.model.type.NullType;

// Afterthoughts
// I would probably change this to an Abstract class and have it instantiate a batch object
// and parse the starting input to the batch object where the batch object could create a
// new transaction for each new line from this input.



//Constructor
public class UserInput {
	////////////////////////
	//	Fields
	////////////////////////
	String starting;
	ArrayList<String> inputArray;
	ArrayList<String> batchNames;
	
	////////////////////////
	//	Constructor
	////////////////////////
	
	public UserInput() {
		this.starting = "";;
	}
	
	
	////////////////////////
	//	Methods
	////////////////////////
	
	public void initiate(String input){
		// do for loop
		this.examine(input);
		this.setInputArray();
	}
	
	
	//examine method to check user input for null and ""
	// Refactored setArray into examine.
	public String examine(String input) {
		if (input.length() == 0) {
			System.out.println("Can not be null or empty value, please try again");
			return "Can not be null or empty value, please try again";
		} else {
			System.out.println("Items Accepted");
			input.trim();
			this.starting = input.trim();
			return "ok";
		}
	}
	
	//Not sure how I can make the examine method parameters amorphous this is to prevent null input
	public String examine(NullType null_input) {
		System.out.println("Can not be null, please add some stuff to sell!");
		return "Can not be null or empty value, please try again";
		//TODO Learn how to throw errors.
	}


	
	//HELPER METHOD for setInputArray: splits user input on new line and returns as ArrayList
	public ArrayList<String> inputParser(String string) {
		return new ArrayList<String>(Arrays.asList(string.split("\\n")));
	}

	public void setBatchNames() {
		
	}
	public void setInputArray() {
		String string = this.starting;
		this.inputArray = inputParser(string);
		for (int i = 0; i < this.inputArray.size(); i++) {
			this.inputArray.get(i).replaceAll("[^ -~]", "");
		}
	}
	
	
	
	
	
}
