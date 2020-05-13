package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import model.types.BikeType;
import model.types.VehicleState;

public class Main {

	public static String[] names = { "Alba", "Felipa", "Eusebio", "Farid", "Donald", "Alvaro", "Nicolás", "Freddy",
			"Anabel", "Rick", "Murty", "Silvana", "Diomedes", "Nicomedes", "Teodoro" };
	public static String[] lastNames = { "Ruiz", "Sarmiento", "Uribe", "Maduro", "Trump", "Toledo", "Herrera" };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Create the ship
		Concessionaire concessionaire = new Concessionaire("AutoCar", "123.456.789-1");
		createSellersAndClients(concessionaire); // Create 10 sellers and clients
		registerVehicles(concessionaire);
		int menu = -1;

		while (menu != 0) {
			// ======this command is used to clean the console
			cleanScreen();
			System.out.println("******************");
			System.out.println("+ " + concessionaire.getName() + " +");
			System.out.println("******************\n");
			System.out.println("1.Register seller ");
			System.out.println("2.Register Client ");
			System.out.println("3.Register vehicle");
			System.out.println("4.list Vehicles");
			System.out.println("5.Sell vehicle");
			System.out.println("6.Vehicle interested client");
			System.out.println("7.Save in parking lot old cars");
			System.out.println("0. exit");

			System.out.print("enter option: ");
			menu = sc.nextInt();
			if (menu != 0) {
				selectOption(menu, concessionaire);
			}
		}

	}

	public static void cleanScreen() {
		try { 
			final String os = System.getProperty("os.name"); 
			if (os.contains("Windows")) { 
				Runtime.getRuntime().exec("cls"); 
			} else { 
				Runtime.getRuntime().exec("clear"); 
			} 
		} catch (final Exception e) {
			
		}

	}

	public static void createSellersAndClients(Concessionaire concessionaire) {
		concessionaire.addSeller(new Seller("Jeniffer", "Rosales", "100"));
		concessionaire.addSeller(new Seller("Pedro", "Jaramillo", "200"));
		concessionaire.addSeller(new Seller("Luis", "Cortes", "300"));
		concessionaire.addSeller(new Seller("Juan", "Alzate", "400"));
		concessionaire.addSeller(new Seller("Cindy", "Caicedo", "500"));
		concessionaire.addSeller(new Seller("Paola", "gomez", "600"));
		concessionaire.addSeller(new Seller("Carlos", "Mora", "700"));
		concessionaire.addSeller(new Seller("John", "martinez", "800"));
		concessionaire.addSeller(new Seller("Sandra", "Hernandez", "900"));
		concessionaire.addSeller(new Seller("Liliana", "Mora", "1000"));

		createClients(concessionaire, 50);
	}

	public static void createClients(Concessionaire concessionaire, int quantity) {
		ArrayList<Client> clients = generateClients(quantity);
		for (Client client : clients) {
			concessionaire.attendClient(client);
		}

	}

	public static ArrayList<Client> generateClients(int quantity) {
		ArrayList<Client> clients = new ArrayList<>();
		int indexNames = 0;
		int indexLastNames = 0;
		int id = 100;
		while (quantity > 0) {
			quantity--;
			indexNames = getRandomNumber(0, names.length);
			indexLastNames = getRandomNumber(0, lastNames.length);
			clients.add(new Client(names[indexNames], lastNames[indexLastNames], "" + id, "123456",
					names[indexNames] + "@mail.com"));
			id += 1;

		}
		return clients;
	}

	public static int getRandomNumber(int numberMin, int numberMax) {
		return (int) (Math.random() * numberMax) + numberMin;
	}

	public static void selectOption(int menu, Concessionaire concessionaire) {
		switch (menu) {
		case 1:
			// 1.register Seller
			registerSeller(concessionaire);
			break;
		case 2:
			// 2. Register Client
			registerClient(concessionaire);
			break;
		case 3:
			// 3. Register vehicle
			registerVehicle(concessionaire);

			break;
		case 4:
			// 4.List Vehicles");
			listVehicles(concessionaire);
			break;
		case 5:
			// "5.Sell vehicle"
			sellVehicle(concessionaire);
			break;
		case 6:
			// 6.Vehicle interested client
			break;
		case 7:
			// 7.Save in parking lot old cars
			break;

		}

	}

	public static void registerVehicles(Concessionaire concessionaire) {
		for (int x = 0; x < 10; x++) {
			concessionaire.addVehicle(new Motorcycle(100, 80, "Kawasaki", 2020, VehicleState.New, "pla123",
					new Soat(10, 2020, 1000), new TechnoMechanical(10, 2020, 5), 800, BikeType.SPORT, 17, 100));
		}
	}

	public static void registerSeller(Concessionaire concessionaire) {
		Scanner sc = new Scanner(System.in);
		String name;
		String lastName;
		String id;

		System.out.println("please enter the name of the seller");
		name = sc.nextLine();
		System.out.println("please enter the last name of the seller");
		lastName = sc.nextLine();
		System.out.println("please enter the id of the seller");
		id = sc.nextLine();
//		System.out.println("please enter the total sales of the seller");
//		totalSales= sc.nextInt();

		concessionaire.addSeller(new Seller(name, lastName, id));
		System.out.println("seller add successfully");
		sc.nextLine();
	}

	// ***************************************************
	// + RegisterVehicle +
	// ***************************************************

	public static void registerVehicle(Concessionaire concessionaire) {
		Scanner sc = new Scanner(System.in);
		double totalSalePrice;
		double basePrice;
		String brand;
		int model;
		int vehicleStateOption;
		VehicleState vehicleState;
		String plate;
		int soatYear;
		int technoYear;
		int vehicleType;
		Vehicle vehicle = null;

		System.out.println("please enter the total sale price of the vehicle");
		totalSalePrice = sc.nextDouble();
		// **************************************************
		System.out.println("please enter the base price of the vehicle");
		basePrice = sc.nextDouble();
		sc.nextLine();
		// **************************************************
		System.out.println("please enter the brand of the vehicle");
		brand = sc.nextLine();
		// **************************************************
		System.out.println("please enter the model of the vehicle (year)");
		model = sc.nextInt();
		sc.nextLine();
		// **************************************************
		showVehicleState();
		System.out.print("please enter the vehicle state: ");
		vehicleStateOption = sc.nextInt();
		vehicleState = getVehicleState(vehicleStateOption);
		// **************************************************
		System.out.println("please enter the plate of the vehicle");
		plate = sc.nextLine();
		// **************************************************
		showVehicleTypes();
		System.out.print("Please enter number correspond to vehicle type: ");
		vehicleType = sc.nextInt();
		sc.nextLine();
		// **************************************************
		System.out.println("please enter the year of SOAT:");
		soatYear = sc.nextInt();
		sc.nextLine();
		// **************************************************
		System.out.println("please enter the year of Techno Mechanical:");
		technoYear = sc.nextInt();
		sc.nextLine();
		
		Soat soat = new Soat(basePrice * 0.1, soatYear, basePrice * 100);
		TechnoMechanical technoMechanical = new TechnoMechanical(basePrice * 0.05, technoYear, 10);

		switch (vehicleType) {
		case 1:
			// Motorcycle
			vehicle = createMotorcycle(totalSalePrice, basePrice, brand, model, vehicleState, plate,soat,technoMechanical);
			break;
		case 2:
			// Electric Car
			break;
		case 3:
			// Hybrid Car
			break;
		case 4:
			// Gasoline Car
			break;
		}
		concessionaire.addVehicle(vehicle);
		System.out.println("vehicle add successfully");
		sc.nextLine();
	}

	public static Motorcycle createMotorcycle(double totalSalePrice, double basePrice, String brand, int model,
			VehicleState vehicleState, String plate, Soat soat, TechnoMechanical technoMechanical) {
		Scanner sc = new Scanner(System.in);
		int gasolineCapacity;
		int gasolineConsume;
		int bikeTypeOption;
		BikeType bikeType;
		Motorcycle motorcycle = null;

		System.out.println("Please enter the gasoline capacity");
		gasolineCapacity = sc.nextInt();
		// **************************************************
		System.out.println("Please enter the gasoline consume");
		gasolineConsume = sc.nextInt();
		// **************************************************
		System.out.println("Please select the type of motorcycle:");
		showBikeType();
		System.out.print("type the number of option: ");
		bikeTypeOption = sc.nextInt();
		bikeType = getBikeType(bikeTypeOption);
		// **************************************************
		motorcycle = new Motorcycle(totalSalePrice, basePrice, brand, model, vehicleState, plate,
				soat,technoMechanical , 650,
				bikeType, gasolineCapacity, gasolineConsume);
		return motorcycle;
	}

	public static void showVehicleTypes() {
		System.out.println("1. MotorCycle");
		System.out.println("2. Electric Car");
		System.out.println("3. Hybrid Car");
		System.out.println("4. Gasoline Car");
	}

	public static BikeType getBikeType(int option) {
		return BikeType.values()[option - 1];
	}

	public static void showBikeType() {
		for (int x = 0; x < BikeType.values().length; x++) {
			System.out.println((x + 1) + ". " + BikeType.values()[x].toString());
		}
	}

	public static VehicleState getVehicleState(int option) {
		return VehicleState.values()[option - 1];
	}

	public static void showVehicleState() {
		for (int x = 0; x < VehicleState.values().length; x++) {
			System.out.println((x + 1) + ". " + VehicleState.values()[x].toString());
		}
	}

	// ***************************************************
	// + End RegisterVehicle +
	// ***************************************************

	// ***************************************************
	// + registerClient +
	// ***************************************************
	public static void registerClient(Concessionaire consessionaire) {
		Scanner sc = new Scanner(System.in);
		String name;
		String lastName;
		String id;
		String phoneNumber;
		String email;

		System.out.println("please enter the name of the client");
		name = sc.nextLine();
		System.out.println("please enter the last name of the client");
		lastName = sc.nextLine();
		System.out.println("please enter the id of the client");
		id = sc.nextLine();
		System.out.println("please enter the phone number of the client");
		phoneNumber = sc.nextLine();
		System.out.println("please enter the email of the client");
		email = sc.nextLine();
		consessionaire.attendClient(new Client(name, lastName, id, phoneNumber, email));
		System.out.println("client add successfully");
		sc.nextLine();
	}
	// ***************************************************
	// + End registerClient +
	// ***************************************************
	// ***************************************************
	// + listVehicles +
	// ***************************************************

	public static void listVehicles(Concessionaire concessionaire) {
		Scanner sc = new Scanner(System.in);
		int option;
		showFilterOptions();
		System.out.print("\nPlease enter option filter: ");
		option = sc.nextInt();
		switch (option) {
		case 1:
			showOptionsVehicleState(concessionaire);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		}
	}

	public static void showOptionsVehicleState(Concessionaire concessionaire) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		System.out.println("");
		showVehicleState();
		System.out.println("3. All");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			// New
			vehicles = concessionaire.getVehicleByState(VehicleState.New);
			break;
		case 2:
			// Used
			vehicles = concessionaire.getVehicleByState(VehicleState.Used);
			break;
		case 3:
			// All
			vehicles = concessionaire.getVehicleByState();
			break;
		}
		System.out.println(vehicles.toString());
	}

	public static void showFilterOptions() {
		System.out.println("1. Type of Vehicle");
		System.out.println("2. Gasoline cars");
		System.out.println("3. Electric cars");
		System.out.println("4. Hybrid cars");
		System.out.println("5. Motorcycles");
	}
	// ***************************************************
	// + End listVehicles +
	// ***************************************************

	public static void sellVehicle(Concessionaire concessionaire) {
		Scanner sc = new Scanner(System.in);
		//1. First List Sellers
		Seller seller = getSeller(sc,concessionaire);
		// ******************************************
		//2. Second List Clients of Seller selected
		Client client = getClientsOfSeller(sc,seller);
		// ******************************************
		//3. select the vehicle from the customer's list of interested vehicles
		Vehicle vehicle = getVehicleFromClient(sc,client);
		// ******************************************
		// 4. Call method for sell
		concessionaire.sellVehicle(vehicle, seller,client);
		System.out.println("Vehicle Sold");
		sc.nextLine();
		sc.close();
	}
	
	public static Vehicle getVehicleFromClient(Scanner sc,Client client) {
		
		int indexVehicle;
		System.out.println("Please select vehicle to sell: ");
		showListVehiclesToSell(client.getInterestVehicles());
		System.out.print("Enter option number of vehicle: ");
		indexVehicle = sc.nextInt();
		sc.nextLine(); // for clean the input
		Vehicle vehicle = client.getInterestVehicles().get(indexVehicle - 1);
		return vehicle;
	}
	
	public static Client getClientsOfSeller(Scanner sc,Seller seller) {
		int indexClient;
		showListClientsofSeller(seller);
		System.out.println("Enter option number of Client: ");
		indexClient = sc.nextInt();
		sc.nextLine(); // for clean the input
		Client client = seller.getClients().get(indexClient - 1);
		return client;
	}
	
	public static Seller getSeller(Scanner sc,Concessionaire concessionaire) {
		int indexSeller;
		showListSellers(concessionaire);
		System.out.println("Enter option number of Seller: ");
		indexSeller = sc.nextInt();
		sc.nextLine(); // for clean the input
		Seller seller = concessionaire.getSellers().get(indexSeller - 1);
		return seller;
	}
	
	public static void showListClientsofSeller(Seller seller) {
		showListPerson((Person[])seller.getClients().toArray());
	}
	
	public static void showListPerson(Person[] persons) {
		int index = 1;
		for (Person person : persons) {
			System.out.println("\n==================");
			System.out.println(index + ". " + person.toString());
			System.out.println("====================\n");
		}
	}
	public static void showListSellers(Concessionaire concessionaire) {
		showListPerson((Person[])concessionaire.getSellers().toArray());
	}

	public static void showListVehiclesToSell(ArrayList<Vehicle> vehicles) {
		int index = 1;
		for (Vehicle vehicle : vehicles) {
			System.out.println("===================");
			System.out.println("Option: " + index);
			System.out.println(vehicle.toString());
			System.out.println("===================");
			index++;
		}
		System.out.println("\n\n\n");
	}

}
