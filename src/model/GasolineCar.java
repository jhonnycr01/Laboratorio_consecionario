package model;

import model.types.CarType;
import model.types.GasType;
import model.types.VehicleState;

public class GasolineCar extends Car implements IGasoline{

	private int tankCapacity;
	private GasType gasType;
	private int gasConsume;
	public GasolineCar(double totalSalePrice, double basePrice, String brand, String model, VehicleState vehicleState,
			String plate, float displacement, String soat, String tecno, Client owner, CarType carType, int numberDoors,
			boolean polarized, int tankCapacity, GasType gasType, int gasConsume) {
		super(totalSalePrice, basePrice, brand, model, vehicleState, plate, displacement, soat, tecno, owner, carType,
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
	
	
}
