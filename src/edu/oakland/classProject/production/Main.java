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
		
		int upperBoundComputed = core.requestUpperBoundComputed();
		int maxNumOfGuesses = core.requestMaxNumGuesses();

		display.getUserConfirmation(upperBoundComputed, maxNumOfGuesses);

		return true;
	}
	
	public boolean makeGuess(){
		if (core.requestHasGameEnded())
			return false; /// do not make guess
		
		int currentGuessIteration = core.computeGuessIteration();
		int currentGuess = core.computeGuess();

		display.displayGuessInfo(currentGuess, currentGuessIteration);
		
		return true;
	}
	
	public void giveFeedback(){
		char guessFeedback = display.getGuessFeedback();
		
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

	public void endGame(){
		display.getEndGameConfirmation(core.getGuess(), core.getGuessIteration());
	}
}
