import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

public class SystemManger {
  private static ArrayList<Secretary> secretaries = new ArrayList<Secretary>();
  private static ArrayList<Patient> patients = new ArrayList<Patient>();
  private static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
  private static HashMap<Doctor, ArrayList<Patient>> doctorToPatientMap = new HashMap<Doctor, ArrayList<Patient>>();
  private static HashMap<Doctor, ArrayList<Appointment>> doctorToAppointmentsMap = new HashMap<Doctor, ArrayList<Appointment>>();


  public static void addSecretary(Secretary secretary) {
    secretaries.add(secretary);
  }

  public static void addDoctor(Doctor doctor) {
    secretaries.add(doctor);
  }

  public static ArrayList<Patient> getPatients(Doctor doctor) {
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

  public static void editAppointment(Doctor doctor, Appointment appointment, Appointment newAppointment) {
    ArrayList<Appointment> appointments = doctorToAppointmentsMap[doctor];
    for (var app : appointments) {
      if (appointment.equals(app)) {
        app = newAppointment;
      }
    }
  }

  public static void addAppointmentToDoctor(Doctor doctor, Appointment appointment) {
    doctorToAppointmentsMap[doctor].add(appointment);
  }


}
