package model;

import java.util.ArrayList;

public class Client extends Person {
	private String phoneNumber;
	private String email;
	private ArrayList<Vehicle> interestVehicles;
	
	public Client(String name, String lastName, String id, String phoneNumber, String email) {
		super(name,lastName,id);
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.interestVehicles = new ArrayList<>();
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void interestVehicle( Vehicle vehicle) {
		this.interestVehicles.add(vehicle);		
	}

	public ArrayList<Vehicle> getInterestVehicles() {
		return interestVehicles;
	}

}
