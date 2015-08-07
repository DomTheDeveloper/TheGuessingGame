package edu.oakland.classProject.production;

/**
* This class holds all of the core functionality of TheGuessingGame backend.
* Calculations for the application are performed in this class including 
* keeping track of the number of guesses made so far, determining and keeping
* track of the Bound of possible numbers which contain the number the user 
* picked, the upper bound (the highest number the user is allowed to pick), 
* and performing a binomial in order to efficiently guess the number the user
* picked.

*@author Renee Wise and David Chong
*@version version 1.0 150804
*@since version 1.0
*/


// upperbound 
public class Core {
	/**
	*TODO: class variable definitions here
	*/  
	private static int inputUpperBound = 1024;	// The maximum number the user can pick //made final in mian
	private static int calcUpperBound;		// Adjusts the upper Bound so the user can pick
						// a number from 1-1023.
	private static int maxNumOfGuesses; 		// The number of guesses the System is
						// allotted. If the System does not guess
						// the number correctly in the guesses
						// allotted to it, the System loses and
						// the user wins.
						
	private static int currentGuess;
	private static int previousGuess = 0;
	private static int nthGuess = 1;
	
	public Core(){
		computeMaxNumOfGuesses();
		computeCalcUpperBound();
	}
	
	/**
	* Returns the maximum number the in the Bound of numbers that the
	* user can pick.
	*@return returns the value of "inputUpperBound" of type "int".
	*/
	 public int getInputUpperBound() {
		return inputUpperBound;
	}
	
	/**
	* Returns the maximum number the in the Bound of numbers that the
	* user can pick.
	*@return returns the value of "inputUpperBound" of type "int".
	*/
	public void computeCalcUpperBound() {
		calcUpperBound = inputUpperBound - 1;	
	}
	
	public int getCalcUpperBound(){
		return calcUpperBound;
	}
	
	/**
	* For extra credit for when the user can set the upper Bound.
	*/
	public void setInputUpperBound(int _inputUpperBound) {
		inputUpperBound = _inputUpperBound;
		computeMaxNumOfGuesses();
		computeCalcUpperBound();
	}
	
	public void computeMaxNumOfGuesses() {
	    maxNumOfGuesses = (int)(Math.log(inputUpperBound)/Math.log(2));
	}
	/**
	* Returns the maximum number of guesses the System is 
	* allowed to make. When the maxNumOfGuesses value is reached,
	* the user wins the game and the System loses.
	*@return returns the value of "maxNumOfGuesses" of type "int".
	*/
	public int getMaxNumOfGuesses() {
	    return maxNumOfGuesses;
	}
	
	public void computeLowerGuess() {
	    currentGuess = (int)Math.ceil(previousGuess - (inputUpperBound/nthGuess));
	}
	
	public void computeHigherGuess() {
	    currentGuess = (int)Math.ceil(previousGuess + (inputUpperBound/nthGuess));
	}
	

	/**
	* Iterates the guess counter when the System guesses a number.
	*/
	private void iterateCurrentGuess() {
		++nthGuess;
	}

}

