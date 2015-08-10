package edu.oakland.classProject.production; // classProject be lowercase?

/**
* This class holds all of the core functionality of TheGuessingGame backend.
* Calculations for the application are performed in this class including 
* keeping track of the number of guesses made so far, determining and keeping
* track of the range of possible numbers which contain the number the user 
* picked, the upper bound (the highest number the user is allowed to pick), 
* and performing a binomial in order to efficiently guess the number the user
* picked.

*@author Renee Wise and David Chong
*@version version 1.0 150804
*@since version 1.0
*/


// upperbound 
public class Core {

	private static boolean hasGameEnded = false;// Flag for if a condition was encountered
											// that signifies the end of the game.
	
	private static int inputUpperBound = 1024;	// The maximum number the user can pick.
											// 1024 by default. The user may also specify
											// this value.
	
	private static int calcUpperBound;		// Adjusts the upper bound so the user can pick
											// a number from 1-1023.
	private static int maxNumGuesses; 		// The number of guesses the System is
											// allotted. If the System does not guess
											// the number correctly in the guesses
											// allotted to it, the System loses and
											// the user wins.
						
	private static int numberGuessed = 0; 	// The number the game generates as a guess for each pass 
											// until the number is guessed, the last  iteration is the 
											// correct guess
	private static int previousGuess = 0;
	private static int currentGuess = 0;	// Counter for the current guess count of the program that 
											// updates with each iteration of the guess cycle		
	
	private static String feedbackSelection = ""; 	
											// The selection that the user specifies in response to the 
											// System's guess. The user may specify that the number
											// guessed is higher, lower, or equal to the number he/she 
											// picked.
	
	private void computeMaxNumGuesses() {
	    maxNumGuesses = (int)(Math.log(inputUpperBound)/Math.log(2));
	}
	
	/**
	* Returns the maximum number of guesses the System is 
	* allowed to make. When the maxNumGuesses value is reached,
	* the user wins the game and the System loses.
	*@return returns the value of "maxNumGuesses" of type "int".
	*/
	public int requestMaxNumGuesses() {
		computeMaxNumGuesses();
	    return maxNumGuesses;
	}
	
	/**
	* 
	*/
	private void computeGuess() {
		
		if(feedbackSelection.equalsIgnoreCase("lower")) {
			numberGuessed = (int) Math.ceil(previousGuess - 
							(inputUpperBound/Math.pow(2, currentGuess)));
		}
		else if(feedbackSelection.equalsIgnoreCase("higher")) {
			numberGuessed = (int) Math.ceil(previousGuess + 
							(inputUpperBound/Math.pow(2, currentGuess)));
		}
		previousGuess = numberGuessed;
	}
	
	public int getGuess() {
		computeGuess();
		return numberGuessed;
	}

	/**
	* Iterates the guess counter when the System guesses a number.
	*/
	private void computeGuessIteration() {
		++currentGuess;
	}
	
	/**
	*
	*/
	public int getGuessIteration() {
		computeGuessIteration();
		return currentGuess;
	}
	
	public void setGuessFeedbackSelection(String selection) {
		feedbackSelection = selection;
	}
		
	private void computeHasGameEnded() {
		if(currentGuess >= maxNumGuesses)
			hasGameEnded = true;
		else if(feedbackSelection.equalsIgnoreCase("equal"))
			hasGameEnded = true;
		else
			hasGameEnded = false;
	}
	
	public boolean requestHasGameEnded() {
		computeHasGameEnded();
		return hasGameEnded;
	}
	
	/**
	* For extra credit for when the user can set the upper bound.
	*/
	public void setUpperBoundInput(int chosenUpperBound) {
		inputUpperBound = (int)Math.pow(2, chosenUpperBound);
	}
	
	/**
	* Adjusts the upper bound to the specifed upper bound - 1.
	*@return returns the value of "calcUpperBound" of type "int".
	*/
	private void computeUpperBoundComputed() {
		calcUpperBound = inputUpperBound - 1;	
	}
	
	public int requestUpperBoundComputed() {
		computeUpperBoundComputed();
		return calcUpperBound;
	}
}

