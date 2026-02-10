package edu.lewisu.input_examples;

import java.util.Scanner;

/*	In this example, we want to examine the 'traditional' way of getting input
 * 	using the Scanner class.
 * 
 * 	The issue with this is that you have to repeat the print and input statements,
 * 	and you will have to add a lot more code to do any error checking, or range
 * 	validations--none of which is done here.
 */

public class ExampleInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Please enter the current temperature: ");
		double degrees = sc.nextDouble();
		
		System.out.print("Please enter an Integer: ");
		int age = sc.nextInt();
		
		System.out.print("Please enter your first name: ");
		String name = sc.nextLine();
		
		/*
		 * PLEASE NOTE: The above it going to fail because there exists a Java
		 * bug in which a nextLine() that follows any next(), nextInt(), or nextDouble().
		 * 
		 * Hence, you must issue an empty sc.nextLine() statement, which 
		 * is commented out below.
		 */
		
		// Remove the comments below to get this code working properly.
		// sc.nextLine();
		
		// This is an example of string concatenation -- blech (please don't do it)
		System.out.println("Your name is " + name + 
				" -- your age is " + Integer.toString(age) + 
				" and the temp today is " + Double.toString(degrees));

		// This is more idiomatic in Java -- or use system.out.printf():
		System.out.println("Your name is %s -- your age is %d and the temp today is %.1f"
				.formatted(name, age, degrees));
		
		sc.close(); // Close the scanner resource.
	}
}

