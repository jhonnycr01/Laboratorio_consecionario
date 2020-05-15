package model;

import model.types.CarType;
import model.types.VehicleState;

public abstract class Car extends Vehicle{
	
	private CarType carType;
	private int numberDoors;
	private boolean polarized;
	
	
	public Car(double totalSalePrice, double basePrice, String brand, int model, VehicleState vehicleState,
			String plate, float displacement, Soat soat, TechnoMechanical techno,CarType carType, int numberDoors,
			boolean polarized) {
		super(totalSalePrice, basePrice, brand, model, vehicleState, plate, displacement, soat, techno);
		this.carType = carType;
		this.numberDoors = numberDoors;
		this.polarized = polarized;
	}
	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	public int getNumberDoors() {
		return numberDoors;
	}
	public void setNumberDoors(int numberDoors) {
		this.numberDoors = numberDoors;
	}
	public boolean isPolarized() {
		return polarized;
	}
	public void setPolarized(boolean polarized) {
		this.polarized = polarized;
	}
	@Override
	public String toString() {
		String information = super.toString();
		information =   information
						+ "Car Type:\t" + this.getCarType().toString() + "\n"
						+ "Number doors:\t\t" + this.getNumberDoors() + "\n"
						+ "Polarized:\t\t" + (this.isPolarized() ? "Yes":"No") + "\n";
						
		return information;
		
	}	
	
	
}
