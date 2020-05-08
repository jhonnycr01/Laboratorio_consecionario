package model;

import java.util.ArrayList;

public class Automotor {
	private ArrayList<Vehicle> vehicles;
	
	public ArrayList<Vehicle> getVehicles(){
		return vehicles;
	}
	
	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}

	public Automotor() {
		this.vehicles = new ArrayList<>();
	}

}
