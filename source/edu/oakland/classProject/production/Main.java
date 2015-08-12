package edu.oakland.classProject.production;

import edu.oakland.classProject.production.Display;
import edu.oakland.classProject.production.Core;

public class Main{

	private Display display;
	private Core core;
	
	public Main(){
		display = new Display();
		core = new Core();
	}
	
	public Main(Display disp, Core cor){
		display = disp;
		core = cor;
	}
	
	public void execute(){
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
	
	public boolean startGame(){
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
	
	public int makeGuess(){
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

	public void endGame(){
		display.getEndGameConfirmation(core.getGuess(), core.getGuessIteration());
	}
}
