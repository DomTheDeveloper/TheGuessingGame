package edu.oakland.classProject.test;

import edu.oakland.classProject.production.*;
import java.util.Arrays.*;
import junit.framework.*;
/**
* CIT337 classProject
* This class holds all of the JUnit test cases for testing the Core class.
* CoreTest.java
* @author Casey Letarte, Najuka Sakpal, Renee Wise
* @version: v0.8 20150810
*/

public class CoreTest extends TestCase{
	
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
//	private Core core;
//	private Main main;
//	private Display display;
	private String testPlay = "P";
	private int testGuesses = 10;
	private int calcGuesses=0;
	private int upperBound=0;
	private int currentGuess=0;
	private char testUserInput = '<';
	private int testUserNumber = 2;
	private static boolean testHasGameEnded = false;
	
	int[] testArray = {1024,512,256,128,64,32,16,8,4};
	
	/*
	testArray = new int[9];
	testArray[0]=1024;
	testArray[1]=512;
	testArray[2]=256;
	testArray[3]=128;
	testArray[4]=64;
	testArray[5]=32;
	testArray[6]=16;
	testArray[7]=8;
	testArray[8]=4;
	
	private int testUpperBound0=1023;
	private int testUpperBound1=511;
	private int testUpperBound2=255;
	private int testUpperBound3=127;
	private int testUpperBound4=63;
	private int testUpperBound5=31;
	private int testUpperBound6=15;
	private int testUpperBound7=7;
	private int testUpperBound8=3;
	*/
	
	public void setUp(){
		Display display = new Display();
	//	display.getUserNumber(testUserNumber);
	//	display.requestEnterSelection(testPlay);
	}
	
	public void testComputeMaxNumGuesses(){
		Core core = new Core();
	//	Main main = new Main(display, core);
		int maxNumGuesses = core.requestMaxNumGuesses();
		assertEquals(testGuesses,maxNumGuesses);		
	}
	
	
	/*
	
	public void testCalculatedGuesses(){
		calcGuesses = core.requestMaxNumGuesses();
		assertEquals(testGuesses, calcGuesses);        // calculated number of guesses  matches the 
								// expected number of guesses.
	}
	
	public void testUpperBound0(){
		
		for (int i=0; i <testArray.length ; ++i){
			assertEquals(testArray[i], core.requestUpperBoundComputed());
			
		}
	
		// upperBound = Main.upperBoundComputed();
		// assertEquals(testUpperBound0,upperBound);
				//this compares the initial calculated upperBound against the testUpperBound0
				//to verify that they are the same value and that the calculations are correct
	}
	/*
	public void testUserEntry0(){
		display.getUserInput(testUserInput); //this assumes that the game is asking
						// if the guess is larger or smaller than the user number
		assertTrue(testUserInput, main.getUserInput()); //compares the user input of "<"
						//with what the main() receives
	}
	
	public void testFinalGuessCount(){
		currentGuess = core.getGuessIteration();
		testHasGameEnded = core.requestHasGameEnded();
		assertTrue(testGuesses >= currentGuess);		// compares the number of guesses against the
								// expected number guesses and that they are true
		
		assertTrue(testHasGameEnded);	// asserting that the hasGameEnded does change to TRUE 
								// when the end of the game is reached
	}
	
/*
	public void testUpperBound1{
		upperBound = Main.upperBoundComputed();
		display.getUserInput(testUserInput); //this assumes that the game is asking
						// if the guess is larger or smaller than the user number
		assertTrue(testUpperBound1,upperBound);
				//this compares the initial calculated upperBound against the testUpperBound0
				//to verify that they are the same value and that the calculations are correct
	}
	
	public void testUpperBound2{
		upperBound = Main.upperBoundComputed();
		display.getUserInput(testUserInput); //this assumes that the game is asking
						// if the guess is larger or smaller than the user number
		assertTrue(testUpperBound2,upperBound);
				//this compares the initial calculated upperBound against the testUpperBound0
				//to verify that they are the same value and that the calculations are correct
	}
		
	public void testUpperBound3{
		upperBound = Main.upperBoundComputed();
		display.getUserInput(testUserInput); //this assumes that the game is asking
						// if the guess is larger or smaller than the user number
		assertTrue(testUpperBound3,upperBound);
				//this compares the initial calculated upperBound against the testUpperBound0
				//to verify that they are the same value and that the calculations are correct
	}
	
	public void testUpperBound4{
		upperBound = Main.upperBoundComputed();
		display.getUserInput(testUserInput); //this assumes that the game is asking
						// if the guess is larger or smaller than the user number
		assertTrue(testUpperBound4,upperBound);
				//this compares the initial calculated upperBound against the testUpperBound0
				//to verify that they are the same value and that the calculations are correct
	}
	
	public void testUpperBound5{
		upperBound = Main.upperBoundComputed();
		display.getUserInput(testUserInput); //this assumes that the game is asking
						// if the guess is larger or smaller than the user number
		assertTrue(testUpperBound5,upperBound);
				//this compares the initial calculated upperBound against the testUpperBound0
				//to verify that they are the same value and that the calculations are correct
	}
	
	public void testUpperBound6{
		upperBound = Main.upperBoundComputed();
		display.getUserInput(testUserInput); //this assumes that the game is asking
						// if the guess is larger or smaller than the user number
		assertTrue(testUpperBound6,upperBound);
				//this compares the initial calculated upperBound against the testUpperBound0
				//to verify that they are the same value and that the calculations are correct
	}
	
	public void testUpperBound7{
		upperBound = Main.upperBoundComputed();
		display.userinput(testUserInput); //this assumes that the game is asking
						// if the guess is larger or smaller than the user number
		assertTrue(testUpperBound7,upperBound);
				//this compares the initial calculated upperBound against the testUpperBound0
				//to verify that they are the same value and that the calculations are correct
	}
	
	public void testUpperBound8{
		
		display.userinput(testUserInput); //this assumes that the game is asking
						// if the guess is larger or smaller than the user number
		assertTrue(testUpperBound8,upperBound);
				//this compares the initial calculated upperBound against the testUpperBound0
				//to verify that they are the same value and that the calculations are correct
	}
	
	


	public void testUserNumberCompare{
		assertTrue(testUserNumber, finalNumberGuessed);		// compares the programs final guess	
								// with the user's number entered
	}
	
	public void testReferenceVariable{
		assertNotSame(testUserNumber, finalNumberGuessed); // compares the references of the two variables		
								// to show that they are from separate references and that the game is not cheating
	}
*/
}