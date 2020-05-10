package model;

import model.types.ChargerType;
import model.types.GasType;
import model.types.VehicleState;

public class HybridCar extends Vehicle implements IGasoline, IBattery {

	private ChargerType chargerType;
	private int batteryDuration;
	private int batteryConsume;
	private int tankCapacity;
	private GasType gasType;
	private int gasConsume;
	
	public HybridCar(double totalSalePrice, double basePrice, String brand, String model, VehicleState vehicleState,
			String plate, float displacement, String soat, String tecno, Client owner, ChargerType chargerType,
			int batteryDuration, int batteryConsume, int tankCapacity, GasType gasType, int gasConsume) {
		super(totalSalePrice, basePrice, brand, model, vehicleState, plate, displacement, soat, tecno, owner);
		this.chargerType = chargerType;
		this.batteryDuration = batteryDuration;
		this.batteryConsume = batteryConsume;
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasConsume = gasConsume;
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
	public double consumeBattery() {
		double consume = 0;
		if(this.getChargerType() == ChargerType.QUICK) {
			consume = this.getBatteryDuration() * (this.getDisplacement() / 100);
		} else if(this.getChargerType() == ChargerType.NORMAL )  {
			consume = (this.getBatteryDuration() + 5 ) * (this.getDisplacement() / 100);
		}
		return consume;
	}

	@Override
	public double consumeTotalGasoline() {
		return this.getTankCapacity() * (this.getDisplacement() / 110);
	}

	
	public double totalSalePrice() {
		double salePrice= (this.getBasePrice() + 1.15);
		if(this.getVehicleState()== VehicleState.Used) {
			salePrice= (this.getBasePrice() * 0.9);
		}
		return salePrice;
	}
	
	

}
