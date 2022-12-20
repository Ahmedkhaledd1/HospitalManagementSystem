package application;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemManager {
	
	
  private static ArrayList<Secretary> secretaries = new ArrayList<Secretary>();
  private static ArrayList<Patient> patients = new ArrayList<Patient>();
  private static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
  private static HashMap<Doctor, ArrayList<Patient>> doctorToPatientMap = new HashMap<Doctor, ArrayList<Patient>>();
  private static HashMap<Doctor, ArrayList<Appointment>> doctorToAppointmentsMap = new HashMap<Doctor, ArrayList<Appointment>>();

  
  
  
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
public static  ArrayList<Patient> getDoctorToPatientMap(Doctor d) {
	return doctorToPatientMap.get(d);
}
public static void setDoctorToPatientMap(Doctor d, ArrayList<Patient> pp) {
	doctorToPatientMap.put(d, pp);
}
public static  ArrayList<Appointment> getDoctorToAppointmentsMap(Doctor d) {
	return doctorToAppointmentsMap.get(d);
}
public static void setDoctorToAppointmentsMap(Doctor d,ArrayList<Appointment> ap) {
	//SystemManager.doctorToAppointmentsMap <d,ap>;
  doctorToAppointmentsMap.put(d, ap);
}



/*
  public  void addSecretary(Secretary secretary) {
    secretaries.add(secretary);
  }

  public  void addDoctor(Doctor doctor) {
   doctors.add(doctor);
  }

  public static HashMap<Doctor, ArrayList<Patient>> getPatientsOfADoctor(Doctor doctor) {
    return doctorToPatientMap[doctor];
  }

  public static ArrayList<Secretary> getSecretaries() {
    return secretaries;
  }

  public static ArrayList<Doctor> getDoctors() {
    return doctors;
  }

  public static void addPatientToDoctor(Doctor doctor, Patient patient) {
    doctorToPatientMap[doctor].add(patient);
  }

  public static void editAppointment(Doctor doctor, Appointment appointment) {
    //TODO
  }

  public static void addAppointmentToDoctor(Doctor doctor, Appointment appointment) {
    doctorToAppointmentsMap[doctor].add(appointment);
  }
*/

  
  
  
}
