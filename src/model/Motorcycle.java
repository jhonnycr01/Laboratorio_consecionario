package model;

import model.types.BikeType;
import model.types.VehicleState;

public class Motorcycle extends Vehicle {
	private BikeType bikeType;
	private int gasolineCapacity;
	private int gasolineConsume;

	public Motorcycle(double totalSalePrice, double basePrice, String brand, String model,VehicleState vehicleState,
			String plate, Soat soat, TechnoMechanical tecno, Client owner , Float displacement, BikeType bikeType, int gasolineCapacity, int gasolineConsume) {
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
	
	public double totalSalePrice() {
		double salePrice= (this.getBasePrice() + 1.04);
		if(this.getVehicleState()== VehicleState.Used) {
			salePrice= (this.getBasePrice() * 0.98);
		}
		return salePrice;
	}
	
	@Override
	public double totalSalePrice(double discount) {
		double salePrice = (this.getBasePrice() * 1.04);
		if(this.IsDocumentsDefeated()) {
			salePrice += 500_000;
		}
		if(this.getVehicleState() == VehicleState.Used) {
			salePrice -= (salePrice * 0.02);
		}
		//si los documentos estan vencidos cobrar $500.000 más
		// los de gasolina no se les varia nada  al precio base
		// si es usado tiene un descuento del 10%
		
		return salePrice;
	}	

}
