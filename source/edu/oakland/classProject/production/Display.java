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
   	* The local variables that determines the min and max that a user
   	* can select from.
   	* @param int MIN_UPPERBOUND_OPTION is the lowwest number possible.
   	* @param int MAX_UPPERBOUND_OPTION is the hightest number possible.
   	*/
	int MIN_UPPERBOUND_OPTION = 1;
	int MAX_UPPERBOUND_OPTION = 16;
	/*
	*TODO: make sure to define each method's functionality
	*/
	private String[] playOptions = new String[]{
		"[S]: Simple play",
		"[A]: Advanced play",
		"[Q]: Quit"
	};
	private String[] guessOptions = new String[]{
		"[+]: My number is higher",
		"[-]: My number is lower",
		"[=]: My number is equal"
	};
	private char[] playSelections = optionsToSelections(playOptions);
	private char[] guessSelections = optionsToSelections(guessOptions);
	 /**
	*This method displays the main screen to the user.
	* User must select an option.
   	* @param diplayWelcomeMessage
   	* @param diplayOptions
   	* @return char This returns the selection entered by user
   	* which should be redirected to the Play Selection.
   	*/
	public char getPlaySelection(){
		displayWelcomeMessage();
		displayOptions(playOptions);
		return requestEnterSelection(playSelections);
	}
	/**
   	* Displays the UpperBound selection.
   	* @return the display of the requested UpperBound that was entered.
   	*/
	public int getUpperBoundSelection(){
		displayRequestUpperBoundSelection();
		return requestEnterUpperBoundSelection();
	}
	
	public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses){
		displayRange(upperBoundComputed);
		displayReminder();
		displayMaxNumOfGuesses(maxNumOfGuesses, false);
		displayRequestReturnKey();
		requestReturnKey();
	}

	public char getGuessFeedback(int currentGuess, int currentGuessIteration){	
		String lineToPrint = String.format("Guess #%d\nThe system has guessed %d.", currentGuessIteration, currentGuess);
		System.out.println(lineToPrint);
		char userFeedback = requestEnterGuessFeedback();
		return userFeedback;
	}

	private char requestEnterGuessFeedback(){
		displayOptions(guessOptions);
		return requestEnterSelection(guessSelections);
	}
			
	/**
	* Displays Welcome Message.
	* Welcome title diplayed at the beginning of the game.
	*/
	private void displayWelcomeMessage() {
		System.out.println("Welcome to The Guessing Game!");
		System.out.println();
	}
	/**
	* Instructions user to choose a number between 1 and UpperBound.
	* Will diplay for user to chose a number.
	* @see upperBoundComputed
	*/
	private void displayRange(int upperBoundComputed){
		String lineToPrint = String.format("Please think of a number between 1 and %d.", upperBoundComputed);
		System.out.println(lineToPrint);
		System.out.println();
	}
	/**
 	* Diplays warning message to user.
 	* Warns user of the rules of the game.
 	*/
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
	/**
 	* Prints for user to enter an option for upper bound
 	* 
 	* 
 	*/
	private void displayRequestUpperBoundSelection(){
		System.out.println("Please enter an option for your desired upper bound.");
		for (int selection = MIN_UPPERBOUND_OPTION; selection <= MAX_UPPERBOUND_OPTION; selection++){
			int maxNumOfGuesses = selection;
			int upperBound = (int)Math.pow(2, maxNumOfGuesses) - 1;
			String option = String.format("[%d]: %d", selection, upperBound);
			System.out.println(option);
		}
	}
	/**
 	* This method checks to see if the integer is a valid entry
 	* If the selection is incorrect, the System will throw an error message 
 	* saying Invalid Input. 
 	* Creates a Scanner class to be able to print multiple lines.
 	* @param userInput 	the userInput is the input stored by the user
 	* @return the request for upper bound selected
 	* 
 	*/
	
	private int requestEnterUpperBoundSelection(){
		System.out.print(">");
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		while (!isInteger(userInput)){
			System.out.println("Invalid input! Please enter a valid integer.");
			return requestEnterUpperBoundSelection();
		}
		int intInput = Integer.parseInt(userInput);
		while(intInput < MIN_UPPERBOUND_OPTION || intInput > MAX_UPPERBOUND_OPTION){
			System.out.println(String.format("Invalid input! Please enter a valid selection."));
			return requestEnterUpperBoundSelection();
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
	/**
 	* Diplay for the user to press the return (enter)
 	* button to continue the game.
 	*/
	private void displayRequestReturnKey(){
		System.out.println("Press the return key to continue.");
	}
	/**
	* The method checks for the user pressing the enter key. 
	* @param input 	looks for the user to press the enter key.
	* @return 	the enter key
 	*/
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
	
	/**
	* String utility class to determine if a given string is a number (Integer).
	* Using method try, catch to only accept numbers.
 	* <p>
 	* This method always returns immediately, whether or not the 
 	* number exists. When this user attempts to place a letter on 
 	* the screen, the data will throw an exception.
 	*
 	* @param  name the location of the image, relative to the url argument
 	* @return   true
 	*/
	
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
