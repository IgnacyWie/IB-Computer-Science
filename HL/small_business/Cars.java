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

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void filter(String color, String model, String vin, int seats, int max_speed, boolean rented,
            Clients clients) {
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        while (current != null) {
            if (current.data.matches(color, model, vin, seats, max_speed, rented, clients)) {
                current.data.listInfo();
            }
            current = current.next;
        }
    }

    public void listAll() {
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            current.data.listInfo();
            current = current.next;
        }
    }

    public void getNotRented(Clients clients) {
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        while (current != null) {
            if (!clients.hasVin(current.data.vin)) {
                current.data.listInfo();
            }
            current = current.next;
        }
    }

}
