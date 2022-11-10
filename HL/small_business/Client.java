public class Client {
    // Car rented_car;
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
