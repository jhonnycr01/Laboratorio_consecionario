package model;

import java.util.ArrayList;

import model.types.VehicleState;

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
	
	public ArrayList<Vehicle> getVechiclesByState(VehicleState vehicleState){
		ArrayList <Vehicle> filterVehicle = new ArrayList<>();
		for(Vehicle vehicle : this.vehicles) {
			if(vehicle.getVehicleState() ==  vehicleState) {
				filterVehicle.add(vehicle);
			}
		}
		return filterVehicle;
	}

}
