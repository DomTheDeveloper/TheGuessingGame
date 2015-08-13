package edu.oakland.classProject.production;

public class Main{

	private IDisplayStart displayStart;
	private IDisplayGuess displayGuess;

	private Core core;
	public static Main main;

	public int upperBoundComputed;
	public int maxNumOfGuesses;
	public int currentGuessIteration;
	public int currentGuess;

	public static Main getInstance(){
		return main;
	}

    public Main(IDisplay _display) {
        this();
        setDisplayStart(displayStart);
        setDisplayGuess(displayGuess);
    }

    public Main(){
        main = this;
        core = new Core();
    }
	public void setDisplayStart(IDisplayStart _displayStart) {
		displayStart = _displayStart;
	}

	public void setDisplayGuess(IDisplayGuess _displayGuess) {
		displayGuess = _displayGuess;
	}
	
	public boolean startGame(){
		core.reinitialize();
		
		char playSelection = displayStart.getPlaySelection();
		
		switch (playSelection){
			case 'Q':
				return false;
			case 'S': /// Simple Play
				/// keep default upperBoundInput
				break;
			case 'A': /// Advanced Play
				int upperBoundSelection = displayStart.getUpperBoundSelection();
				core.setUpperBoundInput(upperBoundSelection);
				break;
		}
		
		upperBoundComputed = core.requestUpperBoundComputed();
		maxNumOfGuesses = core.requestMaxNumGuesses();

		displayStart.getUserConfirmation(upperBoundComputed, maxNumOfGuesses);

		return true;
	}
	
	public boolean makeGuess(){
		if (core.requestHasGameEnded())
			return false; /// do not make guess
		
		currentGuessIteration = core.computeGuessIteration();
		currentGuess = core.computeGuess();

		displayGuess.displayGuessInfo(currentGuess, currentGuessIteration);
		
		return true;
	}
	
	public void giveFeedback(){
		currentGuessIteration = core.getGuessIteration();
		currentGuess = core.getGuess();
	
		char guessFeedback = displayGuess.getGuessFeedback();
		
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
		displayGuess.getEndGameConfirmation(core.getGuess(), core.getGuessIteration());
	}
}
