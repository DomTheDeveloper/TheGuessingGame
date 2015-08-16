package edu.oakland.classProject.production;

public interface ICore {
    void reinitialize();
    void setUpperBoundInput(int upperBoundInput);
    int getUpperBoundComputed();
    int getMaxNumOfGuesses();
    boolean getHasGameEnded();
    void computeGuess();
    int getGuess();
    int getGuessIteration();
    void setGuessFeedbackSelection(String guessFeedbackSelection);
}
