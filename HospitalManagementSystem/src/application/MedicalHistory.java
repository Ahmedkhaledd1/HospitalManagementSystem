package application;
import java.util.ArrayList; //atomatically expands when new elemnet is added // same in shrinkage 
import java.util.Map;
import java.util.HashMap;
public class MedicalHistory {
	private ArrayList<String> symptoms ;
    private Map<String,String> treatment;
    
    MedicalHistory()
    {
        this.symptoms =  new ArrayList<>();
        this.treatment= new HashMap<String, String>();
    }
    public ArrayList<String> getSymptoms() {
        return symptoms;
    }

    public Map<String, String> getTreatment() {
        return treatment;
    }

    public void setTreatment(String symptom, String treat) { // samll edit: this fn takes only two strings not map to add them to the map
        this.treatment.put(symptom,treat);
        this.setSymptoms(symptom);
    }

    private void setSymptoms(String Symptom) {   // small edit: 1-the fn takes only one  string at a time not an array list so it could add it to the array list 
        symptoms.add(Symptom);                   //             2-the fn is private because it s invoked in setTreatment fn 
    }
    

    
    
}
