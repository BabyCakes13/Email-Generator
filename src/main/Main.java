package main;

import email_objects.DepartmentHandler;
import email_objects.Password;

public class Main {

	public static void main(String[] args) {
		passwordTest();
	}
	
	public static void passwordTest() {
		Password password =  new Password();
		System.out.println("Password is: " + password.generateRandomPassword(10));
	}

	public static void inputApp() {
		InputHandler ih = new InputHandler();
		int chosenID = ih.askDepartmentID();
		
		DepartmentHandler dh = new DepartmentHandler(chosenID);
		String name = dh.getSearchedDepartmentName();
		System.out.println(name);

	}

}
