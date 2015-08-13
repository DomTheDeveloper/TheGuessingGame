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
	
	public Main(){
		display = new Display();
		core = new Core();
	}
	
	public Main(Display disp, Core cor){
		display = disp;
		core = cor;
	}
	
	public void execute(){
		while(startGame()){
			while(makeGuess()){
			}
			endGame();
		}
	}
	
	public boolean startGame(){
		core.reinitialize();
		
		char playSelection = display.getPlaySelection();
		
		switch (playSelection){
			case 'Q':
				return false;
			case 'S': /// Simple Play
				/// keep default upperBoundInput
				break;
			case 'A': /// Advanced Play
				int upperBoundSelection = display.getUpperBoundSelection();
				core.setUpperBoundInput(upperBoundSelection);
				break;
		}
		
		upperBoundComputed = core.requestUpperBoundComputed();
		maxNumOfGuesses = core.requestMaxNumGuesses();
		
		display.getUserConfirmation(upperBoundComputed, maxNumOfGuesses);

		return true;
	}
	
	
	
	public boolean makeGuess(){
		if (core.requestHasGameEnded())
			return false; /// do not make guess
		
		currentGuessIteration = core.computeGuessIteration();
		currentGuess = core.computeGuess();
		
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
		
		return true;
	}

	public void endGame(){
		display.getEndGameConfirmation(core.getGuess(), core.getGuessIteration());
	}
}
