package edu.oakland.classProject.test;

import edu.oakland.classProject.production.*;
import edu.oakland.classProject.production.cmdLine.*;
import java.util.Arrays.*;
import junit.framework.*;
/**
* This class holds all of the JUnit test cases for testing the Core class.
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
	public void testQuit(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('Q');

		MockCore core = new MockCore();

		Main main = new Main(display, core);

		assertFalse(main.startGame());

		assertTrue(core.isReinitialized());
	}
	public void testMakeGuess_GuessNotMade(){
		MockDisplay display = new MockDisplay();

		MockCore core = new MockCore();
		core.setHasGameEnded(true);

		Main main = new Main(display, core);

		assertFalse(main.makeGuess());
	}
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
	public void testMakeGuess_SubsequentGuess(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('S');
		display.setGuessFeedback("lower");

		MockCore core = new MockCore();
		core.setHasGameEnded(false);
		core.setGuess(subsequentGuess);
		core.setGuessIteration(subsequentGuessIteration);

		Main main = new Main(display, core);

		main.startGame();
		main.makeGuess();

		assertTrue(main.makeGuess());
		assertEquals(subsequentGuess,display.getCurrentGuess());
		assertEquals(subsequentGuessIteration,display.getCurrentGuessIteration());
	}
	public void testGiveFeedback(){
		MockDisplay display = new MockDisplay();
		display.setGuessFeedback("lower");

		MockCore core = new MockCore();

		Main main = new Main(display, core);

		main.giveFeedback();
		assertEquals("lower", core.getGuessFeedbackSelection());
	}
	public void testEndGame(){
		MockDisplay display = new MockDisplay();

		MockCore core = new MockCore();
		core.setGuess(1023);
		core.setGuessIteration(10);

		Main main = new Main(display, core);

		main.endGame();

		assertEquals(1023, display.getEndGuess());
		assertEquals(10, display.getEndGuessIteration());
	}
}