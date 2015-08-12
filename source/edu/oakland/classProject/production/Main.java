package edu.oakland.classProject.production;

import edu.oakland.classProject.production.Display;
import edu.oakland.classProject.production.Core;

/**
*	This class passes information between the Core and the Display class.
*	@author Gregory Kabacinski
*	@version "version 0.2" "150810"
**/

public class Main{
	
	// Create instances of the Display and Core classes.
	private static Display display = new Display();
	private static Core core = new Core();
	
	/**
	* The main method calls for the methods to start the game and then method for
	* the system to guess and the player to interact with the system.
	* @return	
	*/
	public static void main(String[] args){
		boolean gameEnded;
		while (true){
			core.reinitialize();
			gameEnded = false;
			if (startGame()) {
				core.setGuessFeedbackSelection("higher");
				gameEnded = core.requestHasGameEnded();
				while (gameEnded == false) {
					makeGuess();
					gameEnded = core.requestHasGameEnded();
				}
				endGame();
			} else {
				return;
			}
		}
	}

	/** 
	*The startGame method calls for the Display class to display the initial screen.
	*This will also read the initial user input for simple/advanced game selection.
	* upperBoundComputed 	int calculated the Upper Bound called from the Core
	* maxNumOfGuesses	int calculated the max number of guesses		
	* playSelection 	Grabs the options from the display and calculates what each letter
	* 			consists of. 
	* @return 		"Q" will return to startGame
	**/
	public static void startGame(){
		char playSelection = display.getPlaySelection();
		switch (playSelection){
			case 'Q': /// Quit
				return;
			case 'S': /// Simple Play
				/// keep default upperBoundInput
				break;
			case 'A': /// Advanced Play
				int upperBoundSelection = display.getUpperBoundSelection();
				core.setUpperBoundSelection(upperBoundSelection);
				break;
		}
		
		int upperBoundComputed = core.getUpperBound();
		int maxNumOfGuesses = core.getMaxNumOfGuesses();
			
		display.getUserConfirmation(upperBoundComputed, maxNumOfGuesses);

		return true;
	}
	/**
	* Communicates with the Core to pull the user's number.
	* @return currentGuess	
	*/
	public static int makeGuess(){
		int currentGuessIteration = core.computeGuessIteration();
		int currentGuess = core.computeGuess();
		
		char guessFeedback = display.getGuessFeedback(currentGuess, currentGuessIteration);
		
		switch (guessFeedback){
			case '+': //"My number is higher"
				core.setGuessFeedbackSelection("higher");
				break;
			case '-': //"My number is lower"
				core.setGuessFeedbackSelection("lower");
				break;
			case '=': //"My number is equal"
				core.setGuessFeedbackSelection("equal");
				break;
		}
		return currentGuess;
	}
	
	/**
	* End of the game
	* Display the guessed number and confirms the end results.
	*/
	public static void endGame(){
		display.getEndGameConfirmation(core.getGuess(), core.getGuessIteration());
	}
	
}
