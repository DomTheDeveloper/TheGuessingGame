package edu.oakland.classProject.production;

public class DisplayAndroid implements IDisplay{

	char guessFeedback;

	public char getPlaySelection(){
		char playSelection;
		
		if (rbSimple.Checked)
			playSelection = 'S';
		else /// if (rbAdvanced.Checked)
			playSelection = 'A';
		
		return playSelection;
	}
	public int getUpperBoundSelection(){
		int upperBoundSelection;
		
		upperBoundSelection = ddlUpperBound.selectedValue;
		
		return upperBoundSelection;
	}
	public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses){
		lblMaxNumOfGuesses.Text = String.format("The system will guess your number in %d guesses.", maxNumOfGuesses);
		
		return;
	}
	public void setGuessFeedback(char _guessFeedback){
		guessFeedback = _guessFeedback;
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