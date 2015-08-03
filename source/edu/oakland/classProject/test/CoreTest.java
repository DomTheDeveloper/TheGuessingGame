package edu.oakland.classproject.test

import edu.oakland.classproject.production.*;
import junit.framework.*;
/**
* CIT337 classProject
* This class holds all of the JUnit test cases for testing the Core class.
* CoreTest.java
* @author Casey Letarte ,Najuka Sakpal
* @version: v0.5 20150803
*/

public class testGame{
	
	/**
	This JUnit test package creates an instance of the game and then provides 
	simulated user input. The following 3 tests are used to show that the user
	number entered and the final correct guess are pulled from different places,
	that the number was guessed correctly in the maximum allowed amount of
	guesses or less, and that the program is calculating the right number of
	guesses based on the upperBound variable.	
	
	* userNumber = the number the user wants the game to try and guess without 
	               knowing upfront

	* numberGuessed = the number the game generates as a guess for each pass 
	                  until the number is guessed, the last  iteration is the 
	                  correct guess

	* testGuesses = 10, the minimum number of guesses required for the program 
	                to guess the number
	* currentGuess = a counter for the current guess count of the program that 
                     updates with each iteration of the guess cycle							
	* calcGuess = the calculated number of guesses, by the program, based on 
				  the upper bound given to the program
	*/
	private int testGuesses = 10;
	private int userNumber = 100;
	
	public setUp(){
	/**
	*TODO: definitions for class variables here
	*/
	/**
	*setUp() method initializes all variables before each test
	*/
	}
	
	public testGame(){
		/**
		*TODO: define more tests like this
		*/
		assertNotSame(userNumber, numberGuessed)    // prove that the entered 
													// number and the final 
													// (or approved guess) are 
													// equal, but the references
													// are not the same

		assertTrue(testGuesses >=  currentGuess)    // prove that it was guessed
													// in 10 tries or less

		assertTrue(testGuesses, calcGuesses)        // calculated number of 
													// guesses  matches the 
													// expected number of 
													// guesses.
	}
}