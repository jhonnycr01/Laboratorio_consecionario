package model;

import model.types.VehicleState;

public class Vehicle {
	private double totalSalePrice;
	private double basePrice;
	private String brand;
	private String model;
	private VehicleState vehicleState;
	private float displacement;
	private String plate;
	private String soat;
	private String technoMechanical;
	private Client owner;
	
	public Vehicle(double totalSalePrice, double basePrice, String brand, String model, VehicleState vehicleState,
			String plate,float displacement, String soat, String tecno, Client owner) {
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
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

	public String getSoat() {
		return soat;
	}

	public void setSoat(String soat) {
		this.soat = soat;
	}

	public String getTecno() {
		return technoMechanical;
	}

	public void setTecno(String tecno) {
		this.technoMechanical = tecno;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}
	
	
	public static double totalSalePrice(Vehicle vehicle) {
		return 2.00;
	}
	

}
