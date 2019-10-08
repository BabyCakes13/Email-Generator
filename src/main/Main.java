package main;

import files.DepartmentCSVReader;

public class Main {

	public static void main(String[] args) {
		inputApp();
	}

	public static void inputUser() {
		InputHandler ih = new InputHandler();
		System.out.println(ih.askDepartmentID());
	}

	public static void inputApp() {
		DepartmentCSVReader dcsvr = new DepartmentCSVReader(
				"/home/babycakes/workspace/Email-Generator/src/files/departments");
		System.out.println(dcsvr.getReadDepartments().toString());

	}

}
