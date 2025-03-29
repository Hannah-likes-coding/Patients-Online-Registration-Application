package Hannah_PatientsOnlineRegistrationApp;

import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class contains main method to run the application
 * @author Hannah
 *
 */
public class PatientsOnlineRegistrationApp {
	
	public static void main(String[] args) {
		
		InformationRegister app = new InformationRegister();
		Administrator administrator = new Administrator();
		
		// layer Scanner over FileReader instead of System.in
		try { 
			Scanner scan = new Scanner(new FileReader("Registration System.txt")); 
			
			// loop while there is a line to read from
			while (scan.hasNextLine()) {
		
				String s = scan.nextLine();
				System.out.println(s);
			}
			scan.close();
		} catch (IOException e) {
			System.err.println("Problem with Scanner and FileReader " + e);
		}

		app.doctorList();
		
		// Sorted by the DoctorType of doctor
		Collections.sort(InformationRegister.getDoctorList());
		System.out.println("The doctor list: ");
	    System.out.println(InformationRegister.getDoctorList());
	    
	    app.nurseList();
	    
		app.inputPatient();
		
		app.showAdministrator(administrator);
		System.out.println("====================================================================================");	
		
		NumberFormat currencyFormat= NumberFormat.getCurrencyInstance();
		
		//print out patients' registration information 
		for(Patient e: InformationRegister.getPatientList()) {
			System.out.println();
			System.out.println("*******************  A Patient's Online Registration Information  ******************");
			System.out.println();
			System.out.println(e);
			System.out.println("Register with: ");
			System.out.println(app.matchDoctor(e));
			System.out.println(app.selectNurse(e));
			System.out.println("Fee: " + currencyFormat.format(app.calculateFee(e)));

			System.out.println("                                      " + administrator);
			System.out.println("====================================================================================");	
		
		}	
		
		System.out.println();  
		
		//Sorted by Age Group of patients
		Collections.sort(InformationRegister.getPatientList());
		System.out.println("All patients' information ordered by their age group: ");
		System.out.println(InformationRegister.getPatientList());
		
		System.out.println("====================================================================================");	
		
		HashMap<String, Doctor> oneRecord = new HashMap<String, Doctor>();
		RegistrationRecord rd = new RegistrationRecord(oneRecord);
		
		//store the value of two new doctors
		rd.store(new Doctor("Alex", "Ling", 'M', DoctorType.FAMILY_PRACTICE));
		rd.store(new Doctor("Oscar", "Liu", 'M', DoctorType.FAMILY_PRACTICE));
		
		//look up the information of the doctor whose first name is Oscar
		System.out.println("Look up the doctor's firstname \"Oscar\": ");
		System.out.println(rd.lookup("Oscar"));
		System.out.println("**********************************************************************************");
		System.out.println("*******Thank you for using Patients Online Registration System! Good Bye!*********");
        }	
	

}
