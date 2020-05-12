package model;

import java.util.Arrays;

public abstract class VehicleDocument {

	private double price;
	private int year;
	private int[][] picture;
	
	public abstract String decode();
	
	public VehicleDocument(double price, int year) {
		super();
		this.price = price;
		this.year = year;
		this.picture = this.generatePicture();
	}

	private int[][] generatePicture() {
		int sizePicture = this.getRandomNumber(3,5);
		int[][] pictureGenerated = new int[sizePicture][sizePicture];
		for(int x = 0; x < sizePicture; x++){
			for(int y = 0; y < sizePicture; y++){
				pictureGenerated[x][y] = this.getRandomNumber(1,99);
			}
		}
		return pictureGenerated;
	}

	private int getRandomNumber(int numberMin, int numberMax){
		return (int)(Math.random() * numberMax) + numberMin;
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

	@Override
	public String toString() {
		return "year: " + year + ", picture: " + this.decode();
	}
}
