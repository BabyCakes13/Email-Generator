package main;

import email_objects.DepartmentHandler;

public class Main {

	public static void main(String[] args) {
		inputApp();
	}

	public static void inputApp() {
		InputHandler ih = new InputHandler();
		int chosenID = ih.askDepartmentID();
		
		DepartmentHandler dh = new DepartmentHandler(chosenID);
		dh.searchID();

	}

}
