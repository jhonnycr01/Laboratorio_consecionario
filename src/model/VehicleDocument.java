package model;

public abstract class VehicleDocument {

	private double price;
	private int year;
	private int[][] picture;
	
	public abstract String decode();
	
	public VehicleDocument(double price, int year, int[][] picture) {
		super();
		this.price = price;
		this.year = year;
		this.picture = picture;
	}



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int[][] getPicture() {
		return picture;
	}

	public void setPicture(int[][] picture) {
		this.picture = picture;
	}
	
	
	

}
