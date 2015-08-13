package edu.oakland.classProject.production;

public class DisplayAndroid implements IDisplay{

	char guessFeedback;
	int upperBoundSelection;
	char playSelection;
	
	/* All button clicks happen in MainActivity,
	In the button click methods,
		- the set methods are called
		- the main.activity() ie playGame(), makeGuess() is called (which calls the getters)
	*/

	public void setPlaySelection(RadioButton rbSimple, RadioButton rbAdvanced){
		if (rbSimple.Checked)
			playSelection = 'S';
		else if (rbAdvanced.Checked)
			playSelection = 'A';
		else
			playSelection = 'Q';
	}
	public char getPlaySelection(){
		return playSelection;
	}
	public void setUpperBoundSelection(DropDownList ddlUpperBound){	
		upperBoundSelection = ddlUpperBound.selectedValue;
	}
	public int getUpperBoundSelection(){
		return upperBoundSelection;
	}
	public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses){
		lblMaxNumOfGuesses.Text = String.format("The system will guess your number in %d guesses.", maxNumOfGuesses);
		
		return;
	}
	public void setGuessFeedback(Button btnFeedback){
		guessFeedback = btnFeedback.text;
	}
	public char getGuessFeedback(int currentGuess, int currentGuessIteration){
		lblCurrentGuess.Text = Integer.toString(currentGuess);
		lblCurrentGuessIteration = Integer.toString(currentGuessIteration);
		
		return guessFeedback;
	}
	public void getEndGameConfirmation(int guess, int guessIteration){
		lblGameEnded.Visible = true;

		return;
	}
	
}