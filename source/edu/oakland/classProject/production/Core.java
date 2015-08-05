package edu.oakland.classProject.production

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
	/**
	*TODO: class variable definitions here
	*/  
	private static inputUpperRange = 1024;	// The maximum number the user can pick //made final in mian
	private static calcUpperRange;		// Adjusts the upper range so the user can pick
						// a number from 0-1023.
	private static maxNumGuesses; 		// The number of guesses the System is
						// allotted. If the System does not guess
						// the number correctly in the guesses
						// allotted to it, the System loses and
						// the user wins.
						
	private static currentGuess;
	private static previousGuess = 0;
	private static nthGuess = 1;
	
	/**
	* Returns the maximum number the in the range of numbers that the
	* user can pick.
	*@return returns the value of "inputUpperRange" of type "int".
	*/
	 public int getInputUpperRange() {
		return inputUpperRange;
	}
	
	/**
	* Returns the maximum number the in the range of numbers that the
	* user can pick.
	*@return returns the value of "inputUpperRange" of type "int".
	*/
	public void calcUpperRange() {
		calcUpperRange = inputUpperRange - 1;	
	}
	
	/**
	* For extra credit for when the user can set the upper range.
	*/
	public void setInputUpperRange() {
	}
	
	public void setNumGuesses() {
	    maxNumGuesses = (int)(Math.log(inputUpperRange)/Math.log(2));
	}
	
	public int getNumGuesses() {
	    return maxNumGuesses;
	}
	
	/**
	* 
	*/
	public void computeLowerGuess() {
	    currentGuess = Math.ceil(previousGuess - (inputUpperBound/nthGuess));
	}
	
	public void computeHigherGuess() {
	    currentGuess = Math.ceil(previousGuess + (inputUpperBound/nthGuess));
	
	/**
	* Returns the maximum number of guesses the System is 
	* allowed to make. When the maxNumGuesses value is reached,
	* the user wins the game and the System loses.
	*@return returns the value of "maxNumGuesses" of type "int".
	*/
	public int getMaxNumGuesses() {
		return maxNumGuesses;
	}

	/**
	* Iterates the guess counter when the System guesses a number.
	*/
	private void iterateCurrentGuess() {
		++nthGuess;
	}

}

