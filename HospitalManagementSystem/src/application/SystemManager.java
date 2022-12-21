package application;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemManager {

	private static ArrayList<Secretary> secretaries = new ArrayList<Secretary>();
	private static ArrayList<Patient> patients = new ArrayList<Patient>();
	private static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	private static HashMap<Doctor, ArrayList<Patient>> doctorToPatientMap = new HashMap<Doctor, ArrayList<Patient>>();
	private static HashMap<Doctor, ArrayList<Appointment>> doctorToAppointmentsMap = new HashMap<Doctor, ArrayList<Appointment>>();
	private static Schedule schedule =new Schedule();
	private static Secretary currentSecretary;
	private static Doctor  currentDoctor;
	
	//main functions
	
	
	// secretary functions 
	public static void secretaryLogin(String userName, String password) {	
		for (Secretary sec : SystemManager.getSecretaries()) {
			
			if (sec.getUserName().equals(userName)) {
				if(sec.login(userName, password)) {
					setCurrentSecretary(sec);
					break;
				}
				
			}
		}
	}
	  
		
	public static void secertaryEditApointment(String doctorName, String resTime,String date,  Doctor doctor, boolean excuse) {
		
		for (Doctor doc : SystemManager.getDoctors()) {
			
			if (doc.getName().equals(doctorName)) {
		for (Appointment element : getDoctorToAppointmentsMap(doc)) {
			if(element.getReservationTime().equals(resTime))
				getCurrentSecretary().editApointment(element, date, resTime, doc, excuse);
			break;
		}
			}
		
		}
}
	
	
	//// Doctors Functions 
	
	public static void doctorLogin(String userName, String password) {	
		for (Doctor  doc : SystemManager.getDoctors()) {
			
			if (doc.getUserName().equals(userName)) {
				if(doc.login(userName, password)) {
					setCurrentDoctor(doc);
					break;
				}
				
			}
		}
	}
	
	
	
	//// set and get
	
	
	
	
	public static ArrayList<Secretary> getSecretaries() {
		return secretaries;
	}

	public static void setSecretaries(ArrayList<Secretary> secretaries) {
		SystemManager.secretaries = secretaries;
	}



	public static ArrayList<Patient> getPatients() {
		return patients;
	}

	public static void setPatients(ArrayList<Patient> patients) {
		SystemManager.patients = patients;
	}

	public static ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public static void setDoctors(ArrayList<Doctor> doctors) {
		SystemManager.doctors = doctors;
	}

	public static ArrayList<Patient> getDoctorToPatientMap(Doctor d) {
		return doctorToPatientMap.get(d);
	}

	public static void setDoctorToPatientMap(Doctor d, ArrayList<Patient> pp) {
		doctorToPatientMap.put(d, pp);
	}

	public static ArrayList<Appointment> getDoctorToAppointmentsMap(Doctor d) {
		return doctorToAppointmentsMap.get(d);
	}

	public static void setDoctorToAppointmentsMap(Doctor d, ArrayList<Appointment> ap) {
		doctorToAppointmentsMap.put(d, ap);
	}

	public void addSecretary(Secretary secretary) {
		secretaries.add(secretary);
	}

	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}

	public static ArrayList<Patient> getPatientsOfADoctor(Doctor doctor) {
		return doctorToPatientMap.get(doctor);
	}


	public static void addPatientToDoctor(Doctor doctor, Patient patient) {
		doctorToPatientMap.get(doctor).add(patient);
	}

	public static void addAppointmentToDoctor(Doctor doctor, Appointment appointment) {
		doctorToAppointmentsMap.get(doctor).add(appointment);
	}

	public static Secretary getCurrentSecretary() {
		return currentSecretary;
	}

	public static void setCurrentSecretary(Secretary currentSecretary) {
		SystemManager.currentSecretary = currentSecretary;
	}


	public static Doctor getCurrentDoctor() {
		return currentDoctor;
	}


	public static void setCurrentDoctor(Doctor currentDoctor) {
		SystemManager.currentDoctor = currentDoctor;
	}

}
