package application;

import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {
	private  HashMap<String, HashMap<Doctor,ArrayList<String>>> timeSlots = new HashMap<String, HashMap<Doctor,ArrayList<String>>>();
	//private HashMap<Doctor,ArrayList<String>> doctorsTime = new  HashMap<Doctor,ArrayList<String>>();
	//rivate HashMap<String,String> dd = new  HashMap<String,String>();
	//private ArrayList<String> timeofDay = new  ArrayList<String>();
	 
	 
	public  HashMap<String, HashMap<Doctor,ArrayList<String>>> getTimeSlots() {
		return timeSlots;
	}

	public  void setTimeSlots(String day, Doctor doctor,String time) {
		
	
		timeSlots.get(day).get(doctor).add(time);
		
		
		}
}
