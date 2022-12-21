package application;

public class Doctor extends Person {
	private String specialization ;
	private String userName ;
	private String password ;
	
	Doctor(String name, char gender, String address, String mobileNumber, int age, String email, String martialStatus,String userName,String password,String specialization) {
		super(name, gender, address, mobileNumber, age, email, martialStatus);
		// TODO Auto-generated constructor stub
		this.userName=userName;
		this.password=password;
		this.specialization=specialization;
	}
	
	///////main functions of doctor
	public boolean login(String userName,String password)
	{
		if(this.userName.equals(userName) && this.password.equals(password))
			return true;
		else
			return false;
	}

	public MedicalHistory getPatientMedicalHistory(Patient p) {
		return p.getHistory();
	}
	
	public void editPatientMedicalHistory(String diagnose,String treatment,Patient p) {
		getPatientMedicalHistory(p).setTreatment( diagnose, treatment);
	}
	///seters and geters 
	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
