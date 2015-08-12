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
   	* int MIN_UPPERBOUND_OPTION is the lowest number possible.
   	* int MAX_UPPERBOUND_OPTION is the highest number possible.
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
	/**
	* This method communicates with the Main.java to pull what the user enter
	* as the Upper Bound. It then displays what that number is. 
	* @param maxNumOfGuesses		type int displays max number of guesses
	* @param upperBoundComputed		type int displays the upper bound computed
	*/
	public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses){
		displayRange(upperBoundComputed);
		displayReminder();
		displayNumOfGuesses(maxNumOfGuesses, false);
		displayRequestReturnKey();
		requestReturnKey();
	}
	/**
	* This is a get method prints the number guessed by user to compare it to 
	* the system's guess.
	* @param currentGuess			type int displays max number of guesses
	* @param currentGuessIteration	type int displays the upper bound computed
	* @return userFeedback	
	*/
	public char getGuessFeedback(int currentGuess, int currentGuessIteration){	
		String lineToPrint = String.format("Guess #%d\nThe system has guessed %d.", currentGuessIteration, currentGuess);
		System.out.println(lineToPrint);
		char userFeedback = requestEnterGuessFeedback();
		return userFeedback;
	}
	/**
	* This is a get method prints the number guessed by user 
	* @param guess			type int displays the system guess
	* @param guessIteration	type int displays number of guesses
	* @return ReturnKey	
	*/
	public void getEndGameConfirmation(int guess, int guessIteration){
		System.out.println(String.format("The system has guessed your number, which is %d.", guess));
		displayNumOfGuesses(guessIteration, true);
		displayRequestReturnKey();
		requestReturnKey();
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
	private void displayNumOfGuesses(int numOfGuesses, boolean gameEnded){
		String verbTense = new String();
		String plurality = new String();
		
		if (gameEnded)
			verbTense = "successfully guessed";
		else
			verbTense = "will guess";
			
		if (numOfGuesses > 1){
			plurality = "es";
			if (!gameEnded)
				plurality += " or fewer";
		}
		else
			plurality = "";
		
		String lineToPrint = String.format("The system %s your number in %d guess%s.", verbTense, numOfGuesses, plurality);
		System.out.println(lineToPrint);
		System.out.println();
	}
	
	/* will return either int[] or int[][], based on dimensions input */
	private Object generateUpperBoundOptions(int dimensions){
		int numOfSelections = MAX_UPPERBOUND_OPTION-MIN_UPPERBOUND_OPTION;
		
		int[]   upperBoundOptions_1D = new int[numOfSelections+1];
		int[][] upperBoundOptions_2D = new int[numOfSelections+1][2];
		
		for (int i = 0; i <= numOfSelections; i++){
			int maxNumOfGuesses = i + MIN_UPPERBOUND_OPTION;
			int upperBound = (int)Math.pow(2, maxNumOfGuesses) - 1;
			
			//1D
			upperBoundOptions_1D[i] = upperBound;
			
			//2D
			upperBoundOptions_2D[i][0] = maxNumOfGuesses;
			upperBoundOptions_2D[i][1] = upperBound;
			
		}
		if (dimensions == 1)
			return upperBoundOptions_1D;
		else /// if (dimensions == 2)
			return upperBoundOptions_2D;
	}
	
	
	private void displayRequestUpperBoundSelection(){
		System.out.println("Please enter an option for your desired upper bound.");
		int[][] upperBoundOptions = (int[][])generateUpperBoundOptions(2);
		for (int[] option : upperBoundOptions){
			int maxNumOfGuesses = option[0];
			int upperBound      = option[1];

			System.out.println(String.format("[%d]: %d", maxNumOfGuesses, upperBound));
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
