package application;

public class Patient extends Person {

	private int id;
    private MedicalHistory history;

    Patient(String name, char gender, String address, String mobileNumber,
            int age, String email, String martialStatus, int id, MedicalHistory history) {
        super(name, gender, address, mobileNumber, age, email, martialStatus);
        this.id = id;
        this.history = history;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicalHistory getHistory() {
        return history;
    }

    public void setHistory(MedicalHistory history) {
        this.history = history;
    }

}
