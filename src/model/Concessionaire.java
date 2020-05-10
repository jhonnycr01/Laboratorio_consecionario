
package model;

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

	public void setAutomotor(Automotor automotor) {
		this.automotor = automotor;
	}

	public void setSellers(ArrayList<Seller> sellers) {
		this.sellers = sellers;
	} 
	
	public void sellVehicle(Vehicle vehicle) {
		double price = vehicle.getTotalSalePrice();
		this.sumTotalGain(price);
		this.sumNumberSales(1);
		this.automotor.removeVehicle(vehicle);
	
		
	}
	
	
}
