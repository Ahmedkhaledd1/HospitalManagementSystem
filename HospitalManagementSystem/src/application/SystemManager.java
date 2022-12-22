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
	private static SystemManager single_instance = null;
	
	
	//single tone function
	
	public static SystemManager Singleton()
    {
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new SystemManager();
        }
        return single_instance;
    }

	
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
	  
	public void secertaryAddApointment(String date, String reservationTime,String docName){
		
		for (Doctor doc : SystemManager.getDoctors()) {
			
			if (doc.getName().equals(docName)) {
				
				getDoctorToAppointmentsMap(doc).add( getCurrentSecretary().addApointment(date, reservationTime, doc, false));
				break;
			}
			
			
		}
		
	}
	
	
	public void secertaryIntiateExcuse(String docName,String day) {
		
		for (Doctor doc : SystemManager.getDoctors()) {
			if (doc.getName().equals(docName)) {
				getCurrentSecretary().initiateExcuse(schedule, doc, day);
			//remove doc from schedule 
			
			for(Appointment ele:  getDoctorToAppointmentsMap(doc)) {
				ele.setExcuse(true);
			  }// make excuse true
			
			break;
			}
			
			
		}
	}
	
	public void SecertaryEditScedule(String time,String day,String docName) {
		
		for (Doctor doc : SystemManager.getDoctors()) {
			if (doc.getName().equals(docName)) {
				getCurrentSecretary().editSchedule(schedule, time, day, doc);
			
			// rmeove time assoiated form schedule
				
				for(Appointment ele:  getDoctorToAppointmentsMap(doc)) {
					if(ele.getDate().equals(day)&&ele.getReservationTime().equals(time))ele.setExcuse(true);
				  }// make excuse true of spacfied time 
				
			
			break;
			}
			
			
		}
		
	}
	
	public static void secertaryEditApointment(String doctorName, String oldResTime,String oldDate,String resTime,String date, boolean excuse) {
		
		for (Doctor doc : SystemManager.getDoctors()) {
			
			if (doc.getName().equals(doctorName)) {
		for (Appointment element : getDoctorToAppointmentsMap(doc)) {
			if(element.getReservationTime().equals(oldResTime)&&element.getDate().equals(oldDate))
				getCurrentSecretary().editApointment(element, date, resTime, doc, excuse);
			break;
		}
			}
		
		}
}
	
    public ArrayList<String> DisplaySchedule(String doctorName,String day) {
		
		for(Doctor doc:SystemManager.getDoctors()) {
			if(doc.getName().equals(doctorName))
				return schedule.getTimeSlots().get(day).get(doc);
				
			
		}
		return null;
		
		
	}
    
    
	//// Doctors Functions 
	
	public  void doctorLogin(String userName, String password) {	
		for (Doctor  doc : SystemManager.getDoctors()) {
			
			if (doc.getUserName().equals(userName)) {
				if(doc.login(userName, password)) {
					setCurrentDoctor(doc);
					break;
				}
				
			}
		}
	}
	
	
 public MedicalHistory doctorGetPatientMedicalHistory(String patName) {
	 for (Patient pat : getPatients()) {
		if(pat.getName().equals(patName)) {
			return getCurrentDoctor().getPatientMedicalHistory(pat);
			}
		}
	 return null;
 }
 
 public void doctorEditPatientMedicalHistory(String patName,String diagnose,String treatment) {
	 for (Patient pat : getPatients()) {
			if(pat.getName().equals(patName)) {
				 if( doctorGetPatientMedicalHistory( patName)!=null) {
					 getCurrentDoctor().editPatientMedicalHistory(diagnose, treatment, pat);
				 }
			}
			break;
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
