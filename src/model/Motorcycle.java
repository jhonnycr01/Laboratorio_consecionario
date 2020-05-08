package model;

import model.types.BikeType;
import model.types.VehicleState;

public class Motorcycle extends Vehicle {
	private BikeType bikeType;
	private int gasolineCapacity;
	private int gasolineConsume;

	public Motorcycle(double totalSalePrice, double basePrice, String brand, String model,VehicleState vehicleState,
			String plate, String soat, String tecno, Client owner , Float displacement, BikeType bikeType, int gasolineCapacity, int gasolineConsume) {
		super(totalSalePrice, basePrice, brand, model, vehicleState, plate, displacement, soat, tecno, owner);
		this.bikeType = bikeType;
		this.gasolineCapacity = gasolineCapacity;
		this.gasolineConsume = gasolineConsume;
	}

	public BikeType getBikeType() {
		return bikeType;
	}

	public void setBikeType(BikeType bikeType) {
		this.bikeType = bikeType;
	}

	public int getGasolineCapacity() {
		return gasolineCapacity;
	}

	public void setGasolineCapacity(int gasolineCapacity) {
		this.gasolineCapacity = gasolineCapacity;
	}

	public int getGasolineConsume() {
		return gasolineConsume;
	}

	public void setGasolineConsume(int gasolineConsume) {
		this.gasolineConsume = gasolineConsume;
	}
	
	

}
