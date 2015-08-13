package edu.oakland.classProject.production;

public interface IDisplayGuess {
	public void displayGuessInfo(int currentGuess, int currentGuessIteration);
	public char getGuessFeedback();
	public void getEndGameConfirmation(int guess, int guessIteration);
}
