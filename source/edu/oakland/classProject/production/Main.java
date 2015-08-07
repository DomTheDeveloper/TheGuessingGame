package edu.oakland.classProject.production;

import edu.oakland.classProject.production.Display;
import edu.oakland.classProject.production.Core;

public class Main{

	Display display = new Display();
	Core core = new Core();
	
	public static void main(String[] args){
		Main main = new Main();
	}
	
	public Main(){
		startGame();
	}
	
	public void startGame(){
		char playSelection = display.getPlaySelection();
		
		switch (playSelection){
			case 'Q': /// Quit
				return;
			case 'S': /// Simple Play
				/// keep default upperBoundInput
				break;
			case 'A': /// Advanced Play
				int upperBoundInput = display.getUpperBoundInput();
				core.setInputUpperBound(upperBoundInput);
				break;
		}
		int upperBoundComputed = core.getCalcUpperBound();
		int maxNumOfGuesses = core.getMaxNumOfGuesses();
			
		display.getUserConfirmation(upperBoundComputed, maxNumOfGuesses);
			
		makeGuess();
	}
	
	public void makeGuess(){
	}
	
	public void endGame(){
		//display.getEndGameConfirmation(guess, guessIteration);
		startGame();
	}
	
}