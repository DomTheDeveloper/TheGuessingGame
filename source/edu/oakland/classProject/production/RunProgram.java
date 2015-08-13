package edu.oakland.classProject.production;

import edu.oakland.classProject.production.DisplayCMD;
import edu.oakland.classProject.production.Main;

public class RunProgram{
	
	public static void main(String[] args){
		DisplayCMD displayCMD = new DisplayCMD();
		Main main = new Main(displayCMD);
		
		main.execute();
	}
}

