package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import model.types.BikeType;
import model.types.CarType;
import model.types.ChargerType;
import model.types.GasType;
import model.types.VehicleState;

public class Main {

	public static String[] names = { "Alba", "Felipa", "Eusebio", "Farid", "Donald", "Alvaro", "Nicolás", "Freddy",
			"Anabel", "Rick", "Murty", "Silvana", "Diomedes", "Nicomedes", "Teodoro" };
	public static String[] lastNames = { "Ruiz", "Sarmiento", "Uribe", "Maduro", "Trump", "Toledo", "Herrera" };
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException {

		// Create Concessioner
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
			sc.nextLine(); // for clean input
			if (menu != 0) {
				selectOption(menu, concessionaire);
			}
		}
		sc.close();

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
			indexNames = getRandomNumber(0, names.length-1);
			indexLastNames = getRandomNumber(0, lastNames.length-1);
			clients.add(new Client(names[indexNames], lastNames[indexLastNames], "" + id, "123456",
					names[indexNames] + "@mail.com"));
			id += 1;

		}
		return clients;
	}

	public static int getRandomNumber(int numberMin, int numberMax) {
		return (int) Math.floor(Math.random() * (numberMax - numberMin + 1) ) + numberMin;
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
			clientInterestingInVehicle(concessionaire);
			break;
		case 7:
			// 7.Save in parking lot old cars
			saveVehicleInParkingLot(concessionaire);
			break;

		}

	}

	public static void registerVehicles(Concessionaire concessionaire) {
		//Variables for all Vehicles
		double totalSalePrice, basePrice;
		String[] brandMotoOptions;
		String[] brandCarOptions;
		String brand, plate;
		int model;
		VehicleState[] vehicleStateOptions;
		VehicleState vehicleState;
		float displacement;
		Soat soat;
		TechnoMechanical techno;
		int yearSoat;
		int yearTechno;
		
		//*********************************
		//Motorcycles
		BikeType[] bikeTypeOptions = BikeType.values();
		BikeType bikeType;
		int gasolineCapacity, gasolineConsume;
		
		brandMotoOptions = new String[] {"Kawasaki","Yamaha","Duke","Honda","Suzuki","BMW"};
		model = 2020;
		vehicleStateOptions = VehicleState.values();
		plate = "MTC0";
		displacement = 800;
		
		for (int x = 0; x < 3; x++) {
			totalSalePrice = getRandomNumber(100, 4000);
			basePrice = totalSalePrice * 0.3;
			brand = brandMotoOptions[getRandomNumber(0,brandMotoOptions.length-1)];
			model = getRandomNumber(2012, 2020);
			vehicleState = vehicleStateOptions[getRandomNumber(0, 1)];
			if(vehicleState == VehicleState.New) {
				yearSoat = 2020;
				yearTechno = 2020;
			} else {
				yearSoat = getRandomNumber(2012, 2020);
				yearTechno = getRandomNumber(2012, 2020);
			}
			soat = new Soat(10, yearSoat, 1000);
			techno = new TechnoMechanical(10, yearTechno, 5);
			displacement = getRandomNumber(250, 1300);
			bikeType = bikeTypeOptions[getRandomNumber(0, bikeTypeOptions.length-1)];
			gasolineCapacity = getRandomNumber(5, 30);
			gasolineConsume = getRandomNumber(10, 150);
			concessionaire.addVehicle(new Motorcycle(totalSalePrice, basePrice, brand, model, vehicleState, plate+x+"A",
					soat, techno, displacement, bikeType, gasolineCapacity, gasolineConsume));
		}
		
		//*********************************
		//Gasoline Cars
		brandCarOptions = new String[] { "Mazda","Tesla","Nissan","Ford", "Toyota", "Chevrolet", "Mercedez", "BMW", "AUDI" };
		CarType[] carTypeOptions = CarType.values();
		CarType carType;
		int numberDoors;
		boolean polarized = true;
		int tankCapacity;
		GasType[] gasTypeOptions = GasType.values();
		GasType gasType;
		int gasConsume;
		
		plate = "GSC00";
		for (int x = 0; x < 6; x++) {
			totalSalePrice = getRandomNumber(2000, 8000);
			basePrice = totalSalePrice * 0.3;
			brand = brandCarOptions[getRandomNumber(0,brandCarOptions.length-1)];
			model = getRandomNumber(2012, 2020);
			vehicleState = vehicleStateOptions[getRandomNumber(0, 1)];
			if(vehicleState == VehicleState.New) {
				yearSoat = 2020;
				yearTechno = 2020;
			} else {
				yearSoat = getRandomNumber(2012, 2020);
				yearTechno = getRandomNumber(2012, 2020);
			}
			soat = new Soat(10, yearSoat, 1000);
			techno = new TechnoMechanical(10, yearTechno, 5);
			displacement = getRandomNumber(1000, 5000);
			carType = carTypeOptions[getRandomNumber(0, carTypeOptions.length-1)];
			numberDoors = getRandomNumber(2, 5);
			polarized = !polarized;
			tankCapacity = getRandomNumber(10, 60);
			gasType = gasTypeOptions[getRandomNumber(1, gasTypeOptions.length-1)];
			gasConsume = getRandomNumber(10, 300);
			/*
			 * GasolineCar(double totalSalePrice, double basePrice, String brand, int model, VehicleState vehicleState,
			String plate, float displacement, Soat soat, TechnoMechanical techno, CarType carType, int numberDoors,
			boolean polarized, int tankCapacity, GasType gasType, int gasConsume)
			 * 
			 * */
			concessionaire.addVehicle(new GasolineCar(totalSalePrice, basePrice, brand, model, vehicleState, plate+x+"",
					displacement,soat,techno,carType,numberDoors,polarized,tankCapacity,gasType,gasConsume));
		}
		
		//*********************************
		//Electric Cars
		int batteryDuration, batteryConsume;
		ChargerType[] chargerTypeOptions = ChargerType.values();
		ChargerType chargerType;
		
		plate = "ELC00";
		for (int x = 0; x < 6; x++) {
			totalSalePrice = getRandomNumber(2000, 8000);
			basePrice = totalSalePrice * 0.3;
			brand = brandCarOptions[getRandomNumber(0,brandCarOptions.length-1)];
			model = getRandomNumber(2012, 2020);
			vehicleState = vehicleStateOptions[getRandomNumber(0, 1)];
			displacement = getRandomNumber(1000, 5000);
			if(vehicleState == VehicleState.New) {
				yearSoat = 2020;
				yearTechno = 2020;
			} else {
				yearSoat = getRandomNumber(2012, 2020);
				yearTechno = getRandomNumber(2012, 2020);
			}
			soat = new Soat(10, yearSoat, 1000);
			techno = new TechnoMechanical(10, yearTechno, 5);
			carType = carTypeOptions[getRandomNumber(0, carTypeOptions.length-1)];
			numberDoors = getRandomNumber(2, 5);
			polarized = !polarized;
			chargerType = chargerTypeOptions[getRandomNumber(1, chargerTypeOptions.length-1)];
			batteryDuration = getRandomNumber(100, 1000);
			batteryConsume = getRandomNumber(10, 200);
			/*
			 * ElectricCar(double totalSalePrice, double basePrice, String brand, int model, VehicleState vehicleState,
			String plate, float displacement, Soat soat, TechnoMechanical techno, ChargerType chargerType,
			int batteryDuration, int batteryConsume)
			 * 
			 * */
			concessionaire.addVehicle(new ElectricCar(totalSalePrice, basePrice, brand, model, vehicleState, plate+x+"",
					displacement,soat,techno,carType,numberDoors,polarized,chargerType,batteryDuration,batteryConsume));
			
			
		}
		
		//*********************************
		//Hybrid Cars
		
		plate = "HBD00";
		for (int x = 0; x < 6; x++) {
			totalSalePrice = getRandomNumber(2000, 8000);
			basePrice = totalSalePrice * 0.3;
			brand = brandCarOptions[getRandomNumber(0,brandCarOptions.length-1)];
			model = getRandomNumber(2012, 2020);
			vehicleState = vehicleStateOptions[getRandomNumber(0, 1)];
			displacement = getRandomNumber(1000, 5000);
			if(vehicleState == VehicleState.New) {
				yearSoat = 2020;
				yearTechno = 2020;
			} else {
				yearSoat = getRandomNumber(2012, 2020);
				yearTechno = getRandomNumber(2012, 2020);
			}
			soat = new Soat(10, yearSoat, 1000);
			techno = new TechnoMechanical(10, yearTechno, 5);
			carType = carTypeOptions[getRandomNumber(0, carTypeOptions.length-1)];
			numberDoors = getRandomNumber(2, 5);
			polarized = !polarized;
			chargerType = chargerTypeOptions[getRandomNumber(1, chargerTypeOptions.length-1)];
			batteryDuration = getRandomNumber(100, 1000);
			batteryConsume = getRandomNumber(10, 200);
			tankCapacity = getRandomNumber(10, 60);
			gasType = gasTypeOptions[getRandomNumber(1, gasTypeOptions.length-1)];
			gasConsume = getRandomNumber(10, 300);
			/*
			 *  HybridCar(double totalSalePrice, double basePrice, String brand, int model, VehicleState vehicleState,
				String plate, float displacement, Soat soat, TechnoMechanical techno, ChargerType chargerType,
				int batteryDuration, int batteryConsume, int tankCapacity, GasType gasType, int gasConsume)
			 * 
			 * */
			concessionaire.addVehicle(new HybridCar(totalSalePrice, basePrice, brand, model, vehicleState, plate+x+"",
					displacement,soat,techno,carType,numberDoors,polarized,chargerType,batteryDuration,batteryConsume, tankCapacity, gasType, gasConsume));
		}
	}

	public static void registerSeller(Concessionaire concessionaire) {
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
		float displacement;
		CarType carType;
		GasType gasType;
		int numberDoors,polarizedOption,carTypeOption;
		Boolean polarized;
		Vehicle vehicle = null;

		System.out.println("please enter the total sale price of the vehicle");
		totalSalePrice = sc.nextDouble();
		sc.nextLine();
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
		sc.nextLine();
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
		// **************************************************
		System.out.println("please enter the displacement of Vehicle:");
		displacement = sc.nextInt();
		sc.nextLine();
		// **************************************************		
		System.out.println("Please select the type of car:");
		showCarType();
		System.out.print("type the number of option: ");
		carTypeOption = sc.nextInt();
		sc.nextLine();
		carType = getCarType(carTypeOption);
		// **************************************************
		System.out.println("Please enter the numbers doors of vehicle");
		numberDoors = sc.nextInt();
		sc.nextLine();
		// **************************************************
		System.out.println("Please enter if the vehicle is polarized: ");
		System.out.println("1. yes ");
		System.out.println("2. No ");
		polarizedOption = sc.nextInt();
		sc.nextLine();
		polarized = polarizedOption == 1;
		// **************************************************
		
		Soat soat = new Soat(basePrice * 0.1, soatYear, basePrice * 100);
		TechnoMechanical technoMechanical = new TechnoMechanical(basePrice * 0.05, technoYear, 10);

		switch (vehicleType) {
		case 1:
			// Motorcycle
			vehicle = createMotorcycle(totalSalePrice, basePrice, brand, model, vehicleState, plate,soat,
					technoMechanical,displacement);
			break;
		case 2:
			// Electric Car
			vehicle = createElectricCar(totalSalePrice, basePrice, brand, model, vehicleState, plate,soat,
					technoMechanical,displacement,carType,numberDoors,polarized);
			break;
		case 3:
			// Hybrid Car
			vehicle = createHybridCar(totalSalePrice, basePrice, brand, model, vehicleState, plate,soat,
					technoMechanical,displacement,carType,numberDoors,polarized);
			break;
		case 4:
			// Gasoline Car
			vehicle = createGasolineCar(totalSalePrice, basePrice, brand, model, vehicleState, plate,soat,
					technoMechanical,displacement,carType,numberDoors,polarized);
			break;
		}
		concessionaire.addVehicle(vehicle);
		System.out.println("vehicle add successfully");
		sc.nextLine();
	}
	
	public static HybridCar createHybridCar(double totalSalePrice, double basePrice, String brand, int model,
			VehicleState vehicleState, String plate, Soat soat, TechnoMechanical technoMechanical,float displacement,CarType carType, int numberDoors,
			boolean polarized) {
		int batteryDuration, batteryConsume, tankCapacity, gasTypeOption, gasConsume;
		int chargerTypeOption;
		ChargerType chargerType;
		GasType gasType;
		HybridCar hybridCar = null;

		System.out.println("Please select the Charger type of vehicle:");
		showChargerType();
		System.out.print("type the number of option: ");
		chargerTypeOption = sc.nextInt();
		sc.nextLine();
		chargerType = getChargerType(chargerTypeOption);
		// **************************************************
		System.out.println("Please enter the battery duration");
		batteryDuration = sc.nextInt();
		sc.nextLine();
		// **************************************************
		System.out.println("Please enter the battery consume consume");
		batteryConsume = sc.nextInt();
		sc.nextLine();
		// **************************************************
		System.out.println("Please enter the tank capacity");
		tankCapacity = sc.nextInt();
		sc.nextLine();
		// **************************************************
		System.out.println("Please select the type of Gas:");
		showGasType();
		System.out.print("type the number of option: ");
		gasTypeOption = sc.nextInt();
		sc.nextLine();
		gasType = getGasType(gasTypeOption);
		// **************************************************
		System.out.println("Please enter the gasoline consume");
		gasConsume = sc.nextInt();
		sc.nextLine();
		// **************************************************
		/*
		 *HybridCar(double totalSalePrice, double basePrice, String brand, int model, VehicleState vehicleState,
			String plate, float displacement, Soat soat, TechnoMechanical techno, CarType carType, int numberDoors,
			boolean polarized, ChargerType chargerType,
			int batteryDuration, int batteryConsume, int tankCapacity, GasType gasType, int gasConsume) 
		 */
		hybridCar = new HybridCar(totalSalePrice, basePrice, brand, model, vehicleState, plate,displacement,
				soat,technoMechanical,carType,numberDoors,polarized, chargerType, batteryDuration, batteryConsume,tankCapacity,gasType,gasConsume );
		return hybridCar;
	}
	
	public static GasolineCar createGasolineCar(double totalSalePrice, double basePrice, String brand, int model,
			VehicleState vehicleState, String plate, Soat soat, TechnoMechanical technoMechanical, float displacement,CarType carType, int numberDoors,
			boolean polarized) {
		int tankCapacity, gasolineConsume, gasTypeOption;
		GasType gasType;
		GasolineCar gasolineCar = null;

		System.out.println("Please enter the tank capacity");
		tankCapacity = sc.nextInt();
		sc.nextLine();
		// **************************************************
		System.out.println("Please enter the gasoline consume");
		gasolineConsume = sc.nextInt();
		sc.nextLine();
		// **************************************************
		
		System.out.println("Please select the type of Gas:");
		showGasType();
		System.out.print("type the number of option: ");
		gasTypeOption = sc.nextInt();
		sc.nextLine();
		gasType = getGasType(gasTypeOption);
		// **************************************************
		/*
		 * GasolineCar(double totalSalePrice, double basePrice, String brand, int model, VehicleState vehicleState,
			String plate, float displacement, Soat soat, TechnoMechanical techno, CarType carType, int numberDoors,
			boolean polarized, int tankCapacity, GasType gasType, int gasConsume) 
		 */
		gasolineCar = new GasolineCar(totalSalePrice, basePrice, brand, model, vehicleState, plate,displacement,
				soat,technoMechanical, carType, numberDoors,polarized,tankCapacity,gasType , gasolineConsume);
		return gasolineCar;
	}
	
	public static ElectricCar createElectricCar(double totalSalePrice, double basePrice, String brand, int model,
			VehicleState vehicleState, String plate, Soat soat, TechnoMechanical technoMechanical,float displacement,CarType carType, int numberDoors,
			boolean polarized) {
		int batteryDuration, batteryConsume;
		int chargerTypeOption;
		ChargerType chargerType;
		ElectricCar electricCar = null;

		System.out.println("Please select the Charger type of vehicle:");
		showChargerType();
		System.out.print("type the number of option: ");
		chargerTypeOption = sc.nextInt();
		sc.nextLine();
		chargerType = getChargerType(chargerTypeOption);
		// **************************************************
		System.out.println("Please enter the battery duration");
		batteryDuration = sc.nextInt();
		sc.nextLine();
		// **************************************************
		System.out.println("Please enter the battery consume consume");
		batteryConsume = sc.nextInt();
		sc.nextLine();
		// **************************************************
		/*
		 * ElectricCar(double totalSalePrice, double basePrice, String brand, int model, VehicleState vehicleState,
			String plate, float displacement, Soat soat, TechnoMechanical techno, ChargerType chargerType,
			int batteryDuration, int batteryConsume)
		 */
		electricCar = new ElectricCar(totalSalePrice, basePrice, brand, model, vehicleState, plate,displacement,
				soat,technoMechanical, carType,numberDoors,polarized, chargerType, batteryDuration, batteryConsume);
		return electricCar;
	}

	public static Motorcycle createMotorcycle(double totalSalePrice, double basePrice, String brand, int model,
			VehicleState vehicleState, String plate, Soat soat, TechnoMechanical technoMechanical, float displacement) {
		int gasolineCapacity;
		int gasolineConsume;
		int bikeTypeOption;
		BikeType bikeType;
		Motorcycle motorcycle = null;

		System.out.println("Please enter the gasoline capacity");
		gasolineCapacity = sc.nextInt();
		sc.nextLine();
		// **************************************************
		System.out.println("Please enter the gasoline consume");
		gasolineConsume = sc.nextInt();
		sc.nextLine();
		// **************************************************
		System.out.println("Please select the type of motorcycle:");
		showBikeType();
		System.out.print("type the number of option: ");
		bikeTypeOption = sc.nextInt();
		sc.nextLine();
		bikeType = getBikeType(bikeTypeOption);
		// **************************************************
		motorcycle = new Motorcycle(totalSalePrice, basePrice, brand, model, vehicleState, plate,
				soat,technoMechanical , displacement,
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
	
	public static ChargerType getChargerType(int option) {
		return ChargerType.values()[option - 1];
	}
	
	public static void showChargerType() {
		for (int x = 0; x < ChargerType.values().length; x++) {
			System.out.println((x + 1) + ". " + ChargerType.values()[x].toString());
		}
	}
	
	public static CarType getCarType(int option) {
		return CarType.values()[option - 1];
	}
	
	public static void showCarType() {
		for (int x = 0; x < CarType.values().length; x++) {
			System.out.println((x + 1) + ". " + CarType.values()[x].toString());
		}
	}
	
	public static GasType getGasType(int option) {
		return GasType.values()[option - 1];
	}
	
	public static void showGasType() {
		for (int x = 0; x < GasType.values().length; x++) {
			System.out.println((x + 1) + ". " + GasType.values()[x].toString());
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
		String name;
		String lastName;
		String id;
		String phoneNumber;
		String email;
		boolean attended;

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
		attended = consessionaire.attendClient(new Client(name, lastName, id, phoneNumber, email));
		if(attended) {
			System.out.println("client add successfully");
		}else {
			System.out.println("client service was not possible no sellers available... need more sellers");
		}
		sc.nextLine();
	}
	// ***************************************************
	// + End registerClient +
	// ***************************************************
	// ***************************************************
	// + listVehicles +
	// ***************************************************

	public static void listVehicles(Concessionaire concessionaire) {
		int option;
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		showFilterOptions();
		System.out.print("\nPlease enter option filter: ");
		option = sc.nextInt();
		sc.nextLine();
		switch (option) {
		case 1:
			//1. Type of Vehicle
			vehicles = showOptionsVehicleState(concessionaire);
			break;
		case 2:
			//2. Gasoline cars
			vehicles = concessionaire.getVehicleGasolineCars();
			break;
		case 3:
			//3. Electric cars
			vehicles = concessionaire.getVehicleElectricCars();
			break;
		case 4:
			//4. Hybrid cars
			vehicles = concessionaire.getVehicleHybridCars();
			break;
		case 5:
			//5. Motorcycles
			vehicles = concessionaire.getVehicleMotorcycles();
			break;
		}
		if(vehicles.size()>0) {
			System.out.println(vehicles.toString());			
		} else {
			System.out.println("*****************************");
			System.out.println("There are no vehicles to show");
			System.out.println("*****************************");
		}
		System.out.println("press any key to continue...");
		sc.nextLine();
	}
	
	public static ArrayList<Vehicle> showOptionsVehicleState(Concessionaire concessionaire) {
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		System.out.println("");
		showVehicleState();
		System.out.println("3. All");
		int option = sc.nextInt();
		sc.nextLine();
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
		
		return vehicles;
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

	// ***************************************************
	// + 				Sell Vehicle					 +
	// ***************************************************
	public static void sellVehicle(Concessionaire concessionaire) {
		//1. First List Sellers
		Seller seller = getSeller(concessionaire);
		// ******************************************
		//2. Second List Clients of Seller selected
		Client client = getClientsOfSeller(seller);
		// ******************************************
		//3. select the vehicle from the customer's list of interested vehicles
		Vehicle vehicle = getVehicleFromClient(client);
		// ******************************************
		// 4. Call method for sell
		if(vehicle != null) {
			concessionaire.sellVehicle(vehicle, seller,client);
			System.out.println("Vehicle Sold");
			sc.nextLine();			
		} else {
			System.out.println("Vehicle not selected could not be sold");
			System.out.println("press any key to continue...");
			sc.nextLine();
		}
	}
	
	public static Vehicle getVehicleFromClient(Client client) {
		if(client == null) {
			return null;
		}
		int indexVehicle;
		Vehicle vehicle = null;
		System.out.println("Please select vehicle to sell: ");
		showListVehiclesToSell(client.getInterestVehicles());
		System.out.print("Enter option number of vehicle: ");
		indexVehicle = sc.nextInt();
		sc.nextLine(); // for clean the input
		if(indexVehicle > client.getInterestVehicles().size()) {
			System.out.println("Option invalid...");
		} else {
			vehicle = client.getInterestVehicles().get(indexVehicle - 1);
		}
		return vehicle;
	}
	
	public static Client getClientsOfSeller(Seller seller) {
		if(seller == null) {
			return null;
		}
		int indexClient;
		Client client = null; 
		showListClientsofSeller(seller);
		System.out.println("Enter option number of Client: ");
		indexClient = sc.nextInt();
		sc.nextLine(); // for clean the input
		if(indexClient > 0 && indexClient <= seller.getClients().size()) {
			client = seller.getClients().get(indexClient - 1);
		} else {
			System.out.println("Option invalid...");
		}
		
		return client;
	}
	
	public static Seller getSeller(Concessionaire concessionaire) {
		int indexSeller;
		Seller seller = null;
		showListSellers(concessionaire);
		System.out.println("Enter option number of Seller: ");
		indexSeller = sc.nextInt();
		sc.nextLine(); // for clean the input
		if(indexSeller > 0 && indexSeller <= concessionaire.getSellers().size()) {
			seller = concessionaire.getSellers().get(indexSeller - 1);
		} 
		return seller;
	}
	
	public static void showListClientsofSeller(Seller seller) {
		showListPerson((Person[])seller.getClients().toArray(new Person[seller.getClients().size()]));
	}
	
	public static void showListPerson(Person[] persons) {
		int index = 1;
		for (Person person : persons) {
			System.out.println("\n==================");
			System.out.println(index + ". " + person.toString());	
			index++;
		}
		System.out.println("\n");
	}
	
	public static void showListSellers(Concessionaire concessionaire) {
		showListPerson((Person[])concessionaire.getSellers().toArray(new Person[concessionaire.getSellers().size()]));
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
		System.out.println("\n");
	}
	
	// ***************************************************
	// + 				End Sell Vehicle				 +
	// ***************************************************
	// ***************************************************
	// + 		Save Old Vehicle in Parking Lot			 +
	// ***************************************************
	public static void saveVehicleInParkingLot(Concessionaire concessionaire) {
		System.out.println("...Saving cars old in parking lot");
		if(concessionaire.saveOldCarsInParkinglot()) {
			System.out.println("\nThe old cars already saved in parking lot");
		} else {
			System.out.println("\nThere some problems for saved car because is full the parking lot");
		}
		System.out.println("\n press any key to continue");
		sc.nextLine();
		
	}
	// ***************************************************
	// + 		End Save Old Vehicle in Parking Lot		 +
	// ***************************************************
	
	// ***************************************************
	// +	 	interest client in vehicle			 	 +
	// ***************************************************
	public static void clientInterestingInVehicle(Concessionaire concessionaire) {
		//List vehicles for choose one for add to list vehicles interested of client
		int vehicleIndex;
		Vehicle chosenVehicle;
		Seller seller = getSeller(concessionaire);		
		Client client = getClientsOfSeller(seller);
		if(client != null) {
			showVehiclesWithNumberIndex(concessionaire);
			System.out.println("Please enter option number to choose a vehicle");
			vehicleIndex = sc.nextInt();
			sc.nextLine();
			if(vehicleIndex > 0 && vehicleIndex <= concessionaire.getVehicles().size()) {
				chosenVehicle = concessionaire.getVehicles().get(vehicleIndex - 1);
				client.interestVehicle(chosenVehicle);
			} else {
				System.out.println("Option invalid...");
			}
			
		} else {
			System.out.println("Option invalid... Error in select client or seller");
		}
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}
	
	public static void showVehiclesWithNumberIndex(Concessionaire concessionaire) {
		int index = 1;		
		for(Vehicle vehicle: concessionaire.getVehicles()) {
			System.out.println("========================");
			System.out.println("Option Number: "+ index);
			System.out.println(vehicle.toString());
			index++;
		}		
	}
	// ***************************************************
	// +	 	End interest client in vehicle			 +
	// ***************************************************
	
	
}
