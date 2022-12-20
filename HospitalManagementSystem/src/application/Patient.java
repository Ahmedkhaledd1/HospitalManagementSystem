package application;

public class Patient extends Person {

	private String id;
    private MedicalHistory history;

    Patient(String name, char gender, String address, String mobileNumber,
            int age, String email, String martialStatus, String id, MedicalHistory history) {
        super(name, gender, address, mobileNumber, age, email, martialStatus);
        this.id = id;
        this.history = history;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MedicalHistory getHistory() {
        return history;
    }

    public void setHistory(MedicalHistory history) {
        this.history = history;
    }

}
