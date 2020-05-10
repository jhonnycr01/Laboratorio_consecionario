package ui;
import java.util.Scanner;

import model.Automotor;
import model.Concessionaire;
import model.Seller;


public class Main {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Create the ship
		Concessionaire concessionaire = new Concessionaire("AutoCar", "123.456.789-1");
		//1. Create clients
		//2. Create loads / load ship
		//3. updated clients categories 
		//4. setSail Ship / show if the ship can set sail
		//5. Download Ship
		//6. Get Total weight of ship
		
		
		int menu=-1;
		
		while (menu != 0) {
			//======this command is used to clean the console
			cleanScreen();
			System.out.println("******************");
			System.out.println("+ "+ pirate.getName() +" +");
			System.out.println("******************\n");
			System.out.println("1.Create client ");
			System.out.println("2.Create load and load to ship");
			System.out.println("3.Updated clients categories");
			System.out.println("4.can set sail");
			System.out.println("5.Download ship");
			System.out.println("6. Get total weight of ship");
			System.out.println("7. List clients with levels");
			System.out.println("0. exit");

			
			System.out.print("enter option: ");
			menu = sc.nextInt();
			if(menu != 0 ) {
				selectOption(menu, pirate);
			}
		}	
			
			
	}
	
	public static void menu() {
		
	}
		
	public static void registerVehicle(Concessionaire consessionaire) {
		Scanner sc = new Scanner(System.in);
		double totalSalePrice;
		double basePrice;
		String brand;
		String model;
		String vehicleState;
		String plate;
		String soat;
		String tecno;
		String owner;
		
		System.out.println("please enter the total sale price of the vehicle");
		totalSalePrice = sc.nextDouble();
		System.out.println("please enter the base price of the vehicle");
		basePrice= sc.nextDouble();
		System.out.println("please enter the brand of the vehicle");
		brand= sc.nextLine();
		System.out.println("please enter the model of the vehicle");
		model= sc.nextLine();
		System.out.println("please enter the vehicle state");
		vehicleState= sc.nextLine();
		System.out.println("please enter the plate of the vehicle");
		plate= sc.nextLine();
		System.out.println("please enter the owner of the vehicle");
		owner= sc.nextLine();
		Automotor.addVehicle(vehicle);
		System.out.println("vehicle add successfully");
		sc.nextLine();
		sc.nextLine();
	}
	
	public static void registerSeller(Concessionaire consessionaire) {
		Scanner sc = new Scanner(System.in);
		String name; 
		String lastName;
		String id;
		int totalSales;
		
		System.out.println("please enter the name of the seller");
		name= sc.nextLine();
		System.out.println("please enter the last name of the seller");
		lastName= sc.nextLine();
		System.out.println("please enter the id of the seller");
		id= sc.nextLine();
		System.out.println("please enter the total sales of the seller");
		totalSales= sc.nextInt();
		Concessionaire.addSeller(seller);
		System.out.println("seller add successfully");
		sc.nextLine();
		sc.nextLine();
	}
	
	public static void registerClient(Concessionaire consessionaire) {
		Scanner sc = new Scanner(System.in);
		String name;
		String lastName;
		String id;
		String phoneNumber;
		String email;
		
		System.out.println("please enter the name of the client");
		name= sc.nextLine();
		System.out.println("please enter the last name of the client");
		lastName= sc.nextLine();
		System.out.println("please enter the id of the client");
		id= sc.nextLine();
		System.out.println("please enter the phone number of the client");
		phoneNumber= sc.nextLine();
		System.out.println("please enter the email of the client");
		email= sc.nextLine();
		Seller.addClient(client);
		System.out.println("client add successfully");
		sc.nextLine();
		sc.nextLine();
	}
		
	

}
