package main;

/**
 * Class which handles email creation for a new user in the tinkertown company.
 * It constructs all the necesary parameters for doing so, taking as input only
 * the first name and last name of the user. Main interaction class.
 * 
 * @author babycakes
 *
 */
public class Email {

	EmailGenerator eg = new EmailGenerator();

	public final int mailboxCapacity;
	public final String companySuffix = "tinkertown.com";
	String password;
	String firstName;
	String lastName;
	String department;
	String alternateEmail;

	String email;

	/**
	 * Constructor of the class Email, constructing the variables needed for email
	 * creation.
	 * 
	 * @param firstName String: First name of the user.
	 * @param lastName  String: Last name of the user.
	 */
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailboxCapacity = 1000;
		this.password = eg.askPassword();
		this.department = eg.askDepartment();
		this.alternateEmail = eg.askAlternativeEmail();

		email = this.generateEmail();
	}

	/**
	 * Method which generates the user's email based on the collected information.
	 * 
	 * @return String: Email of the new user.
	 */
	public String generateEmail() {

		StringBuffer email = new StringBuffer();
		email.append(firstName.toLowerCase());
		email.append(".");
		email.append(lastName.toLowerCase());
		email.append("@");
		email.append(department);
		email.append(companySuffix);

		return email.toString();
	}

	/**
	 * Method to display the user information.
	 */
	public void displayUserInfo() {
		System.out.println(firstName + "\n" + lastName + "\n" + this.password + "\n" + this.email);
	}

	/**
	 * Method which displays the email of the user.
	 */
	@Override
	public String toString() {
		return this.email;
	}

}
