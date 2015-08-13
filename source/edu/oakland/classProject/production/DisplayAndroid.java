package edu.oakland.classProject.production;

import edu.oakland.classProject.android.MainActivity;

public class DisplayAndroid implements IDisplay{

	/* All button clicks happen in MainActivity,
	In the button click methods, the main.activity() ie playGame(), makeGuess() is called (which calls the getters)
	*/
	public char getPlaySelection(){
		char playSelection;
		
		if (rbSimple.Checked)
			playSelection = 'S';
		else if (rbAdvanced.Checked)
			playSelection = 'A';
		else
			playSelection = 'Q';
		
		return playSelection;
	}
	public int getUpperBoundSelection(){
		int upperBoundSelection = ddlUpperBound.selectedValue; /// 512, 1024, ...
		
		return upperBoundSelection;
	}
	public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses){
		lblMaxNumOfGuesses.Text = String.format("The system will guess your number in %d guesses.", maxNumOfGuesses); /// 10, 11, ...
		
		return;
	}
	public char getGuessFeedback(int currentGuess, int currentGuessIteration){
		lblCurrentGuess.Text = Integer.toString(currentGuess);
		lblCurrentGuessIteration = Integer.toString(currentGuessIteration);
		
		char guessFeedback = btnFeedback_clicked.text; // +, -, or =
		return guessFeedback;
	}
	public void getEndGameConfirmation(int guess, int guessIteration){
		lblGameEnded.Visible = true;

		return;
	}
	
}