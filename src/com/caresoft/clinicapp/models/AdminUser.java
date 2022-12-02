package com.caresoft.clinicapp.models;

import java.util.Date;
import java.util.ArrayList;

import com.caresoft.clinicapp.interfaces.HIPAACompliantAdmin;
import com.caresoft.clinicapp.interfaces.HIPAACompliantUser;

// TO DO: Implement HIPAACompliantUser!
// TO DO: Implement HIPAACompliantAdmin!
public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin{
//... imports class definition...
	Date date = new Date();
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser() {
    	super();
    	// TODO Auto-generated constructor stub
    }
    public AdminUser(Integer employeeID, String role){
    	this.employeeID = employeeID;
    	this.role = "no role set";
    	this.securityIncidents = new ArrayList<String>();
    }
    

    // TO DO: Setters & Getters
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	@Override
	public boolean assignPin(int pin) {
		if(this.pin < 6) {
			return false;
		}else {
			return true; 	
		}
		
	}
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID != this.id) {
			authIncident();
			return false;
			 
		}else {
			return true;			
		}
	}
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		
		return getSecurityIncidents();
	}
	
	//Methods
	
	public void newIncident(String notes) {
		String report = String.format(
				"Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", new Date(), this.employeeID, notes);
		securityIncidents.add(report);
	}
	public void authIncident() {
		String report = String.format(
				"Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", new Date(), employeeID, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}


}
