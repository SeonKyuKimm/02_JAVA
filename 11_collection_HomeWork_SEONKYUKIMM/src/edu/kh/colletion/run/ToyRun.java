package edu.kh.colletion.run;

import edu.kh.collection.service.ToyFactory;

public class ToyRun {

	public static void main(String[] args) {
		
		ToyFactory toyF = new ToyFactory();
		
		toyF.displayMenu();
	}
}
