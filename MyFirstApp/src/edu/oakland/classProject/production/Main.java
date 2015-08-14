package edu.oakland.classProject.production;

import edu.oakland.classProject.production.Core;

public class Main{

	private Core core;
	
	public Main(){
		core = new Core();
	}

	public void restart() {
		core.initialize();
	}

	public int startGame(Integer upperBound){
		core.initialize();
		core.setUpperBound(upperBound);
		return core.getMaxNumGuesses();
	}
	
	public int makeGuess(String feedback){
		return core.computeGuess(feedback);
	}

	public boolean isFinished(){
		return core.isGameFini();
	}
	
	public int getIteration(){
		return core.getIteration();
	}
}
