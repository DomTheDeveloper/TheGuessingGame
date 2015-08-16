package edu.oakland.classProject.test;

import edu.oakland.classProject.production.IDisplay;

public class MockDisplay implements IDisplay {

    char playSelection;
    int upperBoundSelection;

    int upperBoundComputed;
    int maxNumOfGuesses;

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
    public void displayGuessInfo(int currentGuess, int currentGuessIteration){

    }
    public String getGuessFeedback(){
        return "a";
    }
    public void getEndGameConfirmation(int guess, int guessIteration){
    }
}
