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

	public static void loginSecretary(String userName, String password) {
		for (Secretary sec : SystemManager.getSecretaries()) {
			if (sec.getUserName().equals(userName) && sec.getPassword().equals(password)) {
				System.out.println("I am logged in as a secretary");
				return;
			}
		}
		System.out.println("Wrong username or password");

	}

	public static void editAppointment(Doctor doctor, Appointment appointment, Appointment newAppointment) {
		ArrayList<Appointment> appointments = doctorToAppointmentsMap.get(doctor);
		for (var app : appointments) {
			if (appointment.equals(app)) {
				app = newAppointment;
			}
		}
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

}
