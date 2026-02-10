package edu.lewisu.input_examples;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double degrees = Utils.readDouble(sc, 
				"Please enter the current temperature: ", 
				0, 120);
		
		int age = Utils.readInteger(sc, 
				"Please enter an Integer: ", 0, 10);
		
		String name = Utils.readString(sc, 
				"Please enter your first name: ");
		
		// This is an example of string concatenation -- blech (please don't do it)
		System.out.println("Your name is " + name + 
				" -- your age is " + Integer.toString(age) + 
				" and the temp today is " + Double.toString(degrees));

		// This is more idiomatic in Java -- or use system.out.printf():
		System.out.println("Your name is %s -- your age is %d and the temp today is %.1f"
				.formatted(name, age, degrees));
		
		
		sc.close();
	}
}
