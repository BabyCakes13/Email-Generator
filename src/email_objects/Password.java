package email_objects;

import java.util.Random;

import main.InputHandler;

public class Password {

	private String password = "";
	private final static int PASSWORD_LENGTH = 10;
	private final String CHARACTER_SET;
	private final String currentPasswordMessage = "Please enter the current password:";
	private final String newPasswordMessage = "Please enter the new password:";

	/**
	 * Constructor of the Password class. Used for initialising final vairables and
	 * password.
	 */
	public Password() {
		CHARACTER_SET = buildCharacterSet();
		if (password == "") {
			password = generateRandomPassword();
		}
	}

	/**
	 * Method which returns the password.
	 * 
	 * @return String: The current password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Method which builds the set of valid password characters.
	 * 
	 * @return String: The set of valid characters for password build.
	 */
	private String buildCharacterSet() {
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = upper.toLowerCase();
		String digits = "0123456789";

		return upper + lower + digits;
	}

	/**
	 * Method which generates a random password using the fixed character set and a
	 * fixed length.
	 * 
	 * @return String: The random generated password.
	 */
	public String generateRandomPassword() {
		StringBuffer randomPassword = new StringBuffer();
		Random random = new Random();
		int randomIndex;
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			randomIndex = random.nextInt(CHARACTER_SET.length());
			randomPassword.append(CHARACTER_SET.charAt(randomIndex));
		}

		return randomPassword.toString();
	}

	/**
	 * Method which sets a new password given a correct current one.
	 * 
	 * @return boolean: True if the password was changed succesfully, false
	 *         otherwise.
	 */
	public boolean setNewPassword() {
		InputHandler ih = new InputHandler();
		String currentPassword = ih.askPassword(currentPasswordMessage, CHARACTER_SET);
		String newPassword = ih.askPassword(newPasswordMessage, CHARACTER_SET);

		if (checkPasswords(currentPassword, newPassword) == false) {
			System.out.println("Changing the password failed.");
			return false;
		}

		password = newPassword;
		return true;
	}

	/**
	 * Method which validates the current and new password user input.
	 * 
	 * @param currentPassword: String: The current account password. Must match the
	 *                         actual current password.
	 * @param newPassword:     String: New password to be set.
	 * @return: boolean: True if both inputed passwords belong to the password
	 *          charater set and the current password matches the actual one.
	 */
	private boolean checkPasswords(String currentPassword, String newPassword) {
		if (currentPassword.equals("")) {
			System.out.println("The current password was not entered correctly.");
			return false;
		} else if (!currentPassword.equals(password)) {
			System.out.println("The current password does not match the entered one.");
			return false;
		} else if (newPassword.equals("")) {
			System.out.println("The new password was not entered correctly.");
			return false;
		}

		return true;
	}
}
