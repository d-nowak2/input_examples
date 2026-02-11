package edu.lewisu.input_examples;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String repeat = null;
		
		do {
			double degrees = Utils.readDouble(sc, 
					"Please enter the current temperature: ", 
					0, 120);
			
			int currentAge = Utils.readInteger(sc, 
					"Please enter your current age (in years): ");
			
			int retirementAge = Utils.readInteger(sc, 
					"Please enter your age at retirement (in years): ");
			
			String name = Utils.readString(sc, 
					"Please enter your first name: ");
			
			// This is an example of string concatenation -- blech (please don't do it)
			System.out.println("Your name is " + name + 
					" -- your age is " + Integer.toString(currentAge) + 
					" and the temp today is " + Double.toString(degrees));
	
			// This is more idiomatic in Java -- or use system.out.printf():
			System.out.println("Your name is %s -- your age is %d and the temp today is %.1f"
					.formatted(name, currentAge, degrees));
		
			int years = retirementAge - currentAge;
			for(int i = 0; i < years; i++) {
				System.out.println("For year %d -- some calculation"
						.formatted(i));
			}
			
			repeat = Utils.readString(sc, 
					"Do you wish to calculate another retirement scenario? (y/n) ");
			repeat = repeat.trim().toLowerCase();
		} while(repeat.equals("y"));	
		
		sc.close();
	}
}
