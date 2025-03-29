package Hannah_PatientsOnlineRegistrationApp;

/**
 * This abstract class can be inherited by other class
 * showing first name, last name, and gender of Person object
 * @author Li Yang 19065286
**/
public abstract class Person{
	 private String firstName;
	 private String lastName;
	 private char gender;
	 
/**
 *Constructor:  initializes firstName, lastName, and gender
 * @param firstName
 * @param lastName
 * @param gender
 * @author 19065286
 */
	public Person(String firstName, String lastName, char gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	/**
	 * Default constructor
	 * @author 19065286
	 */
	public Person() {
		this.firstName = null;
		this.lastName = null;
		this.gender = '\0';
	}
	
/**
 * getter method for firstName
 * @return firstName as an String
 * @author 19065286
 */
	public String getFirstName() {
		return firstName;
	}

/**
 * setter for firstName
 * @param firstName
 * @author 19065286
 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * getter method for lastName
	 * @return lastName as an String
	 * @author 19065286
	 */
	public String getLastName() {
		return lastName;
	}
	
   /**
    * setter for lastName
    * @param lastName
    * @author 19065286
    */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * getter for gender
	 * @return gender
	 * @author 19065286
	 */
	public char getGender() {
		return gender;
	}
	
	/**
	 * setter for gender
	 * @param gender
	 * @author 19065286
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Person (firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender +")";
	}
}
