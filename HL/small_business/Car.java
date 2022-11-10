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

    public boolean matches(String color, String model, String vin, int seats, int max_speed, boolean rented,
            Clients clients) {
        if (!color.isEmpty() && !color.matches(this.color)) {
            return false;
        }

        if (!model.isEmpty() && !model.matches(this.model)) {
            return false;
        }

        if (!vin.isEmpty() && !vin.matches(this.vin)) {
            return false;
        }

        if (max_speed > 0 && max_speed != this.speed) {
            return false;
        }

        if (seats > 0 && speed != this.speed) {
            return false;
        }

        if (rented && clients.hasVin(this.vin)) {
            return false;
        }

        return true;
    }

    public boolean isVin(String vin_c) {
        if (vin_c.equals(this.vin)) {
            return true;
        }
        return false;
    }
}