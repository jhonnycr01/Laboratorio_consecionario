package model;

import model.types.ChargerType;
import model.types.VehicleState;

public class ElectricCar extends Vehicle{

	private ChargerType chargerType;
	private int batteryDuration;
	private int batteryConsume;
	
	public ElectricCar(double totalSalePrice, double basePrice, String brand, String model, VehicleState vehicleState,
			String plate, float displacement, String soat, String tecno, Client owner, ChargerType chargerType,
			int batteryDuration, int batteryConsume) {
		super(totalSalePrice, basePrice, brand, model, vehicleState, plate, displacement, soat, tecno, owner);
		this.chargerType = chargerType;
		this.batteryDuration = batteryDuration;
		this.batteryConsume = batteryConsume;
	}
	public ChargerType getChargerType() {
		return chargerType;
	}
	public void setChargerType(ChargerType chargerType) {
		this.chargerType = chargerType;
	}
	public int getBatteryDuration() {
		return batteryDuration;
	}
	public void setBatteryDuration(int batteryDuration) {
		this.batteryDuration = batteryDuration;
	}
	public int getBatteryConsume() {
		return batteryConsume;
	}
	public void setBatteryConsume(int batteryConsume) {
		this.batteryConsume = batteryConsume;
	}
	
	

}
