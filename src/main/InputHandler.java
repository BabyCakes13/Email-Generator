package main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class which handles input from the user.
 * 
 * @author babycakes
 *
 */
public class InputHandler {

	Scanner scan;

	/**
	 * Construtor of the class, which initialises a scanner for user console input.
	 */
	public InputHandler() {
		scan = new Scanner(System.in);
	}

	/**
	 * Method which asks the user for the ID of the department.
	 * 
	 * @return int: The ID of the department, or -1 if the reading failed due to
	 *         wrong arguemnts given.
	 */
	public int askDepartmentID() {
		int departmentID = -1;

		try {
			System.out.println("Please enter the ID of the department.");
			departmentID = Integer.parseInt(scan.nextLine());

			if (departmentID < 0) {
				throw new IllegalArgumentException("The department ID must be positive.\n");
			}
		} catch (NumberFormatException e) {
			System.out.println("The input must be a positive number.");
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.out.println("The department ID must be an integer.\n");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return departmentID;
	}

	/**
	 * Method which reads a password from the console. Used for current and new
	 * password reading.
	 * 
	 * @param message:      String: The message to be displayed before reading.
	 * @param characterSet: String:The set of allowed characters.
	 * @return String: String: The password read from the console, empty String in
	 *         case of failure.
	 */
	public String askPassword(String message, String characterSet) {
		System.out.println(message);
		String password = "";

		try {
			password = scan.nextLine();
			if (!password.matches("[a-zA-Z0-9]*")) {
				throw new IllegalArgumentException(
						"The password must contain only characters from the available set: " + characterSet);
			}
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return password;
	}

	/**
	 * Method which asks the user if they want to provide an alternate email for the
	 * new accound.
	 * 
	 * @return boolean: True if the user answers Y, false otherwise. Raises
	 *         exception if neither Y nor n are used.
	 */
	public boolean alternateEmailOption() {
		System.out.println("Do you want to provide an alternate e-mail? Y/n (yes, no)");
		try {
			String response = scan.nextLine();
			if (response.equals("Y")) {
				return true;
			} else if (response.equals("n")) {
				return false;
			} else {
				throw new InputMismatchException("You have to pick between Y or n (yes, no)");
			}
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Method which reads the users alternate email if opted so.
	 * 
	 * @return String: The alternative email of the user.
	 */
	public String askAlternateEmail() {
		String alternateEmail = "";

		if (alternateEmailOption()) {
			System.out.println("Please enter your alternative email:");
			try {
				alternateEmail = scan.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Could not complete. Invalid email.");
			}
		}

		return alternateEmail;
	}
}
