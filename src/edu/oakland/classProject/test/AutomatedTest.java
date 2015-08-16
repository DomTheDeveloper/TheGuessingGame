package edu.oakland.classProject.test;

import junit.framework.TestCase;

import edu.oakland.classProject.production.Main;

/**
* This class tests the robustness of the entire program by simulating how a user would play the game.
*@author
*@version 1.0 150816
*@since 1.0 150816
*/

public class AutomatedTest extends TestCase{
	
	/**
	* Tests the game functionality with one specific userNumber and upperBound
	*/
	public void testGameSingle(){
		int userNumber = 1000;
		int upperBoundInput = 10;
		AutomatedDisplay display = new AutomatedDisplay(userNumber, upperBoundInput);
		Main main = new Main(display);
		
		while(main.startGame()){
			while(main.makeGuess()){
				main.giveFeedback();
			}
			main.endGame();
		}
		assertEquals(display.getEndGuess(), userNumber);
	}

	/**
	* Tests the game functionality for every userNumber within a specified upperBound
	*/
	public void testGameAll(){
		int userNumber = 1;
		int upperBoundInput = 16;
		int upperBound = 65536;
		AutomatedDisplay display;
		Main main;
		while(userNumber < upperBound) {
			display = new AutomatedDisplay(userNumber, upperBoundInput);
			main = new Main(display);
			
			while(main.startGame()){
				while(main.makeGuess()){
					main.giveFeedback();
				}
				main.endGame();
			}
		assertEquals(display.getEndGuess(), userNumber);
		userNumber++;
		}
	}

	/**
	* Tests the game for a userNumber that is outside the upper bound
	*/
	public void testGameFail(){
		int userNumber = 1050;
		int upperBoundInput = 10;
		AutomatedDisplay display = new AutomatedDisplay(userNumber, upperBoundInput);
		Main main = new Main(display);
		
		while(main.startGame()){
			while(main.makeGuess()){
				main.giveFeedback();
			}
			main.endGame();
		}
		assertFalse(userNumber == display.getEndGuess());
	}
}
