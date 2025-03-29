package Hannah_PatientsOnlineRegistrationApp;

import java.util.HashMap;

/**
 * This class is designed to find the matching first name of doctor in the new doctors
 * @author Hannah
 *
 */
public class RegistrationRecord {
	private HashMap<String, Doctor> records;
	
	/**
	 * constructor: for initializing instance variable
	 * @param records
	 * @author 19065286
	 */
	public RegistrationRecord(HashMap<String, Doctor> records) {
		this.records = new HashMap<String, Doctor>();
	}
	
	@Override
	public String toString() {
		return "RegistrationRecord (" + records + ")";
	}
	
	/**
	 * store method: used hashmap�s put method to associate first name with new added doctors
	 * @param rd
	 * @author 19065286
	 */
	public void store(Doctor rd) {

		records.put(rd.getFirstName(),rd);
	}
	
	/**
	 * look up method: search the set of keys of records to find a matching first name. 
	 * If found, the associated Doctor will be obtained.  
	 * @param lastName
	 * @return ContactDetails
	 * @author 19065286
	 */
	public Doctor lookup(String firstName) {
		Doctor dt = null;

		for(String e : records.keySet()) {
			if(e.contains(firstName)) {
				return records.get(e);
			}
		}	
		return dt;
	}

}
