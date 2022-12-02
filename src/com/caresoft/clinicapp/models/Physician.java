package com.caresoft.clinicapp.models;

import java.sql.Date;
import java.util.ArrayList;

import com.caresoft.clinicapp.interfaces.HIPAACompliantUser;

// TO DO: Implement HIPAACompliantUser!
public class Physician extends User implements HIPAACompliantUser {
//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    	
    // TO DO: Constructor that takes an ID
    public Physician() {
    }
    public Physician(Integer id) {
    	this.id = id;
    }
    
    
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    // TO DO: Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	@Override
	public boolean assignPin(int pin) {
		if(pin<=9999 && pin>=1000) {
			return false;
		}else {
		return true;
		}
	}
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (confirmedAuthID == this.id) {
			return true;
		}else {			
			return false;
		}
	}
	


}
