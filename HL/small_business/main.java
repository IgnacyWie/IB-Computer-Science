import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Cars cars = new Cars();
		Clients clients = new Clients();


		System.out.println("Car System 1.0: Type help for all of the command.");
		System.out.print("$ ");
	      Scanner sc = new Scanner (System.in);
	      // The main loop of the code
	      while (sc.hasNext() == true ) {
		String s1 = sc.next();
		if(s1.equals("ls_cars")) {
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
		} else if (s1.equals("list_not_rented_cars")) {
			listNotRentedCars(cars, clients);
		} else if (s1.equals("search_cars")) {
			searchCars(cars);
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
		// List all cars without clients
		// TODO
	}

	public static void searchCars(Cars cars) {
		// Search cars by parameters
		// TODO
		String color = promptForInput("Car's Color");
		String model = promptForInput("Car's Model");
		String vin = promptForInput("Car's Vin");
		try{
			int seats = Integer.parseInt(promptForInput("Car's Seats"));
		} catch(Exception e) {
		}
		try{
			int max_speed = Integer.parseInt(promptForInput("Car's Max Speed"));
		} catch(Exception e) {
		}
	}

	public static void addClient(Clients clients) {
		String name = promptForInput("Client's Name");
		String surname = promptForInput("Client's Surname");
		String vin = promptForInput("Client's Rented Car VIN");
		String start_date = promptForInput("Client's Rental Start Date");
		String end_date = promptForInput("Client's Rental End Date");
		String id = promptForInput("Client's ID Number");

		// Conversion occuring, therefore put try
		try {
			int age = Integer.parseInt(promptForInput("Client's Age"));
			clients.add(new Client(id, age, vin, start_date, end_date, name, surname));
			System.out.println("Client Added Succesfully");
		} catch(Exception e) {
			System.out.println("Invalid Data Entered");
		}
	}

	public static void addCar(Cars cars) {
		String color = promptForInput("Car's Color");
		String model = promptForInput("Car's Model");
		String vin = promptForInput("Car's Vin");
		// Conversion occuring, therefore put try
		try {
			int seats = Integer.parseInt(promptForInput("Car's Seats"));
			int max_speed = Integer.parseInt(promptForInput("Car's Max Speed"));
			cars.add(new Car(vin, seats, max_speed, color, model));
			System.out.println("Car Added Succesfully");
		} catch(Exception e) {
			System.out.println("Invalid Data Entered");
		}
	}

	public static String promptForInput(String text) {
		System.out.print(text + ": ");
		Scanner scanner = new Scanner(System.in);
		String s= scanner.nextLine();
		return s;
	}

	// TODO: update that
	public static void displayHelp() {
		System.out.println("clear: Clears the screen for better quality \n ls_cars: displays all cars \n ls_clients: displays all clients \n add_car: Add New Car \n add_client: Add New Client");
	}
}

public class Car {
	String vin = "";
	int seats;
	int speed;
	String color;
	String model;

	public Car(String vin, int seats, int speed, String color, String model) {
		this.vin = vin;
		this.seats = seats;
		this.speed = speed;
		this.color = color;
		this.model = model;
	}

	public void listInfo() {
		System.out.println("=====" + this.model + "=====");
		System.out.println("Car's VIN: " + this.vin);
		System.out.println("Car's Seats: " + this.seats);
		System.out.println("Car's Max Speed: " + this.speed);
		System.out.println("Car's Color: " + this.color);
	}

	public boolean isVin(String vin_c) {
		if(vin_c.equals(this.vin)) {
			return true;
		}
		return false;
	}
}

// If age is equal or bigger than 16 and lower than 18 maxSpeed cannot exceed 50 km/h
// Browsing

// Every client has a car
// Try with VIN or Car class
public class Client {
//	Car rented_car;
	String id;
	int age;
	String vin;
	String start_date;
	String end_date;
	String name;
	String surname;

	public Client(String id, int age, String vin, String start_date, String end_date, String name, String surname) {
		this.id = id;
		this.age = age;
		this.vin = vin;
		this.start_date = start_date;
		this.end_date = end_date;
		this.name = name;
		this.surname = surname;
	}

	public void listInfo() {
		System.out.println("=====" + this.name + " " + this.surname + "====="); 
		System.out.println("Client's Rented Car VIN: " + this.vin);
		System.out.println("Client's Age: " + this.age);
		System.out.println("Client's Rental Start Date: " + this.start_date);
		System.out.println("Client's Rental End Date: " + this.end_date);
		System.out.println("Client's ID Number: " + this.id);
	}
}

public class Clients {
	class Node {
		Client data;
		Node next;

		public Node(Client data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

	public void add(Client data) {
		Node newNode = new Node(data);

		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void listAll() {
		Node current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		while(current != null) {
			current.data.listInfo();
			current = current.next;
		}
	}

	// Change This to apply
	public void find(int find) {}
}

public class Cars {
	class Node {
		Car data;
		Node next;

		public Node(Car data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

	public void add(Car data) {
		Node newNode = new Node(data);

		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void listAll() {
		Node current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		while(current != null) {
			current.data.listInfo();
			current = current.next;
		}
	}

	// Change This to apply
	public void find(int find) {}
}
