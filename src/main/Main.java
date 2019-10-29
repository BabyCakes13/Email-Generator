package main;

public class Main {

	/**
	 * Main method of the application. 
	 * @param args
	 */
	public static void main(String[] args) {
		Email email = new Email("Mary", "Jane");
		System.out.println(email.generateEmail());
		email.displayUserInfo();
	}

}
