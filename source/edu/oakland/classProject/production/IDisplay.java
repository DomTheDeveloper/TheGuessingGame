package edu.oakland.classProject.production;

public interface IDisplay {
	public char getPlaySelection();
	public int getUpperBoundSelection();
	public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses);
	public char getGuessFeedback(int currentGuess, int currentGuessIteration);
	public void getEndGameConfirmation(int guess, int guessIteration);
}
