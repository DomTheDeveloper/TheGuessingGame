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

	public void testGame(){
		int userNumber = 1000;
		int upperBound = 10;
		AutomatedDisplay display = new AutomatedDisplay(userNumber, upperBound);
		Main main = new Main(display);
		
		while(main.startGame()){
			while(main.makeGuess()){
				main.giveFeedback();
			}
			main.endGame();
		}
		assertEquals(display.getEndGuess(), userNumber);
	}
}
