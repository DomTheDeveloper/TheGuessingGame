package edu.oakland.classProject.production;

/** ICore class represents the interface that Core must implement
    The two classes that depend on this class are Core and MockCore
    Core actually computes these functions based on the SLRq while
    MockCore uses db style getters and setters to ensure the MainTest
    passes the JUnit tests
*/
public interface ICore {
    /**
     * Resets the current game session
     */
    public void reinitialize();
    /**
     * Sets the upper bound for the current session
     * @param upperBoundInput the upper bound
     */
    public void setUpperBoundInput(int upperBoundInput);
    /**
     * A getter for the upper bound
     * @return the upper bound
     */
    public int getUpperBoundComputed();
    /**
     * A getter for the max number of guesses
     * @return the max number of guesses needed by the app for the selected upper bound
     */
    public int getMaxNumOfGuesses();
    /**
     * A getter for the end status of the current game session
     * @return Returns whether the game has ended
     */
    public boolean getHasGameEnded();
    /**
     * Has core compute the next guess based on class variables
     */
    public void computeGuess();
    /**
     * A getter for the current guess
     * @return the current guess made by the app
     */
    public int getGuess();
    /**
     * A getter for the current guess iteration
     * @return the current guess iteration
     */
    public int getGuessIteration();
    /**
     * A setter for the current user feedback
     * @param guessFeedbackSelection the feedback given by the display telling Core wheter the user said their guess was higher or lower
     */
    public void setGuessFeedbackSelection(String guessFeedbackSelection);
}
