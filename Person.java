public class Person {
  private String name;
  private char gender;
  private String address;
  private String mobileNumber;
  private int age;
  private String email;
  private String martialStatus;

  Person(
      String name,
      char gender,
      String address,
      String mobileNumber,
      int age,
      String email,
      String martialStatus) {
    this.name = name;
    this.gender = gender;
    this.adress = adress;
    this.mobileNumber = mobileNumber;
    this.age = age;
    this.email = email;
    this.martialStatus = martialStatus;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMartialStatus() {
    return martialStatus;
  }

  public void setMartialStatus(String martialStatus) {
    this.martialStatus = martialStatus;
  }
}
