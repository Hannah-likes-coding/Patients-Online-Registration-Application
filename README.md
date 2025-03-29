# Patients-Online-Registration-Application
- 🌟 Skills: Java, UML

## UML
![image](https://github.com/user-attachments/assets/6b4f860e-13a1-4cdc-962d-627087e94c40)
- Or open the file "console-uml.pdf"
  
## Explanation and summary for the project:
Patients online Registration application is designed for administrators of Health Clinic to input
the information of patients, and the system will automatically register the suitable doctor by
age group, select the suitable nurse by patients’ gender ( female nurses to female patients,
male nurses to male patients), and count the different fees by patients’ age group for patients,
and let administrators to input their names (first name and last name) each time to record who
input the data of registration, and can retrieve data from system.

There are 8 classes, and 2 enumerations:

## 8 Classes: Person, Doctor, Patient, Nurse, Administrator, InformationRegister,
RegistrationRecord, PatientOnlineRegistrationApp

## 2 enumeration: AgeGroup, DoctorType
There are two files for this application: Patient_name.txt and Registration System.txt
When running the project, firstly user need to input patient’s first name, last name, gender, and
age (Note: if user doesn’t input the number for age, it will cause exception). User will not stop
to input the information of patents until type “quit”. After typing “Quit”, the system will ask
user to input his/her first name and last name being an administrator. And then it will print out
patients’ online registration information including patients’ details, registered doctor,
registered nurse, fee, and administrator. Besides, the information of all patients sorted by their
age group will be printed out. Finally, the system adds two new doctors, and search the first
name of doctor to get the information of doctor. After user finishing the registration each time,
patients’ names will be input into the existing file called “Patient_name.txt”.

## The screenshot for the user input part:
![image](https://github.com/user-attachments/assets/fe6f3a19-2823-45b1-8052-fb46989aa7e1)

## Console Sample 
- open the file "console-sample.txt"

## Main Method’s details:
• In main method, pass in a FileReader instance to Scanner to read character data instead
of System.in

• List doctors, and sored by the DoctorType

• List nurses

• Call InputPatient() method to prompt user to input the information

• Call showAdministrator method to let user input user’s name (first name and last name)
and output it

• Call matchDoctor, selectNurse, calculateFee method to print out the registration
information: patient information, matched doctor information, selected nurse
information, fee

• Print the patient list sorted by their age group

• Store two new doctors’ information

• Use HashMap to retrieve the first name “Oscar” from new doctors


