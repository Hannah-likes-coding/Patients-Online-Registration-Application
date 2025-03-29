package Hannah_PatientsOnlineRegistrationApp;

/**
 * This subclass Patient inherits Person and implements Comparable Interface by age group
 * @author Hannah
 */
public class Patient extends Person implements Comparable<Patient>{
	private int age;
	private AgeGroup ageGroup;
	
	/**
	 * Constructor: initializes all instance variables
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param age
	 * @param ageGroup
	 * @author 19065286
	 */
	public Patient(String firstName, String lastName, char gender, int age, AgeGroup ageGroup) {
		super(firstName, lastName, gender);
		this.age = age;
		this.ageGroup = ageGroup;
	}
	
	/**
	 * default constructor
	 * @author 19065286
	 */
	public Patient() {
		this.age = 0;
		this.ageGroup = null;
	}
	
	/**
	 * getter for ageGroup
	 * @return ageGroup
	 * @author 19065286
	 */
	public AgeGroup getAgeGroup() {
		return ageGroup;
	}
	
	/**
	 * setter for ageGroup
	 * @param ageGroup
	 * @author 19065286
	 */
	public void setAgeGroup(AgeGroup ageGroup) {

		this.ageGroup = ageGroup;
	}
	
	/**
	 * getter for age
	 * @return age
	 * @author 19065286
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * setter for age
	 * @param age
	 * @author 19065286
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		String outputString = "";
		outputString += "Patient Name: " + this.getFirstName() + " " + this.getLastName() + " (Gender: " + this.getGender() 
		+ ", Age: " + age + ", Age group: " + this.getAgeGroup() + ")\n";
		return outputString;
	}
	
	/**
	 * compare method: compared by ageGroup
	 * @author 19065286
	 */
	@Override
	public int compareTo(Patient o) {
		
		return this.ageGroup.compareTo(o.ageGroup);
	}
}
