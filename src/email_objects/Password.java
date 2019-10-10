package email_objects;

import java.util.Random;

public class Password {
	
	private String password;
	private final static int PASSWORD_LENGTH = 10;
	
	public Password() {
		password = "";
	}
	
	public String generateRandomPassword(int passwordLength) {
		String passwordSet = "ABCDEFGHIJLKMNOPabcdefghijklmnop1234567890";
		
		StringBuffer randomPassword = new StringBuffer();
		int randomIndex;
		for(int i = 0; i < PASSWORD_LENGTH; i++) {
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
	
	public String changePassword(String olsPassword) {
		String newPassword = "";
		
		return newPassword;
	}
}
