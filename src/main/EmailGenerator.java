package main;

public class EmailGenerator {
	int mailboxCapacity;
	String password;
	String firstName;
	String lastName;
	String department;
	
	public EmailGenerator(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String generateEmail() {
		return "";
	}
	
	
}
