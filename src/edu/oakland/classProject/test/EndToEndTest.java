package edu.oakland.classProject.test;

import junit.framework.TestCase;

import edu.oakland.classProject.production.Main;

/**
* This class holds all of the JUnit test cases for testing the Core class.
* @version: v1.0 20150816
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

	public void testStartGame_Simple(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('S');

		Main main = new Main(display);

		assertTrue(main.startGame());
		assertEquals(maxNumOfGuesses_Simple, display.getMaxNumOfGuesses());
		assertEquals(upperBoundComputed_Simple, display.getUpperBoundComputed());
	}
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
	public void testQuit(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('Q');

		Main main = new Main(display);

		assertFalse(main.startGame());
	}
	public void testMakeGuess_GuessNotMade(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('A');
		display.setUpperBoundSelection(1);

		Main main = new Main(display);

		main.startGame();
		assertFalse(main.makeGuess());
	}
	public void testMakeGuess_InitialGuess(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('S');

		Main main = new Main(display);

		main.startGame();

		assertTrue(main.makeGuess());
		assertEquals(initialGuess,display.getCurrentGuess());
		assertEquals(initialGuessIteration,display.getCurrentGuessIteration());
	}
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
	public void testGiveFeedback(){
		MockDisplay display = new MockDisplay();
		display.setGuessFeedback(guessFeedback);

		Main main = new Main(display);

		main.giveFeedback();
		assertEquals(guessFeedback, display.getGuessFeedback());
	}
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