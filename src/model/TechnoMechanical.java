package model;

public class TechnoMechanical extends VehicleDocument {
	
	public int gasLevel;

	public TechnoMechanical(double price, int year, int[][] picture, int gasLevel) {
		super(price,year,picture);
		this.gasLevel = gasLevel;
	}
	

	public int getGasLevel() {
		return gasLevel;
	}


	public void setGasLevel(int gasLevel) {
		this.gasLevel = gasLevel;
	}


	@Override
	public String decode() {
		String decode = "";
		/*
		 * ij
		 * 00 01 02 03
		 * 10 11 12 13
		 * 20 21 22 23
		 * 30 31 32 33
		 */
		
		int size_x =  this.getPicture().length;
		int size_y = this.getPicture()[0].length;

		int x = 0;
		int y = 0;
		// horizontal path
		while(y<size_y) {
			decode +=  this.getPicture()[0][y];
			y++;
		}
		// diagonal path
		y = size_y -1; // get last index
		while(x>=0) {
			decode +=  this.getPicture()[x][y];
			y--;
			x++;
		}
		// last horizontal path 
		x = size_x -1;
		y = 0;
		while(y<size_y) {
			decode +=  this.getPicture()[x][y];
			y++;
		}
		
		return decode;
		
	}

}
