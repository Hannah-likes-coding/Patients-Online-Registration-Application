package Hannah_PatientsOnlineRegistrationApp;

/**
 * This subclass Nurse inherits Person
 * @author Hannah
 */
public class Nurse extends Person{

	/**
	 * Constructor: for all instance variables to initialize Nurse object 
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @author Hannah
	 */
	public Nurse(String firstName, String lastName, char gender) {
		super(firstName, lastName, gender);
	}

	@Override
	public String toString() {
		return "Nurse (" + this.getFirstName() + " " + this.getLastName() + ", " + this.getGender() + ")";
	}
	

}
