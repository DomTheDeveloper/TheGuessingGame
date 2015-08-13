package edu.oakland.classProject.production;

public interface IDisplay {
	public char getPlaySelection();
	public int getUpperBoundSelection();
	public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses);
	public void displayGuessInfo(int currentGuess, int currentGuessIteration);
	public char getGuessFeedback();
	public void getEndGameConfirmation(int guess, int guessIteration);
}
