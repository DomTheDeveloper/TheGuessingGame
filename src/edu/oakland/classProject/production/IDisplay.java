package edu.oakland.classProject.production;

/**
 * IDisplay represents the interface that the UI must implement.
 */
public interface IDisplay{
    /**
     * Getter for the simple or advanced game session options
     * @return the play selection
     */
    char getPlaySelection();
    /**
     * Getter for the upper bound
     * @return the upper bound
     */
    int getUpperBoundSelection();
    /**
     * Shows the user the upper bound and max number of guesses for the current game session
     * @param upperBoundComputed the upper bound for the current game session
     * @param maxNumOfGuesses the max number of guesses for the current game session
     */
    void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses);
    /**
     * Displays the current guess and the current guess iteration
     * @param currentGuess the current guess
     * @param currentGuessIteration the current guess iteration
     */
    void displayGuessInfo(int currentGuess, int currentGuessIteration);
    /**
     * A getter for the current user feedback (higher or lower)
     * @return the current user feedback
     */
    String getGuessFeedback();
    /**
     * Displays the end game UI
     * @param guess the final answer for the game session
     * @param guessIteration the number of guesses it took to end the current game session
     */
    void getEndGameConfirmation(int guess, int guessIteration);
}
