package model;

public class Soat extends VehicleDocument {
	
	private double coverage;

	public Soat(double price, int year, int[][] picture, double coverage) {
		super(price,year,picture);
		this.coverage = coverage;
	}
	
	

	public double getCoverage() {
		return coverage;
	}



	public void setCoverage(double coverage) {
		this.coverage = coverage;
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
		
		int size_i =  this.getPicture().length;
		int size_j = this.getPicture()[0].length;
//		for(int i = 0;i<size_i;i++) {
//			if(i == size_i-1) {
//				for(int j = 0;j<size_j;j++) {
//					decode += "" + this.getPicture()[i][j];
//				}
//			} else {
//				decode += "" + this.getPicture()[i][0];
//			}
//			
//		}
		int x = 0;
		int y = 0;
		while(x<size_i && y<size_j) {
			
			decode += "" + this.getPicture()[x][y];
			if(x<size_i-1) {
				x++;
			} else {
				y++;
			}
			
		}
		
		return decode;
		
	}

}
