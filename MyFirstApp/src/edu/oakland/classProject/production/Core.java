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
	private int upperBound;	
	private int previousGuess;
	private int currentGuess;
	private int delta;
	private boolean gameFini;
	private int iteration;

	/**
	* Resets all the values of the core object
	*/
	public void initialize(){
		upperBound = 1024;
		previousGuess = upperBound / 2;
		delta = previousGuess / 2;
		gameFini = false;
		iteration = 1;
	}

	/**
	* Returns the maximum number of guesses the System is 
	* allowed to make. When the maxNumGuesses value is reached,
	* the user wins the game and the System loses.
	*@return the value of "maxNumGuesses" of type "int".
	*@see computeMaxNumGuesses
	*/
	public int getMaxNumGuesses() {
	    return (int)(Math.log(upperBound)/Math.log(2));
	}
	
	/**
	*Uses the value set by setGuessFeedbackSelection to calcuate
	*the value of the system's next guess
	*@return the value of "numberGuessed" op type "int"
	*/
	public int computeGuess(String feedback) {
		int guess;
		if(feedback.equals("lower")) {
			guess = previousGuess - delta;
		}
		else {
			guess = previousGuess + delta;
		}
		if(delta == 1) {
			gameFini = true;
		}
		delta = (int) Math.ceil(delta/2);
		previousGuess = guess;
		iteration++;
		return guess;
	}
	

	/**
	* Calculates the upper bound based on the user's input.
	*@param chosenUpperBound of type int is the upper bound.
	*/
	public void setUpperBound(int _upperBound) {
		upperBound = _upperBound;
	}

	public int getIteration() {
		return iteration;
	}

	public boolean isGameFini(){
		return gameFini;
	}
}
