package application;

import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {
	private  HashMap<String, HashMap<Doctor,ArrayList<String>>> timeSlots = new HashMap<String, HashMap<Doctor,ArrayList<String>>>();

	 
	 
	public  HashMap<String, HashMap<Doctor,ArrayList<String>>> getTimeSlots() {
		return timeSlots;
	}

	public  void setTimeSlots(String day, Doctor doctor,String time) {
		
	
		timeSlots.get(day).get(doctor).add(time);
	
	
		
	//	timeSlots.get(time).re
		}
	
	public void addDirect(HashMap<String, HashMap<Doctor,ArrayList<String>>> timeSlots) {
		this.timeSlots=timeSlots;
	}
	
	public void initiateSchedule(String day,  HashMap<Doctor,ArrayList<String>> doctorsTime ) {
		timeSlots.put(day, doctorsTime);
		
		
	}
	
/*	
	public void setDays() {
		timeSlots.put("Saturday", null);
		timeSlots.put("Sunday", null);
		timeSlots.put("Monday", null);
		timeSlots.put("Tuesday", null);
		timeSlots.put("Wednesday", null);
		timeSlots.put("Thursday", null);
		timeSlots.put("Friday", null);
	}
	
	
	public void setDoctorsofDays() {
		
	}*/
	
	//"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"
}
