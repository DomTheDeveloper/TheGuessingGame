package edu.oakland.classProject.production;

public interface IDisplay{
    char getPlaySelection();
    int getUpperBoundSelection();
    void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses);
    void displayGuessInfo(int currentGuess, int currentGuessIteration);
    String getGuessFeedback();
    void getEndGameConfirmation(int guess, int guessIteration);
}