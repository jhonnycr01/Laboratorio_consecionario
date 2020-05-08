package model;

public class Car extends Vehicle{
	
	private CarType carType;
	private int numberDoors;
	private boolean polarized;
	
	
	public Car(double totalSalePrice, double basePrice, String brand, String model, VehicleState vehicleState,
			String plate, float displacement, String soat, String tecno, Client owner, CarType carType, int numberDoors,
			boolean polarized) {
		super(totalSalePrice, basePrice, brand, model, vehicleState, plate, displacement, soat, tecno, owner);
		this.carType = carType;
		this.numberDoors = numberDoors;
		this.polarized = polarized;
	}
	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	public int getNumberDoors() {
		return numberDoors;
	}
	public void setNumberDoors(int numberDoors) {
		this.numberDoors = numberDoors;
	}
	public boolean isPolarized() {
		return polarized;
	}
	public void setPolarized(boolean polarized) {
		this.polarized = polarized;
	}
	
	
	

}
