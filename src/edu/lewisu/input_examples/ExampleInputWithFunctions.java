package edu.lewisu.input_examples;

import java.util.Scanner;

/*	In this example, we want to use functions get our input in single statements.
 * 	The functions handle all the heavy-lifting (prompt, validation, and 
 * 	range validation.
 */

public class ExampleInputWithFunctions {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double degrees = readDouble(sc, "Please enter the current temperature: ", 
				0, 100);
		
		int age = readInteger(sc, "Please enter an Integer: ", 1, 80);
		
		String name = readString(sc, "Please enter your first name: ");
		
		// This is an example of string concatenation -- blech (please don't do it)
		System.out.println("Your name is " + name + 
				" -- your age is " + Integer.toString(age) + 
				" and the temp today is " + Double.toString(degrees));

		// This is more idiomatic in Java -- or use system.out.printf():
		System.out.println("Your name is %s -- your age is %d and the temp today is %.1f"
				.formatted(name, age, degrees));
		
		sc.close(); // Close the scanner resource.
	}
	
	// This code would have been duplicated in the readDouble(), readInteger(), and
	// readString() functions. So, we want to observe the 
	// DRY (Don't Repeat Yourself) principle--so we isolate the duplicated code
	// into its own function.
	private static String getUserInput(Scanner sc, String prompt) {
		System.out.print(prompt);
		return sc.nextLine();
	}
	
	// Method to readDouble and includes the functionality 
	// to force an input between a range of values.
	public static double readDouble(Scanner sc, String prompt, 
			double min, double max) {
		Double value = null;
		
		do { // A do loop is a post-test loop (guarantees at least one iteration).
			String userInput = getUserInput(sc, prompt);
			try {
				value = Double.parseDouble(userInput);
				if(value < min || value > max) {
					throw new OutOfRangeException( 
							"Error: Value is out of range.");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid Input: Please enter a numeric value.");
			}
			catch(OutOfRangeException e) {
				value = null;
				System.out.println(e.getMessage());
			}
		} while (value == null);
		
		return value;
	}
	
	// Method to readInteger
	public static int readInteger(Scanner sc, String prompt, 
			int min, int max) {
		Integer value = null;
		
		do {
			String userInput = getUserInput(sc, prompt);
			try {
				value = Integer.parseInt(userInput);
				if(value < min || value > max) {
					throw new OutOfRangeException( 
							"Error: Value is out of range.");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid Input: Please enter a numeric value.");
			}
			catch(OutOfRangeException e) {
				value = null;
				System.out.println(e.getMessage());
			}
		} while (value == null);
		
		return value;
	}

	public static String readString(Scanner sc, String prompt) {
		return getUserInput(sc, prompt);
	}
	
	/* This function allows us to construct a custom error handler, which 
	 * inherits from the Exception base class. 
	 */
	
	//@SuppressWarnings("serial")
	static class OutOfRangeException extends Exception {
		private static final long serialVersionUID = 1L;
		public OutOfRangeException() {
			super();
		}
		public OutOfRangeException(String message) {
			super(message);
		}
		public OutOfRangeException(Throwable cause) {
			super(cause);
		}
		public OutOfRangeException(String message, Throwable cause) {
			super(message, cause);
		}
	}
}
