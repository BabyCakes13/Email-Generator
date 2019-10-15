package email_objects;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Class which handles finding the name of the department based on the
 * department input ID, given by the user at console.
 * 
 * @author babycakes
 *
 */
public class DepartmentHandler {

	private int chosenID;

	/**
	 * Constructor of class DepartmentHandler.
	 * 
	 * @param chosenID: The department chosen by the user at console level.
	 */
	public DepartmentHandler(int chosenID) {
		this.chosenID = chosenID;
	}

	/**
	 * Method to search for a specific Department object based on the user input
	 * request.
	 * 
	 * @return Department: if found, null: otherwise.
	 */
	public Department searchDepartment() {
		DepartmentCSVReader dcsvr = new DepartmentCSVReader();
		ArrayList<Department> departments = dcsvr.getReadDepartments();

		for (Department department : departments) {
			if (department.getID() == chosenID) {
				System.out.println("Department found: " + department.toString());
				return department;
			}
		}

		return null;
	}

	/**
	 * Method which returns the requested department name of the searched ID, if
	 * existent.
	 * 
	 * @return String: The name of the Department based on the searched Department
	 *         ID. Empty String if not found.
	 */
	public String getSearchedDepartmentName() {
		Department searchedDepartment = searchDepartment();
		if (searchedDepartment == null) {
			System.out.println("The department does not exist yet. Slot will be left empty for further fix.");
			return "";
		} 
		return searchedDepartment.getName();
	}

}
