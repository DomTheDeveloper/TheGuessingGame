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
	
	// The main method calls for the methods to start the game and then method for
	// the system to guess and the player to interact with the system.
	public static void main(String[] args){
		startGame();
		makeGuess("higher");
	}

	/** 
	*	The startGame method calls for the Display class to display the initial screen.
	*	This will also read the initial user input for simple/advanced game selection.
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
			
	}
	
	public static void makeGuess(String userSelection){
		core.setGuessFeedbackSelection(userSelection);
		
		int currentGuessIteration = core.getGuessIteration();
		int currentGuess = core.getGuess();

		
	}

	public static void endGame(){
		//display.getEndGameConfirmation(guess, guessIteration);
	}
	
}
