package edu.oakland.classProject.production;

/**
* This class defines the logic for the program flow of TheGuessingGame.
* It interfaces between Display and Core and mediates their interactions.
*@author 
*@version version 1.0 150816
*@since version 1.0
*/
public class Main{

	private IDisplay display;
	private ICore core;
	/**
	* Default constuctor for use in production
	*/
	public Main(IDisplay _display) {
		display = _display;
		core = new Core();
	}
	/**
	* Overloaded constructor used for testing
	*/
	public Main(IDisplay _display, ICore _core) {
        	display = _display;
        	core = _core;
	}
	
	/**
	* Defines the logic for starting the game
	* @return Returns true if the game is to start, false if the program is to exit
	*/
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
	/**
	* Defines the logic for making a guess using input from the user
	* @return Returns true if a guess is made, returns false if the game has ended and a guess is not made
	*/
	public boolean makeGuess(){
		if (core.getHasGameEnded())
			return false; /// do not make guess
			
		core.computeGuess();
		display.displayGuessInfo(core.getGuess(), core.getGuessIteration());
		
		return true;
	}
	/**
	* Calls display to get feedback from the user based on the guess displayed
	*/
	public void giveFeedback(){
		core.setGuessFeedbackSelection(display.getGuessFeedback());
	}
	/**
	* Calls display to show the game end screen
	*/
	public void endGame(){
		display.getEndGameConfirmation(core.getGuess(), core.getGuessIteration());
	}
}
