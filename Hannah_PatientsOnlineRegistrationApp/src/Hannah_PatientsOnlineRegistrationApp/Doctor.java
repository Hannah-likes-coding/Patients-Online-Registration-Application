package Hannah_PatientsOnlineRegistrationApp;

/**
 * This subclass inherits Person and has Comparable Interface
 * has DoctorType attribute in addition to the attributes of superclass Person
 * @author Hannah Yang 
 */
public class Doctor extends Person implements Comparable<Doctor>{
	
	private DoctorType doctorType;
	
	/**
	 * Constructor: initializes all instance variables
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param doctorType
	 * @author Hannah
	 */
	public Doctor(String firstName, String lastName, char gender, DoctorType doctorType) {
		super(firstName, lastName, gender);
		this.doctorType = doctorType;
	}
	
	/**
	 * default constructor
	 * @author Hannah
	 */
	public Doctor() {
		super();
		this.doctorType = null;
	}
	
	/**
	 * getter for doctorType
	 * @return doctorType
	 * @author Hannah
	 */
	public DoctorType getDoctorType() {
		return doctorType;
	}

	/**
	 * seeter for doctorType
	 * @param doctorType
	 * @author Hannah
	 */
	public void setDoctorType(DoctorType doctorType) {
		this.doctorType = doctorType;
	}

	@Override
	public String toString() {
		
		String output = "";
		output +="Doctor: " + this.getFirstName() + " " + this.getLastName() + " ("
					+ "\"" + this.getGender() + "\"" + ", " + this.getDoctorType() + ")" + "\n";
		return output;
	}	
	
	/**
	 * this method implements the Comparable Interface by doctoType between two Doctor objects
	 * @author Hannah
	 */
	@Override
	public int compareTo(Doctor o) {

		return this.doctorType.compareTo(o.doctorType);
	}	
}
