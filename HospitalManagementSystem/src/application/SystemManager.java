package application;

import java.util.ArrayList;
import java.util.HashMap;



public class SystemManager {

	private  ArrayList<Secretary> secretaries = new ArrayList<Secretary>();
	private  ArrayList<Patient> patients = new ArrayList<Patient>();
	private  ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	private  HashMap<Doctor, ArrayList<Patient>> doctorToPatientMap = new HashMap<Doctor, ArrayList<Patient>>();
	private  HashMap<Doctor, ArrayList<Appointment>> doctorToAppointmentsMap = new HashMap<Doctor, ArrayList<Appointment>>();
	private  Schedule schedule =new Schedule();
	private  Secretary currentSecretary;
	private  Doctor  currentDoctor;
	private static SystemManager single_instance = null;
	private boolean loginFlag=false;
	
	
	//single tone function
	
	public static SystemManager Singleton()
    {
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new SystemManager();
        }
        
        single_instance.intiateData();
        return single_instance;
    }

	
	//main functions
	
	
	// secretary functions 
	public  void secretaryLogin(String userName, String password) {	
		for (Secretary sec : getSecretaries()) {
			loginFlag=sec.getUserName().equals(userName);
			if (loginFlag) {
				loginFlag=sec.login(userName, password);
				if(loginFlag) {
					setCurrentSecretary(sec);
					break;
				}
				
			}
		}
	}
	  
	public void secertaryAddApointment(String date, String reservationTime,String docName){
		
		for (Doctor doc : getDoctors()) {
			
			if (doc.getName().equals(docName)) {
				
				getDoctorToAppointmentsMap(doc).add( getCurrentSecretary().addApointment(date, reservationTime, doc, false));
				break;
			}
			
			
		}
		
	}
	
	
	public void secertaryIntiateExcuse(String docName,String day) {
		
		for (Doctor doc : getDoctors()) {
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
		
		for (Doctor doc : getDoctors()) {
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
	
	public  void secertaryEditApointment(String doctorName, String oldResTime,String oldDate,String resTime,String date, boolean excuse) {
		
		for (Doctor doc :getDoctors()) {
			
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
		
		for(Doctor doc:getDoctors()) {
			if(doc.getName().equals(doctorName))
			//return schedule.getTimeSlots().get(day);
        	return schedule.getTimeSlots().get(day).get(doc);
				
			
		}
		return null;
		
		
	}
    
    
	//// Doctors Functions 
	
	public  void doctorLogin(String userName, String password) {	
		for (Doctor  doc : getDoctors()) {
			loginFlag=doc.getUserName().equals(userName);
			if (loginFlag) {
				loginFlag=doc.login(userName, password);
				if(loginFlag) {
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
 
 
 
 //  functions to fill the combobox
 
 
 public ArrayList<String> docNamesList(ArrayList<Doctor> docs){
	 
	 ArrayList<String> docNameStrings=new ArrayList<String>();
	 
	 for(Doctor doc:docs) {
		 docNameStrings.add(doc.getName());
	 }
	 return docNameStrings ;
	 
 }
 
public ArrayList<String> patNamesList(ArrayList<Patient> patss){
	 
	 ArrayList<String> patNameStrings=new ArrayList<String>();
	 
	 for(Patient pat:patss) {
		 patNameStrings.add(pat.getName());
	 }
	 return patNameStrings ;
	 
 }


// intiation function 


public void intiateData() {
	
	HashMap<Doctor,ArrayList<String>> doctorsTime=new HashMap<Doctor,ArrayList<String>>();
	ArrayList<String> timeStrings =new ArrayList<String>();
	
	
	
	///
	 Doctor doctor =new Doctor("ali", 'M', "3zbt el qrod", "010011012013", 45, "ali@3zozo.com", "divorced", "dummy1", "dummy1", "heart");
	getDoctors().add(doctor);
	timeStrings.add("6:00");
	timeStrings.add("7:00");
	timeStrings.add("8:00");
	timeStrings.add("9:00");
	doctorsTime.put(doctor, timeStrings);
	schedule.initiateSchedule("Saturday", doctorsTime);
	schedule.initiateSchedule("Sunday", doctorsTime);
	schedule.initiateSchedule("Monday", doctorsTime);
	schedule.initiateSchedule("Tuesday", doctorsTime);
	schedule.initiateSchedule("Wednesday", doctorsTime);
	schedule.initiateSchedule("Thursday", doctorsTime);
	schedule.initiateSchedule("Friday", doctorsTime);
	
	//doctor added uername and password : dummy1 , dummy1
	
	Secretary secretary = new Secretary("sayeda", 'F', "cairo", "01501012013", 95, "sayeda@3azoz.com", "widow", "dummy1", "dummy1");
	getSecretaries().add(secretary);
	
	// secertary added uername and password : dummy1 , dummy1
	
	MedicalHistory medicalHistory = new MedicalHistory();
	
	medicalHistory.setTreatment("diabetes", "ansulin");
	medicalHistory.setTreatment("heart", "conxylophine");
	
	Patient pat1 = new Patient("sayeda", 'F', "cairo", "01501012013", 95, "sayeda@3azoz.com", "widow",getPatients().size(),medicalHistory);
	getPatients().add(pat1);
	
	Patient pat2 = new Patient("samira", 'F', "cairo", "01501012013", 20, "sayeda@3azoz.com", "widow",getPatients().size(),medicalHistory);
	getPatients().add(pat2);
	
	
	//schedule.setTimeSlots("saturday", doctor, "7;00");
	
	// patients
}


	//// set and get
	
	
	
	
	public  ArrayList<Secretary> getSecretaries() {
		return secretaries;
	}

	public  void setSecretaries(ArrayList<Secretary> secretaries) {
		
		this.secretaries = secretaries;
	}



	public  ArrayList<Patient> getPatients() {
		return patients;
	}

	public  void setPatients(ArrayList<Patient> patients) {
		
		
		this.patients = patients;
	}

	public  ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public  void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors=doctors;
	}

	public  ArrayList<Patient> getDoctorToPatientMap(Doctor d) {
		return doctorToPatientMap.get(d);
	}

	public  void setDoctorToPatientMap(Doctor d, ArrayList<Patient> pp) {
		doctorToPatientMap.put(d, pp);
	}

	public  ArrayList<Appointment> getDoctorToAppointmentsMap(Doctor d) {
		return doctorToAppointmentsMap.get(d);
	}

	public  void setDoctorToAppointmentsMap(Doctor d, ArrayList<Appointment> ap) {
		doctorToAppointmentsMap.put(d, ap);
	}

	public void addSecretary(Secretary secretary) {
		secretaries.add(secretary);
	}

	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}

	public  ArrayList<Patient> getPatientsOfADoctor(Doctor doctor) {
		return doctorToPatientMap.get(doctor);
	}


	public  void addPatientToDoctor(Doctor doctor, Patient patient) {
		doctorToPatientMap.get(doctor).add(patient);
	}

	public  void addAppointmentToDoctor(Doctor doctor, Appointment appointment) {
		doctorToAppointmentsMap.get(doctor).add(appointment);
	}
	
	
	public  Secretary getCurrentSecretary() {
		return currentSecretary;
	}

	public  void setCurrentSecretary(Secretary currentSecretary) {
		this.currentSecretary = currentSecretary;
	}


	public  Doctor getCurrentDoctor() {
		return currentDoctor;
	}


	public void setCurrentDoctor(Doctor currentDoctor) {
		this.currentDoctor = currentDoctor;
	}
	public boolean getLoginFlag() {
		return loginFlag;
		
	}

}
