package edu.oakland.classProject.production;

import edu.oakland.classProject.production.Display;
import edu.oakland.classProject.production.Core;

public class Main{

	private Display display;
	private Core core;
	
	public int upperBoundComputed;
	public int maxNumOfGuesses;
	public int currentGuessIteration;
	public int currentGuess;
	public boolean gameEnded;
	
	public Main(){
		display = new Display();
		core = new Core();
	}
	
	public Main(Display disp, Core cor){
		display = disp;
		core = cor;
	}
	
	public void execute(){
		while (true){
			core.reinitialize();
			gameEnded = false;
			if (startGame(false, null, null) != -1) {
				core.setGuessFeedbackSelection("higher");
				gameEnded = core.requestHasGameEnded();
				while (gameEnded == false) {
					makeGuess(false, null);
					gameEnded = core.requestHasGameEnded();
				}
				endGame();
			} else {
				return;
			}
		}
	}
	
	public int startGame(boolean ui, Character _playSelection, Integer _upperBoundSelection){
		char playSelection = ui ? _playSelection : display.getPlaySelection();
		
		switch (playSelection){
			case 'Q': /// Quit
				return -1;
			case 'S': /// Simple Play
				/// keep default upperBoundInput
				break;
			case 'A': /// Advanced Play
				int upperBoundSelection = ui ? _upperBoundSelection : display.getUpperBoundSelection();
				core.setUpperBoundInput(upperBoundSelection);
				break;
		}
		
		upperBoundComputed = core.requestUpperBoundComputed();
		maxNumOfGuesses = core.requestMaxNumGuesses();
		
		if (!ui)
			display.getUserConfirmation(upperBoundComputed, maxNumOfGuesses);

		return maxNumOfGuesses;
	}
	
	
	
	public int makeGuess(boolean ui, Character _guessFeedback){
		currentGuessIteration = core.computeGuessIteration();
		currentGuess = core.computeGuess();
		
		char guessFeedback = ui ? _guessFeedback : display.getGuessFeedback(currentGuess, currentGuessIteration);
		
		core.setGuessFeedbackSelection(guessFeedback);
		
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
