package Hannah_PatientsOnlineRegistrationApp;

/**
 * This Administrator class inherit the Person Class
 * maintains the same instance variables as Person: firstName, lastName, gender
 * @author Hannah Yang 
 */
public class Administrator extends Person{
	
	/**
	 * Constructor: initialize all attributes
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @author Hannah
	 */
	public Administrator(String firstName, String lastName, char gender) {
		super(firstName, lastName, gender);
	}
	
	/**
	 * default constructor
	 * @author Hannah
	 */
	public Administrator() {
		super();
	}

	@Override
	public String toString() {
		return "Administrator: " + getFirstName() + " " + getLastName();
	}
}
