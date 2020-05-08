package ui;
import java.util.Scanner;

import model.Automotor;
import model.Concessionaire;
import model.Seller;


public class Main {


	public static void main(String[] args) {

		
		
		
		
		
		
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
		
		
	}

}
