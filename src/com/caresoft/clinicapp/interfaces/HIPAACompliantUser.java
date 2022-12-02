package com.caresoft.clinicapp.interfaces;

public interface HIPAACompliantUser {
	
	//contracts for our classes that implement this HIPPACompliantUser interface to fill out the body of the method.
    abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
}

