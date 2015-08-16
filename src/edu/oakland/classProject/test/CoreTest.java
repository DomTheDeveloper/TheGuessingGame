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
	
	public void testComputeMaxNumOfGuessesBasic(){
		Core core = new Core();
		assertEquals(testMaxNumOfGuessesBasic,core.getMaxNumOfGuesses());		
	}
	public void testComputeMaxNumOfGuessesAdvanced(){
		Core core = new Core();
		core.setUpperBoundInput(testMaxNumOfGuessesAdvanced);
		int maxNumOfGuesses = core.getMaxNumOfGuesses();
		assertEquals(testMaxNumOfGuessesAdvanced,maxNumOfGuesses);		
	}
	public void testComputeInitialGuess(){
		Core core = new Core();
		core.computeGuess();
		int numberGuessed = core.getGuess();
		assertEquals(testInitialGuess,numberGuessed);
	}	
	public void testComputeSubsequentGuess_Higher(){
		Core core = new Core();
		core.computeGuess();
		core.setGuessFeedbackSelection("higher");
		core.computeGuess();
		int numberGuessed = core.getGuess();
		assertEquals(testSubsequentGuess_Higher,numberGuessed);
	}
	public void testComputeSubsequentGuess_Lower(){
		Core core = new Core();
		core.computeGuess();
		core.setGuessFeedbackSelection("lower");
		core.computeGuess();
		int numberGuessed = core.getGuess();
		assertEquals(testSubsequentGuess_Lower,numberGuessed);
	}
	public void testGuessIteration(){
		Core core = new Core();
		
		for (int i=0; i < testGuessIterations; i++){
			core.computeGuess();
		}
		
		int guessIteration = core.getGuessIteration();
		assertEquals(testGuessIterations,guessIteration);
	}
	public void testHasGameEnded_False(){
		Core core = new Core();
		core.computeGuess();
		boolean hasGameEnded = core.getHasGameEnded();
		assertFalse(hasGameEnded);
	}
	public void testHasGameEnded_Equal(){
		Core core = new Core();
		core.computeGuess();
		core.setGuessFeedbackSelection("equal");
		boolean hasGameEnded = core.getHasGameEnded();
		assertTrue(hasGameEnded);
	}
	public void testHasGameEnded_MaxNumOfGuessesExceeded(){
		Core core = new Core();
		core.setUpperBoundInput(1);
		core.getMaxNumOfGuesses();
		core.computeGuess();
		core.setGuessFeedbackSelection("equal");
		boolean hasGameEnded = core.getHasGameEnded();
		assertTrue(hasGameEnded);
	}
	public void testGetUpperBoundComputed(){
		Core core = new Core();
		core.setUpperBoundInput(testUpperBoundInput);
		int upperBoundComputed = core.getUpperBoundComputed();
		assertEquals(testUpperBoundComputed, upperBoundComputed);
	}
}