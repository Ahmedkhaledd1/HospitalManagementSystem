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
    super(name, gender, adress, mobileNumber, age, email, martialStatus, userName, password);
    this.userName = userName;
    this.password = password;
  }

  Patient register(String name,
      char gender,
      String address,
      String mobileNumber,
      int age,
      String email,
      String martialStatus) {

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

  public void login(String userName, String password) {
    // I am assuing SystemManager.getSecretaries() returns all the secretaries in the database
    for (Secretary sec : SystemManager.getSecretaries()) {
      if (sec.getUserName().equals(userName) && sec.getPassword().equals(password)) {
        System.out.println("I am logged in as a secretary");
      }
    }
  }

  public void addApointment(String date, String reservationTime, Doctor doctor, bool excuse) {
    // This function should be in SystemManager in my opinion
    Appointment appointment = new Appointment(date, reservationTime, doctor, excuse);
    SystemManger.addAppointmentToDoctor(doctor, appointment);

  }

  public void editApointment(Doctor doctor, Apointment appointment, Appointment newAppointment) {
    SystemManger.editAppointment(doctor, appointment, newAppointment);
  }

  public void initiateExcuse(Schedule schedule, Doctor doctor) {

  }

  public void editSchedule(Schedule schedule) {
    // edit the schedule with what?

  }

  public void displaySchedule() {

  }

}
