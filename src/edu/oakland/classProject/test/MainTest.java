package edu.oakland.classProject.test;

import edu.oakland.classProject.production.*;
import edu.oakland.classProject.production.cmdLine.*;
import java.util.Arrays.*;
import junit.framework.*;
/**
* This class holds all of the JUnit test cases for testing the Main class using mock Display and Core classes.
* @version: v1.0 20150816
*/

public class MainTest extends TestCase{
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
	* Tests if startGame() with a user input of simple properly initializes values in core, and computes the upper range and max number of guesses.
	*/
	public void testStartGame_Simple(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('S');

		MockCore core = new MockCore();
		core.setMaxNumOfGuesses(maxNumOfGuesses_Simple);
		core.setUpperBoundComputed(upperBoundComputed_Simple);

		Main main = new Main(display, core);

		assertTrue(main.startGame());
		assertEquals(maxNumOfGuesses_Simple, display.getMaxNumOfGuesses());
		assertEquals(upperBoundComputed_Simple,display.getUpperBoundComputed());

		assertTrue(core.isReinitialized());
	}
	/**
	* Tests if startGame() with a user input of advanced properly initializes values in core, and computes the upper range and max number of guesses.
	*/
	public void testStartGame_Advanced(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('A');
		display.setUpperBoundSelection(maxNumOfGuesses_Advanced);

		MockCore core = new MockCore();
		core.setMaxNumOfGuesses(maxNumOfGuesses_Advanced);
		core.setUpperBoundComputed(upperBoundComputed_Advanced);

		Main main = new Main(display, core);

		assertTrue(main.startGame());
		assertEquals(maxNumOfGuesses_Advanced, display.getMaxNumOfGuesses());
		assertEquals(upperBoundComputed_Advanced, display.getUpperBoundComputed());

		assertTrue(core.isReinitialized());
		assertEquals(core.getUpperBoundInput(), display.getUpperBoundSelection());
	}
	/**
	* Tests if startGame() returns false when given a user input of quit.
	*/
	public void testQuit(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('Q');

		MockCore core = new MockCore();

		Main main = new Main(display, core);

		assertFalse(main.startGame());

		assertTrue(core.isReinitialized());
	}
	/**
	* Tests if makeGuess() returns false when a guess should not be made
	*/
	public void testMakeGuess_GuessNotMade(){
		MockDisplay display = new MockDisplay();

		MockCore core = new MockCore();
		core.setHasGameEnded(true);

		Main main = new Main(display, core);

		assertFalse(main.makeGuess());
	}
	/**
	* Tests if makeGuess() calculates the correct values for the initial guess and initial guess iteration and returns false
	*/
	public void testMakeGuess_InitialGuess(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('S');

		MockCore core = new MockCore();
		core.setHasGameEnded(false);
		core.setGuess(initialGuess);
		core.setGuessIteration(initialGuessIteration);

		Main main = new Main(display, core);

		main.startGame();

		assertTrue(main.makeGuess());
		assertEquals(initialGuess,display.getCurrentGuess());
		assertEquals(initialGuessIteration,display.getCurrentGuessIteration());
	}
	/**
	* Tests if makeGuess() is able to properly make subsequent guesses
	*/
	public void testMakeGuess_SubsequentGuess(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('S');
		display.setGuessFeedback(guessFeedback);

		MockCore core = new MockCore();
		core.setHasGameEnded(false);
		core.setGuess(subsequentGuess);
		core.setGuessIteration(subsequentGuessIteration);

		Main main = new Main(display, core);

		main.startGame();
		main.makeGuess();
		main.giveFeedback();

		assertTrue(main.makeGuess());
		assertEquals(subsequentGuess,display.getCurrentGuess());
		assertEquals(subsequentGuessIteration,display.getCurrentGuessIteration());
	}
	/**
	* Tests if endGame() displays the correct end guess and end guess iteration values when the game has ended
	*/
	public void testEndGame(){
		MockDisplay display = new MockDisplay();

		MockCore core = new MockCore();
		core.setGuess(endGuess);
		core.setGuessIteration(endGuessIteration);

		Main main = new Main(display, core);

		main.endGame();

		assertEquals(endGuess, display.getEndGuess());
		assertEquals(endGuessIteration, display.getEndGuessIteration());
	}
}
