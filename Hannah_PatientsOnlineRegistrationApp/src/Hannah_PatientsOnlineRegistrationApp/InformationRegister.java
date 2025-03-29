package Hannah_PatientsOnlineRegistrationApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class puts the related method for the online Registration Application
 * @author Hannah
 */
public class InformationRegister{
	private static ArrayList<Patient> patientList = new ArrayList<Patient>();
	private static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	private static ArrayList<Nurse> nurseList = new ArrayList<Nurse>();
	static final int generalFee = 40;
	private double feeForEach;
	
	/**
	 * append()method: append patients� names to existing file
	 * @param name
	 * @author Hannah
	 */
	public void append(String name) {
		
		 FileOutputStream out = null;
	// use exception to handle file error
		 try {
				out = new FileOutputStream(new File("Patient_name.txt"), true);
				byte[] data = name.getBytes();
	 		    out.write(data);
				out.flush();
				out.close();
				
			}catch(FileNotFoundException e) {
				System.out.println("Error: Cannot open file for writing");
				
			} catch(IOException e) {
				System.err.println("Problem with Scanner and FileReader"+ e);
			}
	 }
	
	/**
	 * inputPatient() method: for inputing the first name, last name, gender, age for patients, which is designed to interact with user, 
	 * and then sort them by Age Group
	 * @throws InputMismatchException
	 * @author Hannah
	 */
	public void inputPatient() throws InputMismatchException {
		boolean success = false;
		
		Scanner scan = new Scanner(System.in);
		
		// create the exception if users will not input the number for age, they will be noticed
		try {
			while (!success) {
				Patient aPatient = new Patient();
				
				//interact with user
				System.out.println("Please enter patient's first name, last name, gender(F/M), age(Type \"quit\" to get the information): ");
				String firstName= scan.next();
				
				//if type "quit" or "QUIT" for the firstName, it will return Collection
				if(firstName.equalsIgnoreCase("quit")) {
					return;
				}
				
				String lastName = scan.next();
				char gender = scan.next().charAt(0);
				int age = scan.nextInt();
				
				//Set age to the certain Age Group
				if (age >= 0 && age <= 14 ) {
					aPatient.setAgeGroup(AgeGroup.PEDIATRIC);
				}
				if (age >= 15 && age <= 47) {
					aPatient.setAgeGroup(AgeGroup.YOUNG);
				}
				if (age >= 48 && age <= 63) {
					aPatient.setAgeGroup(AgeGroup.MIDDLE_AGE);
				}
				if(age >= 64){
					aPatient.setAgeGroup(AgeGroup.ELDERLY);
				}
				
				// append the name of patients inputed by users to the file (Patient_name.txt):
				append(firstName + " " + lastName + "\n");
				
				aPatient.setFirstName(firstName);
				aPatient.setLastName(lastName);
				aPatient.setGender(gender);
				aPatient.setAge(age);
				
				patientList.add(aPatient);
				}
			
			}catch(InputMismatchException inputMismatchException) {
				System.err.println("The patient's age should be number. Please check again.");
			}		
		
		scan.close();	
	}
	
	/**
	 * doctorlist() method: for populate the three doctor values
	 * @author Hannah
	 */
	public void doctorList() { 
		
		doctorList.add(new Doctor("Jack", "Thompson", 'M', DoctorType.PEDIATRICIAN));
		doctorList.add(new Doctor("Tracy", "Feng", 'F', DoctorType.FAMILY_PRACTICE));
		doctorList.add(new Doctor("Zoe", "Wall", 'F', DoctorType.GERIATRICIAN));
		
	}
	
	/**
	 * getDoctorByType method: for initializing the doctorType to Doctor object
	 * @param type
	 * @return Doctor
	 * @author Hannah
	 */
	public Doctor getDoctorByType(DoctorType type) {
		
		for(Doctor e: doctorList) {
			if (e.getDoctorType() == type) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * This method is for patients to match the suitable doctors
	 * @param patient
	 * @return Doctor
	 * @author Hannah
	 */
    public Doctor matchDoctor(Patient patient) {
		Doctor doctor = null;
		if(patient.getAgeGroup() == AgeGroup.ELDERLY) {
			
			doctor = getDoctorByType(DoctorType.GERIATRICIAN);	
		}
		if (patient.getAgeGroup() == AgeGroup.PEDIATRIC) {
			
			doctor = getDoctorByType(DoctorType.PEDIATRICIAN);
		}
		if((patient.getAgeGroup() == AgeGroup.YOUNG) || patient.getAgeGroup() == AgeGroup.MIDDLE_AGE) {
			
			doctor = getDoctorByType(DoctorType.FAMILY_PRACTICE);
		}
		return doctor;
			
	}
    
    /**
     * nurseList() method: for populate the two nurse values
	 * @author Hannah
     */
    public void nurseList() {
		nurseList.add(new Nurse("Karen", "Lin", 'F'));
		nurseList.add(new Nurse("James", "Kai", 'M'));
	}
    
    /**
	 * getNurseByType method: for initializing the nurseType to Nurse object
	 * @param gender
	 * @return Nurse
	 * @author Hannah
	 */
     public Nurse getNurseByGender(char gender) {
		
		for(Nurse e: nurseList) {
			if (e.getGender() == gender) {
				return e;
			}
		}
		return null;
	}
     
     /**
      * selectNurse method:Select Nurse for caring the patient automatically
      * according to the gender of patients
      * @param patient
      * @return Nurse
      * @author Hannah
      */
     public Nurse selectNurse(Patient patient) {
    	 Nurse nurse = null;
    	 if ((patient.getGender() == 'F')|| (patient.getGender() == 'f')) {
    		 nurse = getNurseByGender('F');
    	 }
    	 if ((patient.getGender() == 'M') || (patient.getGender() == 'm')) {
    		 nurse = getNurseByGender('M');
    	 }
    	 return nurse;
     }
     
     /**
      * calculateFee method: calculate the fee for different age groups
      * Elderly(70% discount), PEDIATRIC(free), MIDDLE AGE(90% discount), YOUNG(no discount)
      * @param patient
      * @return fee
      * @author Hannah
      */
     public double calculateFee(Patient patient) {
    	
    	if (patient.getAgeGroup() == AgeGroup.ELDERLY) {
    		feeForEach = generalFee * 0.7;
    	}
    	if (patient.getAgeGroup() == AgeGroup.PEDIATRIC) {
    		feeForEach = 0;
    	}
    	if (patient.getAgeGroup() == AgeGroup.MIDDLE_AGE) {
    		feeForEach = generalFee * 0.9;
    	}
    	if (patient.getAgeGroup() == AgeGroup.YOUNG) {
    		feeForEach = generalFee;
    	}
    	return feeForEach;
    }
    
     /**
      * showAdministrator method: let user input her/his name to record who input the data of registration 
      * @param admin
      * @author Hannah
      */
    public void showAdministrator(Administrator admin) {

        Scanner scan = new Scanner(System.in);
    	System.out.println();
		System.out.println("Please input your name (as Administrator):");
		admin.setFirstName(scan.next());
		admin.setLastName(scan.next());
		scan.close();
	}
    
    /**
     * getter for patientList
     * @return patientList
     * @author Hannah
     */
	public static ArrayList<Patient> getPatientList() {
		return patientList;
	}
	
	/**
	 * setter for patientList
	 * @param patientList
	 * @author Hannah
	 */
	public static void setPatientList(ArrayList<Patient> patientList) {
		InformationRegister.patientList = patientList;
	}
	
	/**
	 * getter for doctorList
	 * @return doctorList
	 * @author Hannah
	 */
	public static ArrayList<Doctor> getDoctorList() {
		return doctorList;
	}
	
	/**
	 * setter for doctorList
	 * @param doctorList
	 * @author Hannah
	 */
	public static void setDoctorList(ArrayList<Doctor> doctorList) {
		InformationRegister.doctorList = doctorList;
	}	
}
