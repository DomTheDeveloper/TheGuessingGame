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

	public void testStartGame_Simple(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('S');

		Main main = new Main(display);

		assertTrue(main.startGame());
		assertEquals(10,display.getMaxNumOfGuesses());
		assertEquals(1023,display.getUpperBoundComputed());
	}
	public void testStartGame_Advanced(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('A');
		display.setUpperBoundSelection(9);

		Main main = new Main(display);
		assertTrue(main.startGame());
		assertEquals(9,display.getMaxNumOfGuesses());
		assertEquals(511,display.getUpperBoundComputed());
	}
	public void testQuit(){
		MockDisplay display = new MockDisplay();
		display.setPlaySelection('Q');

		Main main = new Main(display);
		assertFalse(main.startGame());
	}

}