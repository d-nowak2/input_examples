package edu.lewisu.input_examples;

import java.util.Scanner;

public final class Utils {
	private Utils() {}
	
	private static String getUserInput(Scanner sc, String prompt) {
		System.out.print(prompt);
		return sc.nextLine();
	}
	
	// Utilities to read double (floating point) values:
	
	// This method allows us to retrieve any double value (no range):
	public static double readDouble(Scanner sc, String prompt) {
		double value = readDouble(sc, prompt,
				Double.MIN_VALUE, Double.MAX_VALUE);
				
		return value;
	}
	
	// Overloaded method to readDouble and includes the functionality 
	// to force an input between a range of values.
	public static double readDouble(Scanner sc, String prompt, 
			double min, double max) {
		Double value = null;
		
		do { // A do loop is a post-test loop (guarantees at least one iteration).
			String userInput = getUserInput(sc, prompt);
			try {
				value = Double.parseDouble(userInput);
				if(value < min || value > max) {
					value = null;
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
	
	// Utilities to read integer values:
	public static int readInteger(Scanner sc, String prompt) {
		int value = readInteger(sc, prompt, 
				Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		return value;
	}
			
	// Overloaded method to readInteger
	public static int readInteger(Scanner sc, String prompt, 
			int min, int max) {
		Integer value = null;
		
		do {
			String userInput = getUserInput(sc, prompt);
			try {
				value = Integer.parseInt(userInput);
				if(value < min || value > max) {
					value = null;
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
