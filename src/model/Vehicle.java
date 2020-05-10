package model;

import java.util.Calendar;
import java.util.Date;

import model.types.VehicleState;

public abstract class Vehicle {
	private double totalSalePrice;
	private double basePrice;
	private String brand;
	private int model;
	private VehicleState vehicleState;
	private float displacement;
	private String plate;
	private Soat soat;
	private TechnoMechanical technoMechanical;
	private Client owner;
	
	public Vehicle(double totalSalePrice, double basePrice, String brand, int model, VehicleState vehicleState,
			String plate,float displacement, Soat soat, TechnoMechanical tecno, Client owner) {
		this.totalSalePrice = totalSalePrice;
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.vehicleState = vehicleState;
		this.displacement = displacement;
		this.plate = plate;
		this.soat = soat;
		this.technoMechanical = tecno;
		this.owner = owner;
	}
	
	

	public float getDisplacement() {
		return displacement;
	}



	public void setDisplacement(float displacement) {
		this.displacement = displacement;
	}



	public double getTotalSalePrice() {
		return totalSalePrice;
	}

	public void setTotalSalePrice(double totalSalePrice) {
		this.totalSalePrice = totalSalePrice;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public VehicleState getVehicleState() {
		return vehicleState;
	}

	public void setVehicleState(VehicleState vehicleState) {
		this.vehicleState = vehicleState;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Soat getSoat() {
		return soat;
	}

	public void setSoat(Soat soat) {
		this.soat = soat;
	}

	public TechnoMechanical getTechnoMechanical() {
		return technoMechanical;
	}

	public void setTechnoMechanical(TechnoMechanical tecno) {
		this.technoMechanical = tecno;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}
	
	public boolean IsDocumentsDefeated() {
		boolean defeated = false;
		Calendar calendar = (Calendar) Calendar.getInstance();
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);
		if(this.getSoat().getYear() < currentYear || this.getTechnoMechanical().getYear() < currentYear) {
			defeated = true;
		}
		return defeated;
	}
	
	public abstract double totalSalePrice(double percentDiscount);

}

