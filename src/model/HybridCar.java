package model;

public class HybridCar extends Vehicle {

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

	
	

}
