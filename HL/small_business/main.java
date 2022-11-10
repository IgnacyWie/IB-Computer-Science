import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Cars cars = new Cars();
		Clients clients = new Clients();

		cars.add(new Car("134131uea", 32, 32, "schwarz", "test"));

		System.out.println("Car System 1.0: Type help for all of the command.");
		System.out.print("$ ");

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext() == true) {
			String s1 = sc.next();
			if (s1.equals("ls_cars")) {
				cars.listAll();
			} else if (s1.equals("ls_clients")) {
				clients.listAll();
			} else if (s1.equals("clear")) {
				clearScreen();
			} else if (s1.equals("help")) {
				displayHelp();
			} else if (s1.equals("add_car")) {
				addCar(cars);
			} else if (s1.contains("add_client")) {
				addClient(clients);
			} else if (s1.equals("exit")) {
				return;
			} else if (s1.equals("ls_not_rented_cars")) {
				listNotRentedCars(cars, clients);
			} else if (s1.equals("search_cars")) {
				searchCars(cars, clients);
			} else if (s1.equals("rent_car")) {
				addClient(clients);
			} else {
				System.out.println("Command Not Found: " + s1);
			}

			System.out.print("$ ");
		}
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void listNotRentedCars(Cars cars, Clients clients) {
		cars.getNotRented(clients);
	}

	public static void searchCars(Cars cars, Clients clients) {
		String color = promptForInput("Car's Color");
		String model = promptForInput("Car's Model");
		String vin = promptForInput("Car's Vin");
		int seats = 0;
		int max_speed = 0;
		Boolean rented = false;

		try {
			seats = Integer.parseInt(promptForInput("Car's Seats"));
		} catch (Exception e) {
		}
		try {
			max_speed = Integer.parseInt(promptForInput("Car's Max Speed"));
		} catch (Exception e) {
		}
		try {
			rented = Boolean.parseBoolean(promptForInput("Car's Rented?"));
		} catch (Exception e) {
		}
		cars.filter(color, model, vin, seats, max_speed, rented, clients);
	}

	public static void addClient(Clients clients) {
		String name = promptForInput("Client's Name");
		String surname = promptForInput("Client's Surname");
		String vin = promptForInput("Client's Rented Car VIN");
		String start_date = promptForInput("Client's Rental Start Date");
		String end_date = promptForInput("Client's Rental End Date");
		String id = promptForInput("Client's ID Number");

		// Conversion occuring, so put try
		try {
			int age = Integer.parseInt(promptForInput("Client's Age"));
			clients.add(new Client(id, age, vin, start_date, end_date, name, surname));
			System.out.println("Client Added Succesfully");
		} catch (Exception e) {
			System.out.println("Invalid Data Entered");
		}
	}

	public static void addCar(Cars cars) {
		String color = promptForInput("Car's Color");
		String model = promptForInput("Car's Model");
		String vin = promptForInput("Car's Vin");

		// Conversion occuring, so put try
		try {
			int seats = Integer.parseInt(promptForInput("Car's Seats"));
			int max_speed = Integer.parseInt(promptForInput("Car's Max Speed"));
			cars.add(new Car(vin, seats, max_speed, color, model));
			System.out.println("Car Added Succesfully");
		} catch (Exception e) {
			System.out.println("Invalid Data Entered");
		}
	}

	public static String promptForInput(String text) {
		System.out.print(text + ": ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		return s;
	}

	public static void displayHelp() {
		System.out.println(
				"clear: Clears the screen for better quality \n ls_cars: displays all cars \n ls_not_rented_cars: List all not rented by clients cars \n add_car: Add New Car \n search_cars: Search Cars \n ls_clients: displays all clients \n add_client: Add New Client \n exit: Exit the program, clearing entire database");
	}
}