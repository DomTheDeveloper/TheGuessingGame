package edu.oakland.classProject.test;

import edu.oakland.classProject.production.ICore;

/**
* This class implements the ICore interface for use in testing with Main
*@author
*@version 1.0 150816
*@since 1.0 150816
*/
public class MockCore implements ICore {
    int upperBoundInput;
    int upperBoundComputed;
    int maxNumOfGuesses;
    boolean hasGameEnded;
    int guess;
    int guessIteration;
    String guessFeedbackSelection;
    boolean reinitialized;

    public void reinitialize(){
        reinitialized = true;
    }
    public boolean isReinitialized(){
        return reinitialized;
    }
    public void setUpperBoundInput(int _upperBoundInput){
        upperBoundInput = _upperBoundInput;
    }
    public int getUpperBoundInput(){
        return upperBoundInput;
    }
    public void setUpperBoundComputed(int _upperBoundComputed){
        upperBoundComputed = _upperBoundComputed;
    }
    public int getUpperBoundComputed(){
        return upperBoundComputed;
    }
    public void setMaxNumOfGuesses(int _maxNumOfGuesses){
        maxNumOfGuesses = _maxNumOfGuesses;
    }
    public int getMaxNumOfGuesses(){
        return maxNumOfGuesses;
    }
    public void setHasGameEnded(boolean _hasGameEnded){
        hasGameEnded = _hasGameEnded;
    }
    public boolean getHasGameEnded(){
        return hasGameEnded;
    }
    public void computeGuess(){
        /// Use setGuess(int _guess)
    }
    public void setGuess(int _guess){
        guess = _guess;
    }
    public int getGuess(){
        return guess;
    }
    public void setGuessIteration(int _guessIteration){
        guessIteration = _guessIteration;
    }
    public int getGuessIteration(){
        return guessIteration;
    }
    public void setGuessFeedbackSelection(String _guessFeedbackSelection){
        guessFeedbackSelection = _guessFeedbackSelection;
    }
    public String getGuessFeedbackSelection(){
        return guessFeedbackSelection;
    }
}
