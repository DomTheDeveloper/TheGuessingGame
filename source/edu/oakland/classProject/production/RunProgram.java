package edu.oakland.classProject.production;

import edu.oakland.classProject.production.Display;
import edu.oakland.classProject.production.Main;

public class RunProgram{
	
	public static void main(String[] args){
		Display display = new Display();
		Main main = new Main(display);
		
		main.execute();
	}
}

