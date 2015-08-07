package edu.oakland.classProject.production;

import java.util.*;
import java.io.*;

/**
*This class holds the methods involved with displaying the command line interface.
*@author Bart Tokarz / Ashley Taylor
*@version "version 0.0.2" "150803"
*/
public class Display {
	/**
	*TODO: class variable definitions here
	*/
	/**
	*TODO: make sure to define each method's functionality
	*/
	private String[] playOptions = new String[]{
		"[S]: Simple Play",
		"[A]: Advanced play",
		"[Q]: Quit"
	};
	private char[] playSelections = optionsToSelections(playOptions);
	
	public char getPlaySelection(){
		displayWelcomeMessage();
		displayOptions(playOptions);
		return requestEnterSelection(playSelections);
	}
	public int getUpperBoundInput(){
		displayRequestUpperBoundInput();
		return requestPositiveInteger();
	}
	public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses){
		displayRange(upperBoundComputed);
		displayReminder();
		displayMaxNumOfGuesses(maxNumOfGuesses, false);
		displayRequestReturnKey();
		requestReturnKey();
	}
	private void displayWelcomeMessage() {
		System.out.println("Welcome to The Guessing Game!");
		System.out.println();
	}
	private void displayRange(int upperBoundComputed){
		String lineToPrint = String.format("Please think of a number between 1 and %d.", upperBoundComputed);
		System.out.println(lineToPrint);
		System.out.println();
	}
	private void displayReminder(){
		System.out.println("Make sure you remember your number,");
		System.out.println("and do not change it during the game.");
		System.out.println();
	}
	private void displayMaxNumOfGuesses(int maxNumOfGuesses, boolean gameEnded){
		String verbTense = new String();
		
		if (gameEnded)
			verbTense = "successfully guessed";
		else
			verbTense = "will guess";
		
		String lineToPrint = String.format("The game %s your number within %d guesses or less.", verbTense, maxNumOfGuesses);
		System.out.println(lineToPrint);
		System.out.println();
	}
	private void displayRequestUpperBoundInput(){
		System.out.println("Enter the upper bound integer (example: 1024)");
	}
	private int requestPositiveInteger(){
		System.out.print(">");
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		while (!isInteger(userInput)){
			System.out.println("Invalid input! Please enter a valid integer.");
			return requestPositiveInteger();
		}
		int intInput = Integer.parseInt(userInput);
		while(intInput < 1){
			System.out.println("Invalid input! Please enter a positive integer.");
			return requestPositiveInteger();
		}
		return intInput;
	}
	private char requestEnterSelection(char[] selections){
		System.out.print(">");
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		while (userInput.length() != 1){
			System.out.println("Invalid selection! Please enter a 1 character selection.");
			return requestEnterSelection(selections);
		}
		char selectionChar = userInput.toUpperCase().charAt(0);
		while(!contains(selectionChar, selections)){
			System.out.println("Invalid selection! Please enter a valid selection.");
			return requestEnterSelection(selections);
		}
		return selectionChar;
	}
	private void displayRequestReturnKey(){
		System.out.println("Press the return key to continue.");
	}
	private void requestReturnKey(){
		System.out.print(">");
		Scanner input = new Scanner(System.in);
		input.nextLine();
		return;
	}
	private void displayOptions(String[] options){
		System.out.println("Select an option:");
		for (String option : options) {
			System.out.println(option);
		}
	}
	private char[] optionsToSelections(String[] options){
		int selection = 0;
		char[] selections = new char[options.length];
		for (String option : options) {
			selections[selection] = option.charAt(1);
			selection++;
		}
		return selections;
	}
	private boolean contains(char c, char[] array) {
		for (char x : array) {
			if (x == c) {
				return true;
			}
		}
		return false;
	}
	private static boolean isInteger(String s) {
		try { 
			Integer.parseInt(s); 
		} catch(NumberFormatException e) { 
			return false; 
		} catch(NullPointerException e) {
			return false;
		}
		
		return true;
	}
}
