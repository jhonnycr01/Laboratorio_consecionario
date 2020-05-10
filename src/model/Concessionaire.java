
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
	
	public Concessionaire(String name, String nit, double totalGain, int numberSales) {
		this.name = name;
		this.nit = nit;
		this.totalGain = totalGain;
		this.numberSales = numberSales;
		
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



	public void setTotalGain(double totalGain) {
		this.totalGain = totalGain;
	}



	public int getNumberSales() {
		return numberSales;
	}



	public void setNumberSales(int numberSales) {
		this.numberSales = numberSales;
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
	
	
	
	
}
