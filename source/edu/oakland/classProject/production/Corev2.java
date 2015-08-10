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
	private static UpperBoundInput = 1024;	// The maximum number the user can pick //made final in main
	private static GuessNumber;		// Adjusts the upper range so the user can pick
						// a number from 0-1023.
	private static maxNumGuesses;           // The number of guesses the System is
        public int i, k;

						
	private static currentGuess;
	private static previousGuess = 0;
	private static nthGuess = 1;
	
	/**
	* Returns the maximum number the in the range of numbers that the
	* user can pick.
	*@return returns the value of "inputUpperRange" of type "int".
	*/
	 public int getUpperBoundInput() {
		return UpperBoundInput;
	}
	
	/**
	* Returns the maximum number the in the range of numbers that the
	* user can pick.
	*@return returns the value of "inputUpperRange" of type "int".
	*/
	public void GetGuessNumber() {
            GuessNumber=(int) (Math.random() * 1022 + 1);	
	}
	
	/**
	* For extra credit for when the user can set the upper range.
	*/
  public void calculateGuess(int l){
      //loop to eneble user take gueses 10 times
        for (i=1; i<=10;i++){
            display.enterguess();
            k = keyboard.nextInt();                     //scanner class that accepts user's guess #
        if (k == l) {
            display.correctguess();                     //display prompted message if user guesses right #
            break;
            }
                   
        else if (k < l){
            display.smallerguess();                     //display prompted message if user's guess is smaller than # system pick
            }
        else if (k > l){
            display.biggerguess();                     //display prompted message if user's guess is bigger than # system pick 
            }
        }
        }
	
	public void setNumGuesses() {
	    maxNumGuesses = (int)(Math.log(inputUpperRange)/Math.log(2));
	}
	
	public int getNumGuesses() {
	    return maxNumGuesses;
	}
	

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

