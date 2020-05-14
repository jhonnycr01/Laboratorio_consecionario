package model;

import java.util.ArrayList;

import model.types.VehicleState;

public class Automotor {
	private ArrayList<Vehicle> vehicles;
	private ArrayList<Vehicle> vehiclesSold;
	private Vehicle[][] parkingLot;
	
	public Automotor() {
		this.vehicles = new ArrayList<>();
		this.parkingLot = new Vehicle[10][5];
	}
	
	
	public ArrayList<Vehicle> getVehicles(){
		return vehicles;
	}
	
	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}

	
	public ArrayList<Vehicle> getVehiclesByState(VehicleState vehicleState){
		ArrayList <Vehicle> filterVehicle = new ArrayList<>();
		for(Vehicle vehicle : this.vehicles) {
			if(vehicle.getVehicleState() ==  vehicleState) {
				filterVehicle.add(vehicle);
			}
		}
		return filterVehicle;
	}

	public ArrayList<Vehicle> getVehiclesByState(){
		return this.vehicles;
	}

	public ArrayList<Vehicle> getVehiclesSold() {
		return vehiclesSold;
	}

	public void sellVehicle(Vehicle vehicle) {
		this.vehiclesSold.add(vehicle);
		this.vehicles.remove(vehicle);
	}
	
	public boolean saveOldCars() {
		boolean saved = true;
		for(Vehicle vehicle: this.vehicles) {
			if(vehicle.getVehicleState() == VehicleState.Used && 
					vehicle.getModel() < 2015) {
				if(! this.addVehicleToParkingLot(vehicle)) {
					//if can not saved
					saved = false;
					break;
				}
			}
		}
		return saved;
	}
	public boolean addVehicleToParkingLot(Vehicle vehicle) {
		boolean saved = false;
		switch(vehicle.getModel()) {
		case 2014:
			//Column 1
			saved = this.addVehicleToParkingLotColumn(vehicle,1);			
			break;
		case 2013:
			//Column 2
			saved = this.addVehicleToParkingLotColumn(vehicle,2);	
			break;
		case 2012: 
			//Column 3
			saved = this.addVehicleToParkingLotColumn(vehicle,3);	
			break;
		case 2011:
			//Column 4
			saved = this.addVehicleToParkingLotColumn(vehicle,4);	
			break;
		
		}
		if(!saved) {
			// don't can saved
			if(vehicle.getModel() < 2012) {
				saved = this.addVehicleToParkingLotColumn(vehicle,5);
			}
		}
		
		return saved;
	}
	
	public boolean addVehicleToParkingLotColumn(Vehicle vehicle,int column) {
		int indexCol = column - 1;
		boolean added = false;
		for(int x = 0;x<this.parkingLot[0].length;x++) {
			if(this.parkingLot[indexCol][x] == null) {
				this.parkingLot[indexCol][x] = vehicle;
				added = true;
				break;
			}
		}
		return added;
	}
	
	public boolean isFullParkingLot() {
		boolean isFull = true;
		for(int i = 0; i< this.parkingLot.length;i++) {
			for(int j= 0; j < this.parkingLot[0].length;j++) {
				if(this.parkingLot[i][j] == null) {
					isFull = false;
					break;
				}
			}
		}
		return isFull;
	}
	
	public ArrayList<Vehicle> getVehiclesInParkingLot(int year){
		int indexCol = 0;
		ArrayList<Vehicle> vehicles = new ArrayList<>(); 
		switch(year) {
			case 2014:
				indexCol = 0;
				break;
			case 2013:
				indexCol = 1;
				break;
			case 2012:
				indexCol = 2;
				break;
			case 2011:
				indexCol = 3;
				break;
		}
		if(year < 2011) {
			indexCol = 4;
		}
		
		for(int x = 0; x < this.parkingLot[0].length;x++) {
			if(this.parkingLot[indexCol][x] != null) {
				vehicles.add(this.parkingLot[indexCol][x]);	
			}			
		}
		return vehicles;
	}
	
	public ArrayList<Vehicle> getVehiclesGasolineCars() {
		ArrayList<Vehicle> gasolineCars = new ArrayList<>();
		
		for(Vehicle vehicle: this.getVehicles()) {
			if(vehicle.getClass() == GasolineCar.class) {
				gasolineCars.add((GasolineCar) vehicle);
			}			
		}		
		return gasolineCars;
	}
	public ArrayList<Vehicle> getVehicleElectricCars() {
		ArrayList<Vehicle> electricCars = new ArrayList<>();
		
		for(Vehicle vehicle: this.getVehicles()) {
			if(vehicle.getClass() == ElectricCar.class) {
				electricCars.add((ElectricCar) vehicle);
			}			
		}		
		return electricCars;
	}
	public ArrayList<Vehicle> getVehicleHybridCars() {
		ArrayList<Vehicle> hybridCars = new ArrayList<>();
		
		for(Vehicle vehicle: this.getVehicles()) {
			if(vehicle.getClass() == HybridCar.class) {
				hybridCars.add((HybridCar) vehicle);
			}			
		}		
		return hybridCars;
	}
	public ArrayList<Vehicle> getVehicleMotorcycles() {
		ArrayList<Vehicle> motorcycles = new ArrayList<>();
		
		for(Vehicle vehicle: this.getVehicles()) {
			if(vehicle.getClass() == Motorcycle.class) {
				motorcycles.add((Motorcycle) vehicle);
			}			
		}		
		return motorcycles;
	}
	
	
	

}
