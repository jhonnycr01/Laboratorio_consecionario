package model;

import model.types.CarType;
import model.types.ChargerType;
import model.types.GasType;
import model.types.VehicleState;

public class HybridCar extends Car implements IGasoline, IBattery {

	private ChargerType chargerType;
	private int batteryDuration;
	private int batteryConsume;
	private int tankCapacity;
	private GasType gasType;
	private int gasConsume;
	
	public HybridCar(double totalSalePrice, double basePrice, String brand, int model, VehicleState vehicleState,
			String plate, float displacement, Soat soat, TechnoMechanical techno, CarType carType, int numberDoors,
			boolean polarized, ChargerType chargerType,
			int batteryDuration, int batteryConsume, int tankCapacity, GasType gasType, int gasConsume) {
		super(totalSalePrice, basePrice, brand, model, vehicleState, plate, displacement, soat, techno, carType, numberDoors,
				polarized);
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

	
	@Override
	public double totalSalePrice(double percentDiscount) {
		double salePrice = (this.getBasePrice() * 1.15);
		if(this.IsDocumentsDefeated()) {
			salePrice += 500_000;
		}
		if(this.getVehicleState() == VehicleState.Used) {
			salePrice -= (salePrice * 0.1);
		}
		//si los documentos estan vencidos cobrar $500.000 más
		// los Hibridos cuesta un 15% adicional al precio base
		// si es usado tiene un descuento del 10%
		double discountValue = salePrice * (percentDiscount / 100);
		salePrice -= discountValue; 
		
		return salePrice;
	}
	
	@Override
	public String toString() {
		String information = super.toString();
		information =  "\nVehicle Type:\tHybrid Car" + "\n"
						+ information
						+ "Total sale price:\t" + this.totalSalePrice(0) + "\n"
						+ "Charger Type:\t\t" + this.getChargerType().toString() + "\n"
						+ "Battery Duration:\t" + this.getBatteryDuration() + "\n"
						+ "Battery consume:\t" + this.getBatteryConsume() + "\n"								
						+ "Tank capacity:\t\t" + this.getTankCapacity() + "\n"
						+ "Gas Type:\t\t" + this.getGasType().toString() + "\n"
						+ "Gas consume:\t\t" + this.getGasConsume() + "\n";
						
		return information;
		
	}	
	
	

}
