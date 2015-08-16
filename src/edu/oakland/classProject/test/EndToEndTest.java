package edu.oakland.classProject.test;

import junit.framework.TestCase;

import edu.oakland.classProject.production.Main;

/**
* This class tests functionality of Main working with a real instance of Core and a mock Display.
*@author
*@version 1.0 150816
*@since 1.0 150816
*/

public class EndToEndTest extends TestCase{
	/*
	This JUnit test package creates an instance of the game and then provides 
	simulated user input. The following 3 tests are used to show that the user
	number entered and the final correct guess are pulled from different places,
	that the number was guessed correctly in the maximum allowed amount of
	guesses or less, and that the program is calculating the right number of
	guesses based on the upperBound variable.
	*/
	private int upperBoundComputed_Simple = 1023;
	private int maxNumOfGuesses_Simple = 10;

	private int upperBoundComputed_Advanced = 511;
	private int maxNumOfGuesses_Advanced = 9;

	private int initialGuess = 512;
	private int initialGuessIteration = 1;

	private int subsequentGuess = 256;
	private int subsequentGuessIteration = 2;

	private int endGuess = 1;
	private int endGuessIteration = 10;

	private String guessFeedback = "lower";

	/**
	* Tests if startGame() with a user input of simple gets correct values for the upper bound and max number of guesses and returns true.
	*/
	public void testStartGame_Simple(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('S');

		Main main = new Main(display);

		assertTrue(main.startGame());
		assertEquals(maxNumOfGuesses_Simple, display.getMaxNumOfGuesses());
		assertEquals(upperBoundComputed_Simple, display.getUpperBoundComputed());
	}
	/**
	* Tests if startGame() with a user input of advanced gets correct values for the upper bound and max number of guesses and returns true.
	*/
	public void testStartGame_Advanced(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('A');
		display.setUpperBoundSelection(maxNumOfGuesses_Advanced);

		Main main = new Main(display);

		assertTrue(main.startGame());
		assertEquals(maxNumOfGuesses_Advanced, display.getMaxNumOfGuesses());
		assertEquals(upperBoundComputed_Advanced, display.getUpperBoundComputed());

		assertEquals(maxNumOfGuesses_Advanced, display.getUpperBoundSelection());
	}
	/**
	* Tests if startGame() with a user input of quit returns false.
	*/
	public void testQuit(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('Q');

		Main main = new Main(display);

		assertFalse(main.startGame());
	}
	/**
	* Tests if makeGuess() returns false when a guess should not be made
	*/
	public void testMakeGuess_GuessNotMade(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('A');
		display.setUpperBoundSelection(1);

		Main main = new Main(display);

		main.startGame();
		assertFalse(main.makeGuess());
	}
	/**
	* Tests if makeGuess() gets correct values for the current guess and current guess iteration when making an initial guess and returns true.
	*/
	public void testMakeGuess_InitialGuess(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('S');

		Main main = new Main(display);

		main.startGame();

		assertTrue(main.makeGuess());
		assertEquals(initialGuess,display.getCurrentGuess());
		assertEquals(initialGuessIteration,display.getCurrentGuessIteration());
	}
	/**
	* Tests if makeGuess() gets correct values for the current guess and current guess iteration when making a subsequent guess and returns true.
	*/
	public void testMakeGuess_SubsequentGuess(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('S');
		display.setGuessFeedback(guessFeedback);

		Main main = new Main(display);

		main.startGame();
		main.makeGuess();
		main.giveFeedback();

		assertTrue(main.makeGuess());
		assertEquals(subsequentGuess,display.getCurrentGuess());
		assertEquals(subsequentGuessIteration,display.getCurrentGuessIteration());
	}
	/**
	* Tests if giveFeedback() gets the correct user input from Display
	*/
	public void testGiveFeedback(){
		MockDisplay display = new MockDisplay();
		display.setGuessFeedback(guessFeedback);

		Main main = new Main(display);

		main.giveFeedback();
		assertEquals(guessFeedback, display.getGuessFeedback());
	}
	/**
	* Tests if endGame() displays the correct values for the end guess and end guess iteration
	*/
	public void testEndGame(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('S');

		Main main = new Main(display);

		main.startGame();

		main.makeGuess();

		display.setGuessFeedback("lower");
		main.giveFeedback();
		assertTrue(main.makeGuess());

		display.setGuessFeedback("equal");
		main.giveFeedback();
		assertFalse(main.makeGuess());

		main.endGame();

		assertEquals(256, display.getEndGuess());
		assertEquals(2, display.getEndGuessIteration());
	}
}
