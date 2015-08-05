package edu.oakland.classproject.production;

import java.util.*;
import java.io.*;

/**
*This class holds the methods involved with displaying the command line interface.
*@author Bart Tokarz / Ashley Taylor
*@version "version 0.0.2" "150803"
*/
public class Display {
	/**
	*TODO: class variable definitions here
	*/
	Scanner input = new Scanner(System.in);
	/**
	*TODO: make sure to define each method's functionality
	*/
	public char displayWelcomeMessage() {
		System.out.println("Welcome to The Guessing Game!");
		System.out.println("-----------------------------");
		System.out.println("Select an option:");
		System.out.println("[P]: Play");
		System.out.println("[Q]: Quit");
		System.out.println();
		System.out.print(">");
		char playOrQuit = input.nextChar();
		return playOrQuit.toUpperCase();
	}
	
	public int displayRequestUpperBound(){
		System.out.println("Enter a value for a custom upper bound or press [ENTER]");
		System.out.println("to accept the default value of 1024.");
		System.out.println("The value must be a positive whole number greater than 1.");
		int userUpperBound = input.nextInt();
		return userUpperBound;
	}
	
	public void displayBeginScreen (int calculatedUpperRange, int maxNumGuesses) {
		System.out.println("Please think of a number between 1 and " + calculatedUpperRange.toString() + ".");
		System.out.println();
		System.out.println("Make sure you remember what your number is");
		System.out.println("and do not change it during the game.");
		System.out.println();
		System.out.println("The game will guess what your number is within " + maxNumGuesses.toString() + "guesses or less.");
		System.out.println();
		System.out.println("Press any key when you are ready to begin the game!");
		char beginGame = input.nextChar();
	}
	
	public char displayGameScreen () {
		System.out.println("");
	}
	
}
