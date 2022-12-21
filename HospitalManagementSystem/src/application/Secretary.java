package application;

class Secretary extends Person {
  private String userName;
  private String password;

  Secretary(
      String name,
      char gender,
      String address,
      String mobileNumber,
      int age,
      String email,
      String martialStatus,
      String userName,
      String password
  ) 
  {
    super(name, gender, address, mobileNumber, age, email, martialStatus);
    this.userName = userName;
    this.password = password;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  //main functions

  Patient register(String name,
      char gender,
      String address,
      String mobileNumber,
      int age,
      String email,
      String martialStatus) {
	  MedicalHistory medicalHistory = new MedicalHistory();
	  Patient patient = new Patient(name, gender, address, mobileNumber, age, email, martialStatus, mobileNumber, medicalHistory);
	  return patient;
  }

  public boolean login(String userName, String password) {
	  //SystemManager.loginSecretary(userName, password);
	  if(this.userName.equals(userName) && this.password.equals(password))
			return true;
		else
			return false;
  }

  public Appointment addApointment(String date, String reservationTime, Doctor doctor, boolean excuse) {
    Appointment appointment = new Appointment(date, reservationTime, doctor, excuse);
   
    return appointment;
    
   // SystemManager.addAppointmentToDoctor(doctor, appointment);
  }

  public void editApointment( Appointment ap,String date, String reservationTime, Doctor doctor, boolean excuse) {
	  
	  ap.setDate(date);
	  ap.setDoctor(doctor);
	  ap.setExcuse(excuse);
	  ap.setReservationTime(reservationTime);
	  
	  //SystemManager.editAppointment(doctor, appointment, newAppointment);

  }

  public void initiateExcuse(Schedule schedule, Doctor doctor) {
	  //TODO

  }

  public void editSchedule(Schedule schedule) {
	  //TODO

  }

  public void displaySchedule() {
	  //TODO

  }
  
  
  
  
  /// set and get
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
