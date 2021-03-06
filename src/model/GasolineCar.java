package model;

import model.types.*;

public class GasolineCar extends Car implements IGasoline{

	private int tankCapacity;
	private GasType gasType;
	private int gasConsume;
	public GasolineCar(double totalSalePrice, double basePrice, String brand, int model, VehicleState vehicleState,
			String plate, float displacement, Soat soat, TechnoMechanical techno, CarType carType, int numberDoors,
			boolean polarized, int tankCapacity, GasType gasType, int gasConsume) {
		super(totalSalePrice, basePrice, brand, model, vehicleState, plate, displacement, soat, techno, carType,
				numberDoors, polarized);
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasConsume = gasConsume;
	}
	public int getTankCapacity() {
		return tankCapacity;
	}
	public void setTankCapacity(int tankCapacity) {
		this.tankCapacity = tankCapacity;
	}
	public GasType getGasType() {
		return gasType;
	}
	public void setGasType(GasType gasType) {
		this.gasType = gasType;
	}
	public int getGasConsume() {
		return gasConsume;
	}
	public void setGasConsume(int gasConsume) {
		this.gasConsume = gasConsume;
	}
	@Override
	public double consumeTotalGasoline() {
		return this.getTankCapacity() * (this.getDisplacement() / 100);
	}
	
	@Override
	public double totalSalePrice(double percentDiscount) {
		double salePrice = this.getBasePrice();
		if(this.IsDocumentsDefeated()) {
			salePrice += 500_000;
		}
		if(this.getVehicleState() == VehicleState.Used) {
			salePrice -= (salePrice * 0.1);
		}
		//si los documentos estan vencidos cobrar $500.000 más
		// los de gasolina no se les varia nada  al precio base
		// si es usado tiene un descuento del 10%
		//el concesionario puede descontarle un porcentaje adicional
		double discountValue = salePrice * (percentDiscount / 100);
		salePrice -= discountValue; 
		
		return salePrice;
	}
	@Override
	public String toString() {
		String information = super.toString();
		information =  "\nVehicle Type:\tGasoline Car" + "\n"
						+ information
						+ "Total sale price:\t" + this.totalSalePrice(0) + "\n"
						+ "Tank capacity:\t\t" + this.getTankCapacity() + "\n"
						+ "Gas Type:\t\t" + this.getGasType().toString() + "\n"
						+ "Gas consume:\t\t" + this.getGasConsume() + "\n";
						
		return information;
		
	}	
	
	
	
}
