package edu.oakland.classProject.production;

import edu.oakland.classProject.production.Display;
import edu.oakland.classProject.production.Core;

public class Main{

	private static Display display = new Display();
	private static Core core;
	
	public static void main(String[] args){
		boolean gameEnded;
		while (true){
			core = new Core();
			gameEnded = false;
			if (startGame()) {
				core.setGuessFeedbackSelection("higher");
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
	
	public static boolean startGame(){
		char playSelection = display.getPlaySelection();
		switch (playSelection){
			case 'Q': /// Quit
				return false;
			case 'S': /// Simple Play
				/// keep default upperBoundInput
				break;
			case 'A': /// Advanced Play
				int upperBoundSelection = display.getUpperBoundSelection();
				core.setUpperBoundInput(upperBoundSelection);
				break;
		}
		
		int upperBoundComputed = core.requestUpperBoundComputed();
		int maxNumOfGuesses = core.requestMaxNumGuesses();
			
		display.getUserConfirmation(upperBoundComputed, maxNumOfGuesses);

		return true;
	}
	
	public static void makeGuess(){
		int currentGuessIteration = core.getGuessIteration();
		int currentGuess = core.getGuess();
		
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
	}

	public static void endGame(){
		System.out.println("-- Game ended --");
		//display.getEndGameConfirmation(guess, guessIteration);
	}
	
}
