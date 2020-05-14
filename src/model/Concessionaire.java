
package model;

import model.types.VehicleState;

import java.util.ArrayList;

public class Concessionaire {
	private String name;
	private String nit;
	private double totalGain; 
	private int numberSales;
	private ArrayList<Seller> sellers;
	private Automotor automotor;

	
	public ArrayList<Seller> getSellers(){
		return sellers;
	}
	
	public void addSeller(Seller seller) {
		this.sellers.add(seller);
	}
	
	public Concessionaire(String name, String nit) {
		this.name = name;
		this.nit = nit;
		this.totalGain = 0;
		this.numberSales = 0;
		this.automotor = new Automotor();
		this.sellers = new ArrayList<>();
		
	}

	public boolean attendClient(Client client){
		boolean attended = false;
		for(Seller seller : this.getSellers()){
			if(seller.addClient(client)){
				attended = true;
				break;
			}
		}
		return attended;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getNit() {
		return nit;
	}



	public void setNit(String nit) {
		this.nit = nit;
	}



	public double getTotalGain() {
		return totalGain;
	}



	public void sumTotalGain(double totalSale) {
		this.totalGain += totalSale;
	}



	public int getNumberSales() {
		return numberSales;
	}



	public void sumNumberSales(int numberSales) {
		this.numberSales += numberSales;
	}

	public Automotor getAutomotor() {
		return automotor;
	}

	public void setSellers(ArrayList<Seller> sellers) {
		this.sellers = sellers;
	} 
	
	public void sellVehicle(Vehicle vehicle, Seller seller, Client client) {
		double price = vehicle.getTotalSalePrice();
		this.sumTotalGain(price);
		this.sumNumberSales(1);
		vehicle.setOwner(client); //assign owner to vehicle
		this.automotor.sellVehicle(vehicle);
		
	}

	public ArrayList<Vehicle> getVehicleByState(VehicleState vehicleState){
		return this.getAutomotor().getVehiclesByState(vehicleState);
	}
	public ArrayList<Vehicle> getVehicleByState(){
		return this.getAutomotor().getVehiclesByState();
	}
	
	public ArrayList<Vehicle> getVehicleGasolineCars(){
		return this.getAutomotor().getVehiclesGasolineCars();
	}
	public ArrayList<Vehicle> getVehicleElectricCars(){
		return this.getAutomotor().getVehicleElectricCars();
	}
	public ArrayList<Vehicle> getVehicleHybridCars(){
		return this.getAutomotor().getVehicleHybridCars();
	}
	public ArrayList<Vehicle> getVehicleMotorcycles(){
		return this.getAutomotor().getVehicleMotorcycles();
	}
	
	public boolean saveOldCarsInParkinglot() {
		boolean saved;
		saved = this.getAutomotor().saveOldCars();
		return saved;
	}
	

	public void addVehicle(Vehicle vehicle){
		this.automotor.addVehicle(vehicle);
	}
	
	public ArrayList<Vehicle> getVehicles(){
		return this.automotor.getVehicles();
	}
	
	
}
