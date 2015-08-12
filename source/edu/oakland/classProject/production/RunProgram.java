package edu.oakland.classProject.production;

import edu.oakland.classProject.production.Display;
import edu.oakland.classProject.production.Core;
import edu.oakland.classProject.production.Main;

public class RunProgram{
	
	public static void main(String[] args){
		Display display = new Display();
		Core core = new Core();
		Main main = new Main();
		main.execute();
	}
}