package edu.oakland.classProject.test;

import edu.oakland.classProject.production.Core;

import junit.framework.*;
/**
* This class holds all of the JUnit test cases for testing the Core class.
* CoreTest.java
* @version: v1.0 20150815
*/
public class CoreTest extends TestCase{
	/*
	This JUnit test package creates an instance of the game and then provides 
	simulated user input. The following 3 tests are used to show that the user
	number entered and the final correct guess are pulled from different places,
	that the number was guessed correctly in the maximum allowed amount of
	guesses or less, and that the program is calculating the right number of
	guesses based on the upperBound variable.	
	*/
	private final int testMaxNumOfGuessesBasic = 10;
	private final int testMaxNumOfGuessesAdvanced = 7;
	private final int testGuessIterations = 3;
	private final int testMaxNumOfGuessesHasGameEnded = 10;
	private final int testCurrentGuessHasGameEnded = 10;
	private final int testInitialGuess = 512;
	private final int testSubsequentGuess_Higher = 768;
	private final int testSubsequentGuess_Lower = 256;
	private final int testUpperBoundInput = 10;
	private final int testUpperBoundComputed = 1023;

	/**
	* Tests if getMaxNumOfGuesses() returns the correct default number of guesses
	*/	
	public void testComputeMaxNumOfGuessesBasic(){
		Core core = new Core();
		assertEquals(testMaxNumOfGuessesBasic,core.getMaxNumOfGuesses());		
	}
	/**
	* Tests if getMaxNumOfGuesses() returns the correct number of guesses given a user defined upper bound
	*/
	public void testComputeMaxNumOfGuessesAdvanced(){
		Core core = new Core();
		core.setUpperBoundInput(testMaxNumOfGuessesAdvanced);
		int maxNumOfGuesses = core.getMaxNumOfGuesses();
		assertEquals(testMaxNumOfGuessesAdvanced,maxNumOfGuesses);		
	}
	/**
	* Tests if the initial guess is calcuated as expected
	*/
	public void testComputeInitialGuess(){
		Core core = new Core();
		core.computeGuess();
		int numberGuessed = core.getGuess();
		assertEquals(testInitialGuess,numberGuessed);
	}
	/**
	* Tests if the subsequent guess given a user input of higher is calculated as expected
	*/
	public void testComputeSubsequentGuess_Higher(){
		Core core = new Core();
		core.computeGuess();
		core.setGuessFeedbackSelection("higher");
		core.computeGuess();
		int numberGuessed = core.getGuess();
		assertEquals(testSubsequentGuess_Higher,numberGuessed);
	}
	/**
	* Tests if the subsequent guess given a user input of lower is calculated as expected
	*/
	public void testComputeSubsequentGuess_Lower(){
		Core core = new Core();
		core.computeGuess();
		core.setGuessFeedbackSelection("lower");
		core.computeGuess();
		int numberGuessed = core.getGuess();
		assertEquals(testSubsequentGuess_Lower,numberGuessed);
	}
	/**
	* Tests if the guessIteration is properly iterated after computing a guess
	*/
	public void testGuessIteration(){
		Core core = new Core();
		
		for (int i=0; i < testGuessIterations; i++){
			core.computeGuess();
		}
		
		int guessIteration = core.getGuessIteration();
		assertEquals(testGuessIterations,guessIteration);
	}
	/**
	* Tests if getHasGameEnded() returns false when the game has not ended
	*/
	public void testHasGameEnded_False(){
		Core core = new Core();
		core.computeGuess();
		boolean hasGameEnded = core.getHasGameEnded();
		assertFalse(hasGameEnded);
	}
	/**
	* Tests if getHasGameEnded() returns true if the user gives a feeback selection of equal
	*/
	public void testHasGameEnded_Equal(){
		Core core = new Core();
		core.computeGuess();
		core.setGuessFeedbackSelection("equal");
		boolean hasGameEnded = core.getHasGameEnded();
		assertTrue(hasGameEnded);
	}
	/**
	* Tests if getHasGameEnded() returns true if the max number of guesses has been reached
	*/
	public void testHasGameEnded_MaxNumOfGuessesExceeded(){
		Core core = new Core();
		core.setUpperBoundInput(1);
		core.getMaxNumOfGuesses();
		core.computeGuess();
		core.setGuessFeedbackSelection("equal");
		boolean hasGameEnded = core.getHasGameEnded();
		assertTrue(hasGameEnded);
	}
	/**
	* Tests if getUpperBoundComputed() returns the expected computed upper bound
	*/
	public void testGetUpperBoundComputed(){
		Core core = new Core();
		core.setUpperBoundInput(testUpperBoundInput);
		int upperBoundComputed = core.getUpperBoundComputed();
		assertEquals(testUpperBoundComputed, upperBoundComputed);
	}
}
