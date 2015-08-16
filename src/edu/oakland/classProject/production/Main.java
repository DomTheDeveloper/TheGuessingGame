package edu.oakland.classProject.production;

public class Main{

	private IDisplay display;
	private Core core;
	
    public Main(IDisplay _display) {
		display = _display;
		core = new Core();
    }
	public boolean startGame(){
		core.reinitialize();
		
		switch (display.getPlaySelection()){
			case 'S': /// Simple Play
				/// default upperBoundInput
				break;
			case 'A': /// Advanced Play
				core.setUpperBoundInput(display.getUpperBoundSelection());
				break;
			case 'Q': /// Quit
				return false;
		}

		display.getUserConfirmation(core.getUpperBoundComputed(), core.getMaxNumOfGuesses());

		return true;
	}
	public boolean makeGuess(){
		if (core.getHasGameEnded())
			return false; /// do not make guess
			
		core.computeGuess();
		display.displayGuessInfo(core.getGuess(), core.getGuessIteration());
		
		return true;
	}
	public void giveFeedback(){
		core.setGuessFeedbackSelection(display.getGuessFeedback());
	}
	public void endGame(){
		display.getEndGameConfirmation(core.getGuess(), core.getGuessIteration());
	}
}
