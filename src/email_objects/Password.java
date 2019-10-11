package email_objects;

import java.util.Random;

public class Password {

	private static String password = "";
	private final static int PASSWORD_LENGTH = 10;

	public Password() {
		if (password == "") {
			password = generateRandomPassword(PASSWORD_LENGTH);
		}
	}

	public static String getPassword() {
		return password;
	}

	public String generateRandomPassword(int passwordLength) {
		String passwordSet = "ABCDEFGHIJLKMNOPabcdefghijklmnop1234567890";

		StringBuffer randomPassword = new StringBuffer();
		int randomIndex;
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			randomIndex = getRandomCharacterIndex(passwordSet.length());
			randomPassword.append(passwordSet.charAt(randomIndex));
		}

		return randomPassword.toString();
	}

	private int getRandomCharacterIndex(int stringSize) {
		Random random = new Random();
		int index = random.nextInt(stringSize);
		return index;
	}

	public boolean setNewPassword(String currentPassword, String newPassword) {
		if (!currentPassword.equals(password)) {
			System.out.println("The current password does not match the entered one.");
			return false;
		}

		this.password = newPassword;
		return true;
	}
}
