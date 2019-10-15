package main;

import email_objects.DepartmentHandler;
import email_objects.Password;

public class Main {

	public static void main(String[] args) {
		System.out.println(askDepartment());
	}
	
	/**
	 * Method to retrieve the name of the ID department got as input from the user.
	 * @return String: The name of the department corresponding to the entered ID. Empty string otherwise.
	 */
	public static String askDepartment() {
		InputHandler ih = new InputHandler();
		int chosenID = ih.askDepartmentID();
		
		DepartmentHandler dh = new DepartmentHandler(chosenID);
		return dh.getSearchedDepartmentName();
	}
	
	public static void passwordTest() {
		Password password = new Password();
		System.out.println(password.getPassword());
		password.setNewPassword();
		System.out.println(password.getPassword());
	}

	public static void inputApp() {
		InputHandler ih = new InputHandler();
		int chosenID = ih.askDepartmentID();
		
		DepartmentHandler dh = new DepartmentHandler(chosenID);
		String name = dh.getSearchedDepartmentName();
		System.out.println(name);

	}

}
