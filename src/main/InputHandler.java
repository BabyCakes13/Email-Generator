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
	 * Construtor of the class, initialising a scanner for input reading from the
	 * console.
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
			departmentID = scan.nextInt();

			if (departmentID < 0) {
				throw new IllegalArgumentException("The department ID must be positive.\n");
			}
		} catch (InputMismatchException e) {
			System.out.println("The department ID must be an integer.\n");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			scan.close();
		}

		return departmentID;
	}
}
