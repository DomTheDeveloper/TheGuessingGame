package edu.oakland.classProject.test;

import edu.oakland.classProject.production.*;
import edu.oakland.classProject.production.cmdLine.*;
import java.util.Arrays.*;
import junit.framework.*;
/**
* CIT337 classProject
* This class holds all of the JUnit test cases for testing the Core class.
* CoreTest.java
* @version: v0.8 20150810
*/

public class MainTest extends TestCase{
	
	/*
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
	private Main main;
	private Display display;
	private boolean gameEnded;
	private int upperBound; 
	private int calcBound;
	private int maxGuesses; 
	private int guessedNumber;
	private int prevGuess;
	private int curGuess;
	private String feedbackSel;
	
	
	
	public void setUp(){
	
	gameEnded = false;
	upperBound = 0; 
	calcBound = 0;
	maxGuesses = 0; 
	guessedNumber = 0;
	prevGuess = 0;
	curGuess = 0;
	String feedbackSel = "";
	
	}
	
	public void testCalculatedGuesses(){
	
		gameEnded = false;
		upperBound = 1024; 
		calcBound = 1023;
		maxGuesses = 0; 
		guessedNumber = 0;
		prevGuess = 0;
		curGuess = 0;
		String feedbackSel = "";
		
		Display display = new Display();
		Core core = new Core(gameEnded, upperBound, calcBound, maxGuesses, 
		guessedNumber, prevGuess, curGuess, feedbackSel);
		Main main = new Main(display);
		
		assertEquals(10, core.requestMaxNumGuesses());
	}

	public void testStartGame(){
	
		gameEnded = false;
		upperBound = 1024; 
		calcBound = 0;
		maxGuesses = 0; 
		guessedNumber = 0;
		prevGuess = 0;
		curGuess = 0;
		String feedbackSel = "";
		
		Display display = new Display();
		Core core = new Core(gameEnded, upperBound, calcBound, maxGuesses, 
		guessedNumber, prevGuess, curGuess, feedbackSel);
		Main main = new Main(display);
		main.startGame();
		
		//assertEquals(10, core.getMaxNumOfGueses());
		//assertEquals(1023, main.upperBoundComputed);
	}
	
	public void testMakeGuess(){
	
		gameEnded = false;
		upperBound = 1024; 
		calcBound = 0;
		maxGuesses = 0; 
		guessedNumber = 0;
		prevGuess = 0;
		curGuess = 0;
		String feedbackSel = "";
		
		Display display = new Display();
		Core core = new Core(gameEnded, upperBound, calcBound, maxGuesses, 
		guessedNumber, prevGuess, curGuess, feedbackSel);
		Main main = new Main(display);
		main.startGame();
		main.makeGuess();
		
		//assertEquals(1, main.currentGuessIteration);
		//assertEquals(512, main.currentGuess);
		//assertEquals(1023, displaystart.guessFeedback); // make another
	}
		

}