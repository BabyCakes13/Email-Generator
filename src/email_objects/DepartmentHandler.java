package email_objects;

import java.util.ArrayList;

public class DepartmentHandler {

	private int chosenID;

	public DepartmentHandler(int chosenID) {
		this.chosenID = chosenID;
	}
	
	/**
	 * Method to search for the department ID in order to acknowledge its existente. I know, DO NOT HARDCODE FILES!
	 */
	public void searchID() {
		DepartmentCSVReader dcsvr = new DepartmentCSVReader("/home/babycakes/workspace/Email-Generator/src/files/departments");
		ArrayList<Department> departments = dcsvr.getReadDepartments();
		
		for(Department department: departments) {
			if (department.getID() == chosenID) {
				System.out.println("Found it.");
				break;
			}
		}
		
	}

}
