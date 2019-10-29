package main;

import email_objects.DepartmentHandler;
import email_objects.Password;

public class EmailGenerator {

	InputHandler ih;

	/**
	 * Constructor which initialises the input handler used in communicating with
	 * the user.
	 */
	public EmailGenerator() {
		this.ih = new InputHandler();
	}

	/**
	 * Method to retrieve the name of the ID department got as input from the user.
	 * 
	 * @return String: The name of the department corresponding to the entered ID.
	 *         Empty string otherwise.
	 */
	public String askDepartment() {
		DepartmentHandler dh = new DepartmentHandler();

		DepartmentHandler.displayDepartments();
		dh.setChosenID(ih.askDepartmentID());
		return dh.getSearchedDepartmentName();
	}

	/**
	 * Method to ask the user if they want to provide an alternate e-mail.
	 * 
	 * @return String: An alternate email. Empty String if the answer is no.
	 */
	public String askAlternativeEmail() {
		String alternateEmail = ih.askAlternateEmail();
		return alternateEmail;
	}

	/**
	 * Method to generate a random password of fixed length for the new user e-mail.
	 * 
	 * @return String: A random generated password of fixed length.
	 */
	public String askPassword() {
		Password password = new Password();
		return password.generateRandomPassword();
	}

}
