package main;

import email_objects.Department;

public class Main {

	public static void main(String[] args) {
		Department newDep = new Department(1, "Wralock", "Daemon thread handling, gonna get your hands dirty.");
		System.out.println(newDep.toString());
	}

}
