package edu.oakland.classProject.production;

public interface IDisplayStart {
	public char getPlaySelection();
	public int getUpperBoundSelection();
	public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses);
}
