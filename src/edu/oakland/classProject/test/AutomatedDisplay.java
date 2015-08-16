package edu.oakland.classProject.test;

import edu.oakland.classProject.production.IDisplay;

/**
* This class implements the IDisplay interface for testing with Main and Core.
*@author
*@version 1.0 150816
*@since 1.0 150816
*/
public class AutomatedDisplay implements IDisplay {

    int userNumber;
    int upperBound;
    int currentGuess;
    int currentGuessIteration;
    int endGuess;
    boolean firstPlay = true;

    public AutomatedDisplay(int _userNumber, int _upperBound){
	userNumber = _userNumber;
	upperBound = _upperBound;
    }
    public char getPlaySelection(){
	if (firstPlay) {
		firstPlay = false;
		return 'A';
	} else {
		return 'Q';
	}
    }
    public int getUpperBoundSelection(){
        return upperBound;
    }
    public void getUserConfirmation(int _upperBoundComputed, int _maxNumOfGuesses){
    }
    public void displayGuessInfo(int _currentGuess, int _currentGuessIteration){
        currentGuess = _currentGuess;
        currentGuessIteration = _currentGuessIteration;
    }
    public String getGuessFeedback(){
	if (userNumber > currentGuess) {
		return "higher";
	} else if (userNumber < currentGuess) {
		return "lower";
	} else {
		return "equal";
	}
    }
    public void getEndGameConfirmation(int _guess, int _guessIteration){
        endGuess = _guess;
    }
    public int getEndGuess(){
        return endGuess;
    }
}
