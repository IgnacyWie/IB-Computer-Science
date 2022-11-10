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

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
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
        while (current != null) {
            current.data.listInfo();
            current = current.next;
        }
    }

    public boolean hasVin(String vin) {
        Node current = head;

        if (head == null) {
            return false;
        }
        while (current != null) {
            if (current.data.vin.equals(vin)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Change This to apply
    public void find(int find) {
    }
}
