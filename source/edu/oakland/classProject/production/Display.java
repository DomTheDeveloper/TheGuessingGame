package edu.oakland.classproject.production

import java.util.*;
import java.io.*;

/**
*This class holds the methods involved with displaying the command line interface.
*@author Bart Tokarz / Ashley Taylor
*@version "version 0.1" "150803"
*/
public class Display {
	/**
	*TODO: class variable definitions here
	*/
	Scanner input = new Scanner(System.in);
	char playOrQuit;
	/**
	*TODO: make sure to define each method's functionality
	*/
	public void displayWelcomeMessage() {
		System.out.println("Welcome to The Guessing Game!");
		System.out.println("-----------------------------");
		System.out.println("Select an option:");
		System.out.println("[P]: Play");
		System.out.println("[Q]: Quit");
		System.out.println();
		System.out.print(">");
	}
	
	public String getPlayOrQuit() {
		playOrQuit = input.nextChar();
		return playOrQuit;
	}
	
	public void displayBeginScreen () {
		System.out.println("Please think of a number between 1 and "core.getUpperBoundInput()".");
		System.out.println();
		System.out.println("Make sure you remember what your number is");
		System.out.println("and do not change it during the game.");
		System.out.println();
		System.out.println("");
	}
}
