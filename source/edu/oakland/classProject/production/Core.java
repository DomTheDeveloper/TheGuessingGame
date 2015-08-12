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

public class Core {

	private boolean hasGameEnded = false;// Flag for if a condition was encountered
											// that signifies the end of the game.
	
	private int inputUpperBound = 1024;	// The maximum number the user can pick.
											// 1024 by default. The user may also specify
											// this value.
	
	private int calcUpperBound;		// Adjusts the upper bound so the user can pick
											// a number from 1-1023.
	private int maxNumGuesses; 		// The number of guesses the System is
											// allotted. If the System does not guess
											// the number correctly in the guesses
											// allotted to it, the System loses and
											// the user wins.
						
	private int numberGuessed = 0; 	// The number the game generates as a guess for each pass 
											// until the number is guessed, the last  iteration is the 
											// correct guess
	private int previousGuess = 0;
	private int currentGuess = 0;	// Counter for the current guess count of the program that 
											// updates with each iteration of the guess cycle		
	
	private String feedbackSelection = ""; 	
											// The selection that the user specifies in response to the 
											// System's guess. The user may specify that the number
											// guessed is higher, lower, or equal to the number he/she 
	
											// picked.
	public Core(){}
	public Core(boolean gameEnded, int upperBound, int calcBound, int maxGuesses, 
		int guessedNumber, int prevGuess, int curGuess, String feedbackSel){
		hasGameEnded = gameEnded;
		inputUpperBound = upperBound;
		calcUpperBound = calcBound;
		maxNumGuesses = maxGuesses;
		numberGuessed = guessedNumber;
		previousGuess = prevGuess;
		currentGuess = curGuess;
		feedbackSelection = feedbackSel;
	}

	/**
	* Resets all the values of the core object
	*/
	public void reinitialize(){
		hasGameEnded = false;
		inputUpperBound = 1024;
		numberGuessed = 0;
		previousGuess = 0;
		currentGuess = 0;
		feedbackSelection = "";
	}
	
	/**
	* Computes the maximium number of guesses that the system will take to guess
	* the user's number based on the upper bound
	*/
	private void computeMaxNumGuesses() {
	    maxNumGuesses = (int)(Math.log(inputUpperBound)/Math.log(2));
	}
	
	/**
	* Returns the maximum number of guesses the System is 
	* allowed to make. When the maxNumGuesses value is reached,
	* the user wins the game and the System loses.
	*@return the value of "maxNumGuesses" of type "int".
	*@see computeMaxNumGuesses
	*/
	public int requestMaxNumGuesses() {
		computeMaxNumGuesses();
	    return maxNumGuesses;
	}
	
	/**
	*Uses the value set by setGuessFeedbackSelection to calcuate
	*the value of the system's next guess
	*@return the value of "numberGuessed" op type "int"
	*/
	public int computeGuess() {
		
		if(feedbackSelection.equalsIgnoreCase("lower")) {
			numberGuessed = (int) Math.ceil(previousGuess - 
							(inputUpperBound/Math.pow(2, currentGuess)));
		}
		else if(feedbackSelection.equalsIgnoreCase("higher")) {
			numberGuessed = (int) Math.ceil(previousGuess + 
							(inputUpperBound/Math.pow(2, currentGuess)));
		}
		previousGuess = numberGuessed;
		return numberGuessed;
	}
	
	/**
	* Returns the numberGuessed value
	*@return the value of "numberGuessed" of type "int".
	*/
	public int getGuess() {
		return numberGuessed;
	}

	/**
	* Iterates the guess counter when the System guesses a number.
	*@return the value of "currentGuess" of type "int".
	*/
	public int computeGuessIteration() {
		++currentGuess;
		return currentGuess;
	}
	
	/**
	* Returns value stored in the guess counter.
	*@return the value of "currentGuess" of type "int".
	*/
	public int getGuessIteration() {
		return currentGuess;
	}
	
	/**
	* This method sets the feedbackSelection as a String reference
	* which will calculate feedselection as selection
	*@param selection a String that should be equal to "higher" "lower" or "equal"
	*/
	public void setGuessFeedbackSelection(String selection) {
		feedbackSelection = selection;
	}
	
	/**
	* Returns the feedbackSelection set for when the user indicates his/her
	* chosen number is greater, equal, or lower than the number the System
	* guessed.
	* @return the value of "feedbackSelection" of type "String"
	*/
	public String setGuessFeedbackSelection() {
		return feedbackSelection;
	}
	
	/**
	* Sets the value of the hasGameEnded variable based on the state
	* of the game
	*/
	private void computeHasGameEnded() {
		if (feedbackSelection.equalsIgnoreCase("equal")) {
			hasGameEnded = true;
		}
		else if ((currentGuess+1) >= maxNumGuesses) {
			computeGuessIteration();
			computeGuess();
			hasGameEnded = true;
		}
		else {
			hasGameEnded = false;
		}
	}
	
	/**
	* This boolean method tests to see if the game actually ended and returns the result.
	* @param computeHasGameEnded	validates with Main to determine if the user
	* 				selects to end the game.
	* @return the value of "hasGameEnded" of type "boolean"
	*/
	public boolean requestHasGameEnded() {
		computeHasGameEnded();
		return hasGameEnded;
	}
	
	/**
	* Calculates the upper bound based on the user's input.
	*@param chosenUpperBound of type int is the upper bound.
	*/
	public void setUpperBoundInput(int chosenUpperBound) {
		inputUpperBound = (int)Math.pow(2, chosenUpperBound);
	}
	
	/**
	* Calculates the upper range based on the upper bound chosen.
	*/
	private void computeUpperBoundComputed() {
		calcUpperBound = inputUpperBound - 1;	
	}
	
	/**
	* This method calls for the requested Upper Bound and returns the computed uppper bound.
	* @see computUpperBoundComputed
	* @return the value of "calcUpperBound" of type "int"
	*/
	public int requestUpperBoundComputed() {
		computeUpperBoundComputed();
		return calcUpperBound;
	}
}

