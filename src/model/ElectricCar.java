package model;

import model.types.ChargerType;
import model.types.VehicleState;

public class ElectricCar extends Vehicle implements IBattery {

	private ChargerType chargerType;
	private int batteryDuration;
	private int batteryConsume;
	
	public ElectricCar(double totalSalePrice, double basePrice, String brand, int model, VehicleState vehicleState,
			String plate, float displacement, Soat soat, TechnoMechanical tecno, Client owner, ChargerType chargerType,
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
	
	@Override
	public double consumeBattery() {
		double consume=0;
		if(this.getChargerType() == ChargerType.QUICK) {
			consume = (this.getBatteryDuration() + 10 ) * (this.getDisplacement() / 100);
		}
			else if(this.getChargerType()== ChargerType.NORMAL) {
				consume =(this.getBatteryConsume() + 15) * (this.getDisplacement() / 100);
			}
			return consume;
		}
	
	
	@Override
	public double totalSalePrice(double percentDiscount) {
		double salePrice = (this.getBasePrice() * 1.2);
		if(this.IsDocumentsDefeated()) {
			salePrice += 500_000;
		}
		if(this.getVehicleState() == VehicleState.Used) {
			salePrice -= (salePrice * 0.1);
		}
		//si los documentos estan vencidos cobrar $500.000 más
		// los electricos cuesta un 20% adicional al precio base
		// si es usado tiene un descuento del 10%
		double discountValue = salePrice * (percentDiscount / 100);
		salePrice -= discountValue; 
		
		return salePrice;
	}
	
	
	
	}
