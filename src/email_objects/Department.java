package email_objects;

/**
 * Class which represents an object of type department.
 * @author babycakes
 *
 */
public class Department {

	private int ID;
	private String name;
	private String description;

	/**
	 * Constructor of Department class.
	 * @param ID: An unique id representing the department.
	 * @param name: The name of the department.
	 * @param description: The description of the department.
	 */
	public Department(int ID, String name, String description) {
		this.ID = ID;
		this.name = name;
		this.description = description;
	}

	/**
	 * Getter for the department ID.
	 * @return int: ID of the department.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Getter for the name of the department.
	 * @return String: Name of the department.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the description of the department.
	 * @return String: The description of the department.
	 */
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return "Department [ID=" + ID + ", name=" + name + ", description=" + description + "]";
	}

}
