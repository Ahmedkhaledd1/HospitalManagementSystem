package application;

public class Appointment {
	String date;
	String reservationTime;
	Doctor doctor;
	boolean excuse;

	public Appointment(String date, String reservationTime, Doctor doctor, boolean excuse) {
		this.date = date;
		this.reservationTime = reservationTime;
		this.doctor = doctor;
		this.excuse = excuse;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public boolean isExcuse() {
		return excuse;
	}

	public void setExcuse(boolean excuse) {
		this.excuse = excuse;
	}

}
