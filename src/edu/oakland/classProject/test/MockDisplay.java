package edu.oakland.classProject.test;

import edu.oakland.classProject.production.IDisplay;

public class MockDisplay implements IDisplay {

    private char playSelection;
    private int upperBoundSelection;

    private int upperBoundComputed;
    private int maxNumOfGuesses;

    private int currentGuess;
    private int currentGuessIteration;

    private String guessFeedback;

    private int endGuess;
    private int endGuessIteration;

    public void setPlaySelection(char _playSelection){
        playSelection = _playSelection;
    }
    public char getPlaySelection(){
        return playSelection;
    }
    public void setUpperBoundSelection(int _upperBoundSelection){
        upperBoundSelection = _upperBoundSelection;
    }
    public int getUpperBoundSelection(){
        return upperBoundSelection;
    }
    public void getUserConfirmation(int _upperBoundComputed, int _maxNumOfGuesses){
        upperBoundComputed = _upperBoundComputed;
        maxNumOfGuesses = _maxNumOfGuesses;
    }
    public int getUpperBoundComputed(){
        return upperBoundComputed;
    }
    public int getMaxNumOfGuesses(){
        return maxNumOfGuesses;
    }
    public void displayGuessInfo(int _currentGuess, int _currentGuessIteration){
        currentGuess = _currentGuess;
        currentGuessIteration = _currentGuessIteration;
    }
    public int getCurrentGuess(){
        return currentGuess;
    }
    public int getCurrentGuessIteration(){
        return currentGuessIteration;
    }
    public void setGuessFeedback(String _guessFeedback){
        guessFeedback = _guessFeedback;
    }
    public String getGuessFeedback(){
        return guessFeedback;
    }
    public void getEndGameConfirmation(int _guess, int _guessIteration){
        endGuess = _guess;
        endGuessIteration = _guessIteration;
    }
    public int getEndGuess(){
        return endGuess;
    }
    public int getEndGuessIteration(){
        return endGuessIteration;
    }
}
