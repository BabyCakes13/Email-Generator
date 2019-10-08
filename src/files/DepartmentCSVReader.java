package files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import email_objects.Department;

public class DepartmentCSVReader {

	private final String SPLITTER = "\",";
	private final String filePath;
	private ArrayList<Department> departments;

	/**
	 * Constructor which initialises the path of the file containing department info
	 * for building and the array which will hold the created Department objects.
	 * 
	 * @param filePath: Path to the department info file.
	 */
	public DepartmentCSVReader(String filePath) {
		this.filePath = filePath;
		departments = new ArrayList<Department>();
	}

	/**
	 * Method which verifies if the departments
	 * 
	 * @return
	 */
	public ArrayList<Department> getReadDepartments() {
		this.departments = buildDepartments();
		return departments;
	}

	/**
	 * Method which uses the path to the departments file for populating the
	 * departments list, reading line by line. Each line represents a Department
	 * object.
	 * 
	 * @return ArrayList<Department>: An array formed of Departments build using the
	 *         file containing department info.
	 */
	private ArrayList<Department> buildDepartments() {
		ArrayList<Department> departments = new ArrayList<Department>();
		BufferedReader reader;
		String row;

		try {
			reader = new BufferedReader(new FileReader(filePath));

			int rowCount = 0;
			while ((row = reader.readLine()) != null) {
				rowCount++;
				Department newDepartment = readAndBuildDepartment(row);

				if (newDepartment == null) {
					System.out.println("The parameters for Department building are not valid for the row: " + rowCount);
					continue;
				} else {
					departments.add(newDepartment);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was an reading error in the line reading.");
			e.printStackTrace();
		}

		return departments;
	}

	/**
	 * Method which using the data from a row in the CSV file, creates a new
	 * Department object using the read and validated parameters.
	 * 
	 * @param row: String representing a CSV line.
	 * @return Department: if the data was valid for department creation, null
	 *         otherwise.
	 */
	private Department readAndBuildDepartment(String row) {
		String[] data = getCleanData(row);
		if (validateData(data) == false) {
			return null;
		}

		int ID = Integer.parseInt(data[0]);
		String name = data[1];
		String description = data[2];

		Department newDepartment = new Department(ID, name, description);
		return newDepartment;
	}

	/**
	 * Method which splits and cleans the row of the CSV file of "", separators,
	 * generating clean spearate items.
	 * 
	 * @param row: String which represents one line read from the input file.
	 * @return String[]: An array of Strings which represent the split data without
	 *         "" and ,.
	 */
	private String[] getCleanData(String row) {
		String[] data = row.split(SPLITTER);

		for (int i = 0; i < data.length; i++) {
			if (i == data.length - 1) {
				data[i] = data[i].substring(1, data[i].length() - 1);
				continue;
			}
			data[i] = data[i].substring(1);
		}

		return data;
	}

	/**
	 * Method which validates the data found in a line.
	 * 
	 * @param data: An Array of String values representing the three possible
	 *              parameters for Department object initialisation.
	 * @return boolean: True if the values are valid for creating a Department
	 *         object, False otherwise.
	 */
	private boolean validateData(String[] data) {
		if (data.length != 3) {
			System.out.println("The row has an invalid number of items.");
			return false;
		}

		try {
			Integer.parseInt(data[0]);
		} catch (InputMismatchException e) {
			System.out.println("The ID needs to be a positive integer.");
			return false;
		}

		return true;
	}
}
