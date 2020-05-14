package model;

import model.types.BikeType;
import model.types.VehicleState;

public class Motorcycle extends Vehicle {
	private BikeType bikeType;
	private int gasolineCapacity;
	private int gasolineConsume;

	public Motorcycle(double totalSalePrice, double basePrice, String brand, int model,VehicleState vehicleState,
			String plate, Soat soat, TechnoMechanical techno, float displacement, BikeType bikeType, int gasolineCapacity, int gasolineConsume) {
		super(totalSalePrice, basePrice, brand, model, vehicleState, plate, displacement, soat, techno);
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
	
	@Override
	public double totalSalePrice(double percentDiscount) {
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
		double discountValue = salePrice * (percentDiscount / 100);
		salePrice -= discountValue; 
		
		return salePrice;
	}

	@Override
	public String toString() {
		String information = super.toString();
		information =  "\nVehicle Type:\tMotorCycle" + "\n"
						+ information
						+ "Total sale price:\t" + this.totalSalePrice(0) + "\n"
						+ "Gasoline capacity:\t" + this.getGasolineCapacity() + "\n\n";
		return information;
	}
}
